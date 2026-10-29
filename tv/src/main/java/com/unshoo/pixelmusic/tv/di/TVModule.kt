package com.unshoo.pixelmusic.tv.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras
import com.unshoo.pixelmusic.core.platform.PlatformDispatchers
import com.unshoo.pixelmusic.core.platform.PlatformFileSystem
import com.unshoo.pixelmusic.core.platform.PlatformHttpClient
import com.unshoo.pixelmusic.core.platform.PlatformImageLoader
import com.unshoo.pixelmusic.core.platform.PlatformLifecycle
import com.unshoo.pixelmusic.core.platform.PlatformLogger
import com.unshoo.pixelmusic.core.platform.PlatformMediaPlayer
import com.unshoo.pixelmusic.core.platform.PlatformPermissions
import com.unshoo.pixelmusic.core.platform.PlatformPreferences
import com.unshoo.pixelmusic.core.platform.providePlatformDispatchers
import com.unshoo.pixelmusic.core.platform.providePlatformFileSystem
import com.unshoo.pixelmusic.core.platform.providePlatformHttpClient
import com.unshoo.pixelmusic.core.platform.providePlatformImageLoader
import com.unshoo.pixelmusic.core.platform.providePlatformLogger
import com.unshoo.pixelmusic.core.platform.providePlatformMediaPlayer
import com.unshoo.pixelmusic.core.platform.providePlatformPreferences
import com.unshoo.pixelmusic.tv.PixelMusicTVApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TVPlatformModule {

    @Provides
    @Singleton
    fun providePlatformDispatchers(): PlatformDispatchers = providePlatformDispatchers()

    @Provides
    @Singleton
    fun providePlatformFileSystem(): PlatformFileSystem = providePlatformFileSystem()

    @Provides
    @Singleton
    fun providePlatformHttpClient(): PlatformHttpClient = providePlatformHttpClient()

    @Provides
    @Singleton
    fun providePlatformImageLoader(): PlatformImageLoader = providePlatformImageLoader()

    @Provides
    @Singleton
    fun providePlatformLogger(): PlatformLogger = providePlatformLogger()

    @Provides
    @Singleton
    fun providePlatformMediaPlayer(): PlatformMediaPlayer = providePlatformMediaPlayer()

    @Provides
    @Singleton
    fun providePlatformPreferences(): PlatformPreferences = providePlatformPreferences()

    @Provides
    @Singleton
    fun providePlatformPermissions(app: PixelMusicTVApplication): PlatformPermissions {
        // For TV, we typically don't need runtime permissions for media playback
        return object : PlatformPermissions() {
            override fun requestPermission(permission: String): Boolean = true
            override fun checkPermission(permission: String): Boolean = true
            override fun shouldShowRationale(permission: String): Boolean = false
        }
    }

    @Provides
    @Singleton
    fun providePlatformLifecycle(app: PixelMusicTVApplication): PlatformLifecycle {
        return object : PlatformLifecycle() {
            override var onStart: () -> Unit = {}
            override var onStop: () -> Unit = {}
            override var onResume: () -> Unit = {}
            override var onPause: () -> Unit = {}
            override var onDestroy: () -> Unit = {}
        }
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class TVViewModelModule {
    // ViewModels will be added here as we extract them from the app module
}