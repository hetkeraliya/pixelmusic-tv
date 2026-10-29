plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.unshoo.pixelmusic.core"
    compileSdk = 34

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