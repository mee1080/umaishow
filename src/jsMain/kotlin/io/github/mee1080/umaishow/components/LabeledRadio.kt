package io.github.mee1080.umaishow.components

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.target
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.checked
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLInputElement

@Composable
fun LabeledRadio(name: String, value: String, label: String, checked: Boolean, onChecked: () -> Unit) {
    Label {
        Input(InputType.Radio, value) {
            name(name)
            onChange { if (it.target<HTMLInputElement>().checked) onChecked() }
            if (checked) checked()
        }
        Text(label)
    }
}