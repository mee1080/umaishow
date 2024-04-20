rootProject.name = "umaishow"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
include("utility")
include("html")
include("core")
include("composeCommon")
include("desktop")
include("wasm")