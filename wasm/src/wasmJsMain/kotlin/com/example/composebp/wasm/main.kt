package com.example.composebp.wasm

import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import io.github.mee1080.umaishow.App
import io.github.mee1080.umaishow.vm.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalComposeUiApi::class, ExperimentalCoroutinesApi::class)
fun main() {
    CanvasBasedWindow("ウマ娘相性表") {
        val scope = rememberCoroutineScope()
        val viewModel = remember { ViewModel() }
        val state = viewModel.state
        App(state, viewModel, "LINESeedJP_OTF_Rg.woff2")
    }
}
