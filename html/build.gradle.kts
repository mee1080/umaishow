plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
}

group = "io.github.mee1080.umaishow"
version = "1.0.0"

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
