plugins {
    alias(libs.plugins.android.application)
    // For Navigation (type safety)
    kotlin("plugin.serialization") version "2.0.21"
}

android {
    namespace = "com.grouptwo.ourtimes"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.grouptwo.ourtimes"
        // API 24 = Android 7.0 (Nougat), CredentialManager requires API 34 (Android 14),
        //  maybe -if implementing it- its code can rely upon an API version conditional?
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)

    val nav_version = "2.10.2"
    val room_version = "2.8.5"

    // Navigation components for Fragments
    // https://developer.android.com/guide/navigation#kts
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")

    // Room 2 (database); a new Room 3 package exists but is Kotlin-first.
    // https://developer.android.com/jetpack/androidx/releases/room#kts
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
}