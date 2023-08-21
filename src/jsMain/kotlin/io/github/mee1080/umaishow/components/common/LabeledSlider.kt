package io.github.mee1080.umaishow.components.common

import androidx.compose.runtime.Composable
import io.github.mee1080.umasim.web.components.material.MwcSlider
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun LabeledSlider(
    value: Number,
    min: Number,
    max: Number,
    valueToLabel: (Number) -> String = { it.toString() },
    onChange: (Number) -> Unit,
) {
    Div({
        style {
            display(DisplayStyle.Flex)
            alignItems(AlignItems.Center)
        }
    }) {
        Span({
            style {
                width(60.px)
                textAlign("right")
            }
        }) {
            Text(valueToLabel(value))
        }
        MwcSlider(value, min, max) {
            style {
                flexGrow(1)
                maxWidth(600.px)
            }
            onInput(onChange)
        }
    }
}