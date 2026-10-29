# ProGuard rules for TV module
-keep class com.unshoo.pixelmusic.tv.** { *; }
-keep class com.unshoo.pixelmusic.core.** { *; }
-keep class com.unshoo.pixelmusic.shared.** { *; }

# Keep Hilt generated classes
-keep class dagger.hilt.** { *; }

# Keep Media3 classes
-keep class androidx.media3.** { *; }

# Keep Ktor classes
-keep class io.ktor.** { *; }

# Keep Kotlinx serialization
-keep class kotlinx.serialization.** { *; }

# Keep Coil
-keep class coil3.** { *; }

# Keep Room
-keep class androidx.room.** { *; }

# Keep Navigation
-keep class androidx.navigation.** { *; }