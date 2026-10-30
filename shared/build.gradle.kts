plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.unshoo.pixelmusic.shared"
    compileSdk = 36

    defaultConfig {
        minSdk = 30 // Must match app module's minSdk; shared code is pure DTOs with no platform APIs
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}

configurations.all {
    exclude(group = "org.jetbrains.kotlin", module = "kotlin-android-extensions-runtime")
    // Exclude new Compose 1.12.x artifact coordinates that don't exist in 1.11.x
    exclude(group = "androidx.compose.material3", module = "material3-android")
    exclude(group = "androidx.compose.material", module = "material-ripple-android")
    exclude(group = "androidx.compose.remote", module = "remote-creation-android")
    exclude(group = "androidx.compose.runtime", module = "runtime-saveable-android")
    exclude(group = "androidx.compose.ui", module = "ui-android")
    resolutionStrategy {
        force("androidx.core:core-ktx:1.18.0")
        force("androidx.core:core:1.18.0")
        force("androidx.lifecycle:lifecycle-runtime-ktx:2.10.0")
        force("androidx.lifecycle:lifecycle-runtime-compose:2.10.0")
        force("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
        force("androidx.activity:activity-compose:1.12.0")
        force("androidx.activity:activity:1.12.0")
        force("androidx.compose.ui:ui:1.11.2")
        force("androidx.compose.ui:ui-graphics:1.11.2")
        force("androidx.compose.ui:ui-text:1.11.2")
        force("androidx.compose.ui:ui-util:1.11.2")
        force("androidx.compose.foundation:foundation:1.11.2")
        force("androidx.compose.foundation:foundation-layout:1.11.2")
        force("androidx.compose.runtime:runtime:1.11.2")
        force("androidx.compose.runtime:runtime-saveable:1.11.2")
        force("androidx.compose.animation:animation:1.11.2")
        force("androidx.compose.animation:animation-core:1.11.2")
        force("androidx.compose.material3:material3:1.3.0")
        force("androidx.compose.material:material-ripple:1.11.2")
    }
}
