package com.unshoo.pixelmusic.core.platform

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Platform-specific dispatcher providers.
 * Each platform implements its own dispatchers.
 */
expect class PlatformDispatchers {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
}

/**
 * Platform-specific file system access.
 */
expect class PlatformFileSystem {
    fun getMusicDirectories(): List<String>
    fun readFile(path: String): ByteArray
    fun writeFile(path: String, data: ByteArray)
    fun deleteFile(path: String): Boolean
    fun fileExists(path: String): Boolean
    fun listFiles(path: String): List<String>
}

/**
 * Platform-specific media playback.
 */
expect class PlatformMediaPlayer {
    fun play(mediaSource: MediaSource)
    fun pause()
    fun stop()
    fun seekTo(position: Long)
    val currentPosition: Long
    val duration: Long
    val isPlaying: Boolean
    val playbackState: PlaybackState
}

/**
 * Platform-specific preferences/storage.
 */
expect class PlatformPreferences {
    fun getString(key: String, defaultValue: String = ""): String
    fun putString(key: String, value: String)
    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean
    fun putBoolean(key: String, value: Boolean)
    fun getInt(key: String, defaultValue: Int = 0): Int
    fun putInt(key: String, value: Int)
    fun getLong(key: String, defaultValue: Long = 0L): Long
    fun putLong(key: String, value: Long)
    fun remove(key: String)
    fun clear()
}

/**
 * Platform-specific network client.
 */
expect class PlatformHttpClient {
    suspend fun get(url: String): HttpResponse
    suspend fun post(url: String, body: String): HttpResponse
    suspend fun downloadFile(url: String, destinationPath: String): Boolean
}

/**
 * Platform-specific image loading.
 */
expect class PlatformImageLoader {
    fun loadImage(url: String, placeholder: Any? = null): Any
    fun loadImageFromFile(path: String): Any
}

/**
 * Platform-specific logging.
 */
expect class PlatformLogger {
    fun debug(tag: String, message: String)
    fun info(tag: String, message: String)
    fun warn(tag: String, message: String)
    fun error(tag: String, message: String, throwable: Throwable? = null)
}

/**
 * Platform-specific permissions.
 */
expect class PlatformPermissions {
    fun requestPermission(permission: String): Boolean
    fun checkPermission(permission: String): Boolean
    fun shouldShowRationale(permission: String): Boolean
}

/**
 * Platform-specific lifecycle.
 */
expect class PlatformLifecycle {
    val onStart: () -> Unit
    val onStop: () -> Unit
    val onResume: () -> Unit
    val onPause: () -> Unit
    val onDestroy: () -> Unit
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

/**
 * Platform factory - each platform provides its implementation.
 */
expect fun providePlatformDispatchers(): PlatformDispatchers
expect fun providePlatformFileSystem(): PlatformFileSystem
expect fun providePlatformMediaPlayer(): PlatformMediaPlayer
expect fun providePlatformPreferences(): PlatformPreferences
expect fun providePlatformHttpClient(): PlatformHttpClient
expect fun providePlatformImageLoader(): PlatformImageLoader
expect fun providePlatformLogger(): PlatformLogger
expect fun providePlatformPermissions(): PlatformPermissions
expect fun providePlatformLifecycle(): PlatformLifecycle