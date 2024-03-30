plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.compose) apply false
}

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers/")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
    }
}
