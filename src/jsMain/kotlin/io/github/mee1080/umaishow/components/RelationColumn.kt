package io.github.mee1080.umaishow.components

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.style.AppStyleSheet
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.dom.Td
import org.jetbrains.compose.web.dom.Text
import kotlin.math.max

@Composable
fun RelationColumn(value: Int, bold: Boolean = false) {
    val h = max(0, 27 - value) * 10
    Td({
        classes(RelationColumnStyle.relationColumn)
        style {
            if (bold) property("font-weight", "bold")
            backgroundColor(Color.HSL(h, 100, 80))
        }
    }) {
        Text(value.toString())
    }
}

private object RelationColumnStyle : StyleSheet(AppStyleSheet) {
    val relationColumn by style {
        property("text-align", "right")
    }
}