package io.github.mee1080.umaishow.components

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.target
import org.jetbrains.compose.web.attributes.selected
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Select
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSelectElement

@Composable
fun CharaSelect(
    label: String,
    selection: List<Pair<Int, String>>,
    selectedValue: Int,
    onSelect: (Int) -> Unit,
) {
    Div({style { padding(8.px) }}) {
        Text(label)
        Select({
            prop(
                { e: HTMLSelectElement, v -> e.selectedIndex = v },
                selection.indexOfFirst { it.first == selectedValue })
            onChange { onSelect(it.target<HTMLSelectElement>().value.toInt()) }
        }) {
            selection.forEach { (index, name) ->
                Option(index.toString(), { if (index == selectedValue) selected() }) { Text(name) }
            }
        }
    }
}