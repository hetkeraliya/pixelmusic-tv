plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.unshoo.pixelmusic.core"
    compileSdk = 36

    defaultConfig {
        minSdk = 28
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

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "21"
        freeCompilerArgs += listOf("-Xannotation-default-target=param-property")
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.json)
    implementation(libs.ktor.client.logging)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.kotlinx.datetime)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.encoding)

    // Testing
    androidTestImplementation(libs.androidx.room.testing)
    testImplementation(libs.kotlinx.coroutines.test)
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