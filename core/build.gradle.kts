plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

group = "io.github.mee1080.umaishow"
version = "1.0.0"

kotlin {
    jvm()

    js(IR) {
        browser()
        binaries.executable()
    }

    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(libs.kotlinx.collections.immutable)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(libs.kotlinx.browser)
            }
        }

        val wasmJsMain by getting {
            dependencies {
                implementation(libs.kotlinx.browser)
            }
        }
    }
}
