// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.dagger.hilt.android) apply false
    alias(libs.plugins.android.test) apply false
    alias(libs.plugins.baselineprofile) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
}

subprojects {
    configurations.all {
        resolutionStrategy {
            // Force Kotlin 2.0.21 to avoid version mismatch with Compose BOM 2024.10.01
            force("org.jetbrains.kotlin:kotlin-metadata-jvm:2.0.21")
            force("org.jetbrains.kotlin:kotlin-stdlib:2.0.21")
            force("org.jetbrains.kotlin:kotlin-stdlib-common:2.0.21")
            force("org.jetbrains.kotlin:kotlin-stdlib-jdk7:2.0.21")
            force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.21")
            force("org.jetbrains.kotlin:kotlin-reflect:2.0.21")

            // Force kotlinx.coroutines 1.10.2 (compatible with Kotlin 2.0.21)
            force("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
            force("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.10.2")
            force("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")
            force("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")
            force("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.10.2")

            // Force kotlinx.serialization 1.10.0 (compatible with Kotlin 2.0.21)
            force("org.jetbrains.kotlinx:kotlinx-serialization-core:1.10.0")
            force("org.jetbrains.kotlinx:kotlinx-serialization-core-jvm:1.10.0")
            force("org.jetbrains.kotlinx:kotlinx-serialization-json:1.10.0")
            force("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.10.0")

            // Force BOMs to prevent transitive 1.11.0 resolution
            force("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.10.2")
            force("org.jetbrains.kotlinx:kotlinx-serialization-bom:1.10.0")
        }
    }

    // Disable compileVersionMap to fix fingerprinting serialization error
    afterEvaluate {
        if (plugins.hasPlugin("com.android.library") || plugins.hasPlugin("com.android.application")) {
            extensions.configure("android") {
                // Use reflection to set experimentalOptions.disableCompileVersionMap
                val extension = this
                extension.extraProperties.set("experimentalOptions.disableCompileVersionMap", true)
            }
        }
    }
}
