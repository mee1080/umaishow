plugins {
    kotlin("multiplatform") version "1.9.0"
    id("org.jetbrains.compose") version "1.4.3"
}

group = "io.github.mee1080.umaishow"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
                implementation(npm("@material/mwc-button", "0.25.3"))
                implementation(npm("@material/mwc-dialog", "0.25.3"))
                implementation(npm("@material/mwc-tab", "0.25.3"))
                implementation(npm("@material/mwc-tab-bar", "0.25.3"))
                implementation(npm("@material/mwc-slider", "0.25.3"))
            }
        }
    }
}

//afterEvaluate {
//    rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
//        versions.webpackCli.version = "4.9.0"
//    }
//}