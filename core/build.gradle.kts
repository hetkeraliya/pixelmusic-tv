import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

kotlin {
    // Targets - only Android for TV build
    android {
        compileSdk = 37
        defaultConfig {
            minSdk = 30
        }
    }

    // Common source sets
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.json)
                implementation(libs.ktor.client.logging)
                implementation(libs.kotlinx.collections.immutable)
                implementation(libs.kotlinx.datetime)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.lifecycle.runtime.ktx)
                implementation(libs.androidx.lifecycle.viewmodel.compose)
                implementation(libs.androidx.room.runtime)
                implementation(libs.androidx.room.ktx)
                implementation(libs.androidx.datastore.preferences)
                implementation(libs.okhttp)
                implementation(libs.logging.interceptor)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.ktor.client.encoding)
            }
        }
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
        freeCompilerArgs.add("-Xannotation-default-target=param-property")
    }
}

android {
    namespace = "com.unshoo.pixelmusic.core"
    compileSdk = 37
    defaultConfig {
        minSdk = 30
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.6.10"
    }
    packaging {
        resources {
            excludes += listOf("META-INF/LICENSE.md", "META-INF/LICENSE.txt", "META-INF/NOTICE.md", "META-INF/NOTICE.txt")
        }
    }
}

dependencies {
    // Android-specific (expect/actual implementations)
    androidTestImplementation(libs.androidx.room.testing)
    testImplementation(libs.kotlinx.coroutines.test)
}