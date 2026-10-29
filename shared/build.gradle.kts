plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.unshoo.pixelmusic.shared"
    compileSdk = 34

    // Disable compileVersionMap to fix fingerprinting serialization error
    experimentalOptions.disableCompileVersionMap = true

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
