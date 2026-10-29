package com.unshoo.pixelmusic.core.platform

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse as JavaHttpResponse
import java.net.URI
import java.nio.file.Files
import java.nio.file.Paths
import java.util.concurrent.Executors

actual class PlatformDispatchers actual constructor() {
    actual val io: CoroutineDispatcher = Dispatchers.IO
    actual val main: CoroutineDispatcher = Dispatchers.Main
    actual val default: CoroutineDispatcher = Dispatchers.Default
}

actual class PlatformFileSystem {
    actual fun getMusicDirectories(): List<String> {
        val dirs = mutableListOf<String>()
        // User's home music directory
        val userHome = System.getProperty("user.home")
        val musicDir = File(userHome, "Music")
        if (musicDir.exists()) dirs.add(musicDir.absolutePath)

        // Common Linux music directories
        val xdgMusic = System.getenv("XDG_MUSIC_DIR")
        if (xdgMusic != null) {
            val dir = File(xdgMusic)
            if (dir.exists()) dirs.add(dir.absolutePath)
        }

        return dirs
    }

    actual fun readFile(path: String): ByteArray {
        return Files.readAllBytes(Paths.get(path))
    }

    actual fun writeFile(path: String, data: ByteArray) {
        Files.write(Paths.get(path), data)
    }

    actual fun deleteFile(path: String): Boolean {
        return Files.deleteIfExists(Paths.get(path))
    }

    actual fun fileExists(path: String): Boolean {
        return Files.exists(Paths.get(path))
    }

    actual fun listFiles(path: String): List<String> {
        return Files.list(Paths.get(path))
            .map { it.toString() }
            .toList()
    }
}

actual class PlatformMediaPlayer {
    // For JVM desktop, we'd use JavaFX MediaPlayer or similar
    // This is a simplified placeholder
    private var currentSource: MediaSource? = null
    private var position: Long = 0
    private var duration: Long = 0
    private var playing = false

    actual fun play(mediaSource: MediaSource) {
        currentSource = mediaSource
        playing = true
        // In real implementation, use JavaFX MediaPlayer or similar
        println("Playing: ${mediaSource.title} - ${mediaSource.mediaUrl}")
    }

    actual fun pause() {
        playing = false
    }

    actual fun stop() {
        playing = false
        position = 0
        currentSource = null
    }

    actual fun seekTo(pos: Long) {
        position = pos
    }

    actual val currentPosition: Long
        get() = position

    actual val duration: Long
        get() = duration

    actual val isPlaying: Boolean
        get() = playing

    actual val playbackState: PlaybackState
        get() = when {
            !playing && currentSource == null -> PlaybackState.IDLE
            playing -> PlaybackState.PLAYING
            currentSource != null -> PlaybackState.PAUSED
            else -> PlaybackState.IDLE
        }
}

actual class PlatformPreferences {
    private val prefsDir = File(System.getProperty("user.home"), ".pixelmusic")
    private val prefsFile = File(prefsDir, "preferences.json")
    private val json = Json { prettyPrint = true }
    private var prefs: MutableMap<String, Any> = mutableMapOf()

    init {
        prefsDir.mkdirs()
        if (prefsFile.exists()) {
            try {
                val content = prefsFile.readText()
                prefs = json.decodeFromString(content) ?: mutableMapOf()
            } catch (e: Exception) {
                prefs = mutableMapOf()
            }
        }
    }

    private fun save() {
        prefsFile.writeText(json.encodeToString(prefs))
    }

    actual fun getString(key: String, defaultValue: String = ""): String {
        return prefs[key] as? String ?: defaultValue
    }

    actual fun putString(key: String, value: String) {
        prefs[key] = value
        save()
    }

    actual fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return prefs[key] as? Boolean ?: defaultValue
    }

    actual fun putBoolean(key: String, value: Boolean) {
        prefs[key] = value
        save()
    }

    actual fun getInt(key: String, defaultValue: Int = 0): Int {
        return prefs[key] as? Int ?: defaultValue
    }

    actual fun putInt(key: String, value: Int) {
        prefs[key] = value
        save()
    }

    actual fun getLong(key: String, defaultValue: Long = 0L): Long {
        return prefs[key] as? Long ?: defaultValue
    }

    actual fun putLong(key: String, value: Long) {
        prefs[key] = value
        save()
    }

    actual fun remove(key: String) {
        prefs.remove(key)
        save()
    }

    actual fun clear() {
        prefs.clear()
        save()
    }
}

actual class PlatformHttpClient {
    private val client = HttpClient.newHttpClient()

    actual suspend fun get(url: String): HttpResponse {
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .header("User-Agent", "PixelMusic/1.0")
            .build()

        val response = client.send(request, JavaHttpResponse.BodyHandlers.ofString())
        return HttpResponse(
            statusCode = response.statusCode(),
            body = response.body(),
            headers = response.headers().map()
        )
    }

    actual suspend fun post(url: String, body: String): HttpResponse {
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .header("Content-Type", "application/json")
            .header("User-Agent", "PixelMusic/1.0")
            .build()

        val response = client.send(request, JavaHttpResponse.BodyHandlers.ofString())
        return HttpResponse(
            statusCode = response.statusCode(),
            body = response.body(),
            headers = response.headers().map()
        )
    }

    actual suspend fun downloadFile(url: String, destinationPath: String): Boolean {
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build()

        val response = client.send(request, JavaHttpResponse.BodyHandlers.ofFile(Paths.get(destinationPath)))
        return response.statusCode() == 200
    }
}

actual class PlatformImageLoader {
    actual fun loadImage(url: String, placeholder: Any? = null): Any {
        // For JVM desktop, return URL or load with ImageIO
        return url
    }

    actual fun loadImageFromFile(path: String): Any {
        return File(path).toURI().toURL()
    }
}

actual class PlatformLogger {
    actual fun debug(tag: String, message: String) {
        println("DEBUG [$tag] $message")
    }

    actual fun info(tag: String, message: String) {
        println("INFO [$tag] $message")
    }

    actual fun warn(tag: String, message: String) {
        println("WARN [$tag] $message")
    }

    actual fun error(tag: String, message: String, throwable: Throwable? = null) {
        System.err.println("ERROR [$tag] $message")
        throwable?.printStackTrace()
    }
}

actual class PlatformPermissions {
    actual fun requestPermission(permission: String): Boolean {
        // Desktop apps typically don't need runtime permissions
        return true
    }

    actual fun checkPermission(permission: String): Boolean {
        return true
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

    // Desktop apps manage lifecycle differently
    // Could add shutdown hook for onDestroy
    init {
        Runtime.getRuntime().addShutdownHook(Thread { onDestroy() })
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