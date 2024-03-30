import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "wasm"
        browser {
            commonWebpackConfig {
                outputFileName = "wasm.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation(project(":core"))
                implementation(project(":composeCommon"))
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.material3)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(libs.kotlinx.coroutinesCore)
            }
        }
    }
}

compose.experimental {
    web.application {}
}
