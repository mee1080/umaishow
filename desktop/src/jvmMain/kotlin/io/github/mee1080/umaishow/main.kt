package io.github.mee1080.umaishow

import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import io.github.mee1080.umaishow.vm.ViewModel

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose for Desktop",
        state = rememberWindowState(width = 900.dp, height = 900.dp)
    ) {
        val scope = rememberCoroutineScope()
        val viewModel = remember { ViewModel() }
        val state = viewModel.state
        App(state, viewModel, "LINESeedJP_A_OTF_Rg.otf")
    }
}