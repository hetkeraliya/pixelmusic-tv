package com.unshoo.pixelmusic.tv

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen

class SplashActivity : AppCompatActivity() {

    private var isAnimationComplete = false

    override fun onCreate(savedInstanceState: Bundle?) {
        // Install the splash screen before super.onCreate
        val splashScreen = SplashScreen.installSplashScreen(this)

        super.onCreate(savedInstanceState)

        // Simple layout with ImageView
        val imageView = ImageView(this).apply {
            setImageResource(R.drawable.splash_animation)
            scaleType = android.widget.ImageView.ScaleType.FIT_CENTER
            layoutParams = android.widget.FrameLayout.LayoutParams(
                android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                android.view.Gravity.CENTER
            )
        }
        setContentView(imageView)

        // Keep the splash screen visible until animation completes
        splashScreen.setKeepOnScreenCondition {
            !isAnimationComplete
        }

        // Start the animation
        startAnimation(imageView)
    }

    private fun startAnimation(imageView: ImageView) {
        // Start the animated vector drawable
        val drawable = imageView.drawable
        if (drawable is android.graphics.drawable.AnimatedVectorDrawable) {
            drawable.start()

            // Calculate total animation duration (matches theme duration)
            val totalDuration = 1500L // Total animation duration in ms

            // Navigate to MainActivity after animation completes
            Handler(Looper.getMainLooper()).postDelayed({
                isAnimationComplete = true
                navigateToMainActivity()
            }, totalDuration)
        } else {
            // Fallback if animation doesn't start
            isAnimationComplete = true
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()

        // Smooth transition
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}