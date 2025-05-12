// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Kotlin plugin for Android projects (Kotlin 1.9.10)
    kotlin("android") version "1.9.10" apply false
    // Android Gradle Plugin updated to support compileSdk = 34
    id("com.android.application") version "8.1.4" apply false
    // (Optional) Navigation safe args, etc.
}

// If you have other subprojects (like libraries), you can configure them here.