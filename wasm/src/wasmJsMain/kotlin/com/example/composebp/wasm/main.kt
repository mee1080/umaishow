package com.example.composebp.wasm

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import io.github.mee1080.umaishow.App
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalComposeUiApi::class, ExperimentalCoroutinesApi::class)
fun main() {
    ComposeViewport("ComposeTarget") {
        App()
    }
}
