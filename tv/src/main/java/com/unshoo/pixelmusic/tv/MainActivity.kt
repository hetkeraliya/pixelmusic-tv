package com.unshoo.pixelmusic.tv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unshoo.pixelmusic.tv.di.LocalPlatformImageLoader
import com.unshoo.pixelmusic.tv.di.rememberPlatformImageLoader
import com.unshoo.pixelmusic.tv.ui.MainScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPoints
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get PlatformImageLoader from Hilt
        val imageLoader = EntryPoints.get(this, com.unshoo.pixelmusic.tv.di.PlatformImageLoaderEntryPoint::class.java).platformImageLoader()

        setContent {
            MaterialTheme {
                Surface {
                    // Provide the image loader via CompositionLocal
                    androidx.compose.runtime.CompositionLocalProvider(LocalPlatformImageLoader provides imageLoader) {
                        MainScreen()
                    }
                }
            }
        }
    }
}