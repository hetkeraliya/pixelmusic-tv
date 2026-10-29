package com.unshoo.pixelmusic.core.platform

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.js.newSingleThreadContext
import kotlinx.coroutines.js.windowScope
import kotlinx.serialization.json.Json
import org.khronos.webgl.WebGL2RenderingContext
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.HTMLImageElement
import org.w3c.dom.window
import org.w3c.dom.window.fetch
import org.w3c.dom.window.localStorage
import org.w3c.dom.window.setTimeout
import kotlin.js.JsPromise
import kotlin.js.await
import kotlin.js.then
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlinx.coroutines.CompletableDeferred

actual class PlatformDispatchers actual constructor() {
    // In Wasm/JS, we use a single-threaded context for main
    private val mainDispatcher = newSingleThreadContext("Main")
    private val defaultDispatcher = newSingleThreadContext("Default")
    private val ioDispatcher = newSingleThreadContext("IO")

    actual val io: CoroutineDispatcher = ioDispatcher
    actual val main: CoroutineDispatcher = mainDispatcher
    actual val default: CoroutineDispatcher = defaultDispatcher
}

actual class PlatformFileSystem {
    // Web uses IndexedDB or localStorage for persistence
    // For file access, we use the File System Access API or input elements

    actual fun getMusicDirectories(): List<String> {
        // Web doesn't have direct filesystem access without user permission
        // Return empty list - user will pick files via file picker
        return emptyList()
    }

    actual fun readFile(path: String): ByteArray {
        // Not directly accessible on web
        throw UnsupportedOperationException("Direct file read not supported on web. Use file picker.")
    }

    actual fun writeFile(path: String, data: ByteArray) {
        // Use File System Access API or download
        throw UnsupportedOperationException("Direct file write not supported on web. Use file picker.")
    }

    actual fun deleteFile(path: String): Boolean {
        throw UnsupportedOperationException("Direct file delete not supported on web.")
    }

    actual fun fileExists(path: String): Boolean {
        return false
    }

    actual fun listFiles(path: String): List<String> {
        return emptyList()
    }

    // Web-specific: pick files using file picker
    suspend fun pickMusicFiles(accept: String = "audio/*"): List<org.w3c.dom.File> = suspendCoroutine { cont ->
        val input = window.document.createElement("input") as org.w3c.dom.HTMLInputElement
        input.type = "file"
        input.accept = accept
        input.multiple = true
        input.onchange = { event ->
            val files = (event.target as? org.w3c.dom.HTMLInputElement)?.files
            val fileList = mutableListOf<org.w3c.dom.File>()
            files?.let {
                for (i in 0 until it.length) {
                    it[i]?.let { fileList.add(it) }
                }
            }
            cont.resume(fileList)
        }
        input.click()
    }
}

actual class PlatformMediaPlayer {
    private val audio = window.Audio()
    private var currentSource: MediaSource? = null
    private val completionListeners = mutableListOf<() -> Unit>()
    private val errorListeners = mutableListOf<(String) -> Unit>()

    init {
        audio.onended = {
            currentSource = null
            completionListeners.forEach { it() }
        }
        audio.onerror = { event ->
            errorListeners.forEach { it("Audio error: ${audio.error?.code}") }
        }
    }

    actual fun play(mediaSource: MediaSource) {
        currentSource = mediaSource
        audio.src = mediaSource.mediaUrl
        audio.play().then {
            // Success
        }.catch { error ->
            errorListeners.forEach { it(error.message ?: "Playback failed") }
        }
    }

    actual fun pause() {
        audio.pause()
    }

    actual fun stop() {
        audio.pause()
        audio.currentTime = 0.0
        currentSource = null
    }

    actual fun seekTo(position: Long) {
        audio.currentTime = position / 1000.0
    }

    actual val currentPosition: Long
        get() = (audio.currentTime * 1000).toLong()

    actual val duration: Long
        get() = (audio.duration * 1000).toLong()

    actual val isPlaying: Boolean
        get() = !audio.paused && !audio.ended && audio.currentTime > 0

    actual val playbackState: PlaybackState
        get() = when {
            audio.paused && currentSource == null -> PlaybackState.IDLE
            audio.paused && currentSource != null -> PlaybackState.PAUSED
            !audio.paused -> PlaybackState.PLAYING
            audio.ended -> PlaybackState.COMPLETED
            else -> PlaybackState.IDLE
        }

    fun onCompletion(listener: () -> Unit) {
        completionListeners.add(listener)
    }

    fun onError(listener: (String) -> Unit) {
        errorListeners.add(listener)
    }
}

actual class PlatformPreferences {
    actual fun getString(key: String, defaultValue: String = ""): String {
        return localStorage.getItem(key) ?: defaultValue
    }

    actual fun putString(key: String, value: String) {
        localStorage.setItem(key, value)
    }

    actual fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        val value = localStorage.getItem(key)
        return value?.toBoolean() ?: defaultValue
    }

    actual fun putBoolean(key: String, value: Boolean) {
        localStorage.setItem(key, value.toString())
    }

    actual fun getInt(key: String, defaultValue: Int = 0): Int {
        val value = localStorage.getItem(key)
        return value?.toInt() ?: defaultValue
    }

    actual fun putInt(key: String, value: Int) {
        localStorage.setItem(key, value.toString())
    }

    actual fun getLong(key: String, defaultValue: Long = 0L): Long {
        val value = localStorage.getItem(key)
        return value?.toLong() ?: defaultValue
    }

    actual fun putLong(key: String, value: Long) {
        localStorage.setItem(key, value.toString())
    }

    actual fun remove(key: String) {
        localStorage.removeItem(key)
    }

    actual fun clear() {
        localStorage.clear()
    }
}

actual class PlatformHttpClient {
    actual suspend fun get(url: String): HttpResponse = suspendCoroutine { cont ->
        fetch(url, mapOf("method" to "GET", "headers" to mapOf("Content-Type" to "application/json")))
            .await()
            .then { response ->
                response.text().await().then { body ->
                    cont.resume(HttpResponse(
                        statusCode = response.status,
                        body = body,
                        headers = emptyMap()
                    ))
                }
            }
            .catch { error ->
                cont.resume(HttpResponse(
                    statusCode = 0,
                    body = error.message ?: "Network error"
                ))
            }
    }

    actual suspend fun post(url: String, body: String): HttpResponse = suspendCoroutine { cont ->
        fetch(url, mapOf(
            "method" to "POST",
            "headers" to mapOf("Content-Type" to "application/json"),
            "body" to body
        ))
            .await()
            .then { response ->
                response.text().await().then { body ->
                    cont.resume(HttpResponse(
                        statusCode = response.status,
                        body = body,
                        headers = emptyMap()
                    ))
                }
            }
            .catch { error ->
                cont.resume(HttpResponse(
                    statusCode = 0,
                    body = error.message ?: "Network error"
                ))
            }
    }

    actual suspend fun downloadFile(url: String, destinationPath: String): Boolean {
        // On web, we trigger a download instead
        window.location.href = url
        return true
    }
}

actual class PlatformImageLoader {
    actual fun loadImage(url: String, placeholder: Any? = null): Any {
        // Return URL string for Compose Web to load
        return url
    }

    actual fun loadImageFromFile(path: String): Any {
        // For web, we'd use a blob URL or object URL
        return path
    }
}

actual class PlatformLogger {
    actual fun debug(tag: String, message: String) {
        console.log("[$tag] $message")
    }

    actual fun info(tag: String, message: String) {
        console.info("[$tag] $message")
    }

    actual fun warn(tag: String, message: String) {
        console.warn("[$tag] $message")
    }

    actual fun error(tag: String, message: String, throwable: Throwable? = null) {
        console.error("[$tag] $message", throwable)
    }
}

actual class PlatformPermissions {
    actual fun requestPermission(permission: String): Boolean {
        // Web permissions API
        return true // Simplified
    }

    actual fun checkPermission(permission: String): Boolean {
        return true // Simplified
    }

    actual fun shouldShowRationale(permission: String): Boolean {
        return false
    }
}

actual class PlatformLifecycle {
    actual var onStart: () -> Unit = {}
    actual var onStop: () -> Unit = {}
    actual var onResume: () -> Unit = {}
    actual var onPause: () -> Unit = {}
    actual var onDestroy: () -> Unit = {}

    init {
        window.addEventListener("load") { onStart() }
        window.addEventListener("beforeunload") { onDestroy() }
        window.addEventListener("visibilitychange") {
            if (window.document.visibilityState == "visible") {
                onResume()
            } else {
                onPause()
            }
        }
    }
}

actual fun providePlatformDispatchers(): PlatformDispatchers = PlatformDispatchers()

actual fun providePlatformFileSystem(): PlatformFileSystem = PlatformFileSystem()

actual fun providePlatformMediaPlayer(): PlatformMediaPlayer = PlatformMediaPlayer()

actual fun providePlatformPreferences(): PlatformPreferences = PlatformPreferences()

actual fun providePlatformHttpClient(): PlatformHttpClient = PlatformHttpClient()

actual fun providePlatformImageLoader(): PlatformImageLoader = PlatformImageLoader()

actual fun providePlatformLogger(): PlatformLogger = PlatformLogger()

actual fun providePlatformPermissions(): PlatformPermissions = PlatformPermissions()

actual fun providePlatformLifecycle(): PlatformLifecycle = PlatformLifecycle()