package io.github.mee1080.umaishow

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose for Desktop",
        state = rememberWindowState(width = 900.dp, height = 900.dp)
    ) {
        App("LINESeedJP_A_OTF_Rg.otf")
    }
}