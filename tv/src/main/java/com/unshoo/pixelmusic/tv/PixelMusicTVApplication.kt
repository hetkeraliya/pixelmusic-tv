package com.unshoo.pixelmusic.tv

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PixelMusicTVApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize any TV-specific components here
    }

    companion object {
        lateinit var instance: PixelMusicTVApplication
            private set
    }

    init {
        instance = this
    }
}