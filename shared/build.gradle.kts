import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    kotlin("plugin.serialization")
}

android {
    namespace = "com.unshoo.pixelmusic.shared"
    compileSdk = 37

    defaultConfig {
        minSdk = 30 // Must match app module's minSdk; shared code is pure DTOs with no platform APIs
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = "21"
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}
