package com.example.composebp.wasm

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import io.github.mee1080.umaishow.App
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalComposeUiApi::class, ExperimentalCoroutinesApi::class)
fun main() {
    CanvasBasedWindow("ウマ娘相性表") {
        App("LINESeedJP_OTF_Rg.woff2")
    }
}
