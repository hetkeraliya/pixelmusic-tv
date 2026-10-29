package com.unshoo.pixelmusic.core.platform

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.unshoo.pixelmusic.PixelMusicApplication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.concurrent.Executors

/**
 * Platform-specific dispatcher providers.
 * Android implementation using Kotlinx Coroutines Dispatchers.
 */
class PlatformDispatchers {
    val io: CoroutineDispatcher = Dispatchers.IO
    val main: CoroutineDispatcher = Dispatchers.Main
    val default: CoroutineDispatcher = Dispatchers.Default
}

/**
 * Platform-specific file system access.
 * Android implementation using Context and File APIs.
 */
class PlatformFileSystem internal constructor(private val context: Context) {
    fun getMusicDirectories(): List<String> {
        val dirs = mutableListOf<String>()
        // Add external storage music directories
        val externalDirs = context.getExternalFilesDirs(Environment.DIRECTORY_MUSIC)
        for (dir in externalDirs) {
            dir?.let { dirs.add(it.absolutePath) }
        }
        // Add public music directory
        val publicMusic = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
        dirs.add(publicMusic.absolutePath)
        return dirs
    }

    fun readFile(path: String): ByteArray {
        return File(path).readBytes()
    }

    fun writeFile(path: String, data: ByteArray) {
        File(path).writeBytes(data)
    }

    fun deleteFile(path: String): Boolean {
        return File(path).delete()
    }

    fun fileExists(path: String): Boolean {
        return File(path).exists()
    }

    fun listFiles(path: String): List<String> {
        return File(path).listFiles()?.map { it.absolutePath } ?: emptyList()
    }
}

/**
 * Platform-specific media playback.
 * Android implementation using MediaPlayer.
 */
class PlatformMediaPlayer internal constructor(private val context: Context) {
    private val mediaPlayer = MediaPlayer()
    private var currentSource: MediaSource? = null
    private val completionListeners = mutableListOf<() -> Unit>()
    private val errorListeners = mutableListOf<(String) -> Unit>()

    init {
        mediaPlayer.setOnCompletionListener {
            currentSource = null
            completionListeners.forEach { it() }
        }
        mediaPlayer.setOnErrorListener { _, what, _ ->
            errorListeners.forEach { it("MediaPlayer error: $what") }
            true
        }
    }

    fun play(mediaSource: MediaSource) {
        currentSource = mediaSource
        try {
            mediaPlayer.reset()
            mediaPlayer.setDataSource(context, Uri.parse(mediaSource.mediaUrl))
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener { it.start() }
        } catch (e: Exception) {
            errorListeners.forEach { it(e.message ?: "Unknown error") }
        }
    }

    fun pause() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }

    fun stop() {
        mediaPlayer.stop()
        currentSource = null
    }

    fun seekTo(position: Long) {
        mediaPlayer.seekTo(position.toInt())
    }

    val currentPosition: Long
        get() = mediaPlayer.currentPosition.toLong()

    val duration: Long
        get() = mediaPlayer.duration.toLong()

    val isPlaying: Boolean
        get() = mediaPlayer.isPlaying

    val playbackState: PlaybackState
        get() = when {
            !mediaPlayer.isPlaying && currentSource == null -> PlaybackState.IDLE
            mediaPlayer.isPlaying -> PlaybackState.PLAYING
            currentSource != null -> PlaybackState.PAUSED
            else -> PlaybackState.IDLE
        }

    fun onCompletion(listener: () -> Unit) {
        completionListeners.add(listener)
    }

    fun onError(listener: (String) -> Unit) {
        errorListeners.add(listener)
    }

    fun release() {
        mediaPlayer.release()
    }
}

/**
 * Platform-specific preferences/storage.
 * Android implementation using SharedPreferences.
 */
class PlatformPreferences internal constructor(private val context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("pixelmusic_prefs", Context.MODE_PRIVATE)

    fun getString(key: String, defaultValue: String = ""): String {
        return prefs.getString(key, defaultValue) ?: defaultValue
    }

    fun putString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return prefs.getBoolean(key, defaultValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    fun getInt(key: String, defaultValue: Int = 0): Int {
        return prefs.getInt(key, defaultValue)
    }

    fun putInt(key: String, value: Int) {
        prefs.edit().putInt(key, value).apply()
    }

    fun getLong(key: String, defaultValue: Long = 0L): Long {
        return prefs.getLong(key, defaultValue)
    }

    fun putLong(key: String, value: Long) {
        prefs.edit().putLong(key, value).apply()
    }

    fun remove(key: String) {
        prefs.edit().remove(key).apply()
    }

    fun clear() {
        prefs.edit().clear().apply()
    }
}

/**
 * Platform-specific network client.
 * Android implementation using OkHttp.
 */
class PlatformHttpClient internal constructor() {
    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("User-Agent", "PixelMusic/1.0")
                .build()
            chain.proceed(request)
        }
        .build()

    suspend fun get(url: String): HttpResponse = withContext(Dispatchers.IO) {
        val request = Request.Builder().url(url).get().build()
        client.newCall(request).execute().use { response ->
            HttpResponse(
                statusCode = response.code,
                body = response.body?.string() ?: "",
                headers = response.headers.toMultimap()
            )
        }
    }

    suspend fun post(url: String, body: String): HttpResponse = withContext(Dispatchers.IO) {
        val requestBody = okhttp3.RequestBody.create(body, okhttp3.MediaType.get("application/json; charset=utf-8"))
        val request = Request.Builder().url(url).post(requestBody).build()
        client.newCall(request).execute().use { response ->
            HttpResponse(
                statusCode = response.code,
                body = response.body?.string() ?: "",
                headers = response.headers.toMultimap()
            )
        }
    }

    suspend fun downloadFile(url: String, destinationPath: String): Boolean = withContext(Dispatchers.IO) {
        val request = Request.Builder().url(url).get().build()
        client.newCall(request).execute().use { response ->
            response.body?.byteStream()?.use { input ->
                File(destinationPath).outputStream().use { output ->
                    input.copyTo(output)
                }
                true
            } ?: false
        }
    }
}

/**
 * Platform-specific image loading.
 * Android implementation returning URIs for Coil.
 */
class PlatformImageLoader internal constructor(private val context: Context) {
    fun loadImage(url: String, placeholder: Any? = null): Any {
        // Return URI for Coil to load
        return Uri.parse(url)
    }

    fun loadImageFromFile(path: String): Any {
        return Uri.fromFile(File(path))
    }
}

/**
 * Platform-specific logging.
 * Android implementation using android.util.Log.
 */
class PlatformLogger internal constructor() {
    fun debug(tag: String, message: String) {
        Log.d(tag, message)
    }

    fun info(tag: String, message: String) {
        Log.i(tag, message)
    }

    fun warn(tag: String, message: String) {
        Log.w(tag, message)
    }

    fun error(tag: String, message: String, throwable: Throwable? = null) {
        Log.e(tag, message, throwable)
    }
}

/**
 * Platform-specific permissions.
 * Android implementation using ContextCompat.
 */
class PlatformPermissions internal constructor(private val activity: AppCompatActivity) {
    fun requestPermission(permission: String): Boolean {
        // Simplified - in real implementation use ActivityCompat.requestPermissions
        return ContextCompat.checkSelfPermission(activity, permission) == android.content.pm.PackageManager.PERMISSION_GRANTED
    }

    fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(activity, permission) == android.content.pm.PackageManager.PERMISSION_GRANTED
    }

    fun shouldShowRationale(permission: String): Boolean {
        return androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
    }
}

class LifecycleObserverImpl : LifecycleObserver {
    var onStart: () -> Unit = {}
    var onStop: () -> Unit = {}
    var onResume: () -> Unit = {}
    var onPause: () -> Unit = {}
    var onDestroy: () -> Unit = {}

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartEvent() = onStart()

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopEvent() = onStop()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeEvent() = onResume()

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseEvent() = onPause()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyEvent() = onDestroy()
}

/**
 * Platform-specific lifecycle.
 * Android implementation using LifecycleObserver.
 */
class PlatformLifecycle internal constructor(private val activity: AppCompatActivity) {
    private val observer = LifecycleObserverImpl()

    init {
        activity.lifecycle.addObserver(observer)
    }

    val onStart: () -> Unit
        get() = observer.onStart
        set(value) { observer.onStart = value }

    val onStop: () -> Unit
        get() = observer.onStop
        set(value) { observer.onStop = value }

    val onResume: () -> Unit
        get() = observer.onResume
        set(value) { observer.onResume = value }

    val onPause: () -> Unit
        get() = observer.onPause
        set(value) { observer.onPause = value }

    val onDestroy: () -> Unit
        get() = observer.onDestroy
        set(value) { observer.onDestroy = value }
}

fun providePlatformDispatchers(): PlatformDispatchers = PlatformDispatchers()

fun providePlatformFileSystem(): PlatformFileSystem {
    return PlatformFileSystem(PixelMusicApplication.instance)
}

fun providePlatformMediaPlayer(): PlatformMediaPlayer {
    return PlatformMediaPlayer(PixelMusicApplication.instance)
}

fun providePlatformPreferences(): PlatformPreferences {
    return PlatformPreferences(PixelMusicApplication.instance)
}

fun providePlatformHttpClient(): PlatformHttpClient = PlatformHttpClient()

fun providePlatformImageLoader(): PlatformImageLoader {
    return PlatformImageLoader(PixelMusicApplication.instance)
}

fun providePlatformLogger(): PlatformLogger = PlatformLogger()

fun providePlatformPermissions(): PlatformPermissions {
    // This needs an activity context - in practice would be provided via DI
    throw UnsupportedOperationException("PlatformPermissions requires Activity context")
}

fun providePlatformLifecycle(): PlatformLifecycle {
    throw UnsupportedOperationException("PlatformLifecycle requires Activity context")
}

/**
 * Media source representation.
 */
@Serializable
data class MediaSource(
    val id: String,
    val title: String,
    val artist: String,
    val album: String?,
    val artworkUrl: String?,
    val mediaUrl: String,
    val duration: Long,
    val sourceType: MediaSourceType,
    val metadata: Map<String, String> = emptyMap()
)

@Serializable
enum class MediaSourceType {
    LOCAL, YOUTUBE_MUSIC, TELEGRAM, GOOGLE_DRIVE, CAST
}

@Serializable
enum class PlaybackState {
    IDLE, BUFFERING, PLAYING, PAUSED, COMPLETED, ERROR
}

@Serializable
data class HttpResponse(
    val statusCode: Int,
    val body: String,
    val headers: Map<String, List<String>> = emptyMap()
)