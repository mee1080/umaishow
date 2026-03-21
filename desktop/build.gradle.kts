plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {

    jvm {
        compilations.all {
//            kotlinOptions.jvmTarget = libs.versions.jvmTarget.get()
        }
    }

    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":core"))
                implementation(project(":composeCommon"))
                implementation(compose.desktop.currentOs)
                implementation(libs.kotlinx.coroutinesCore)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}
