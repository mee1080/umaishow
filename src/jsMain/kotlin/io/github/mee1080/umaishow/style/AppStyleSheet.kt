package io.github.mee1080.umaishow.style

import org.jetbrains.compose.web.css.StyleSheet

object AppStyleSheet : StyleSheet() {
    val verticalHeader by style {
        property("writing-mode", "vertical-rl")
        property("text-align", "right")
    }

    val horizontalHeader by style {
        property("white-space", "nowrap")
        property("text-align", "right")
    }
}