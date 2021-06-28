package io.github.mee1080.umaishow

import io.github.mee1080.umaishow.components.CharaPanel
import io.github.mee1080.umaishow.components.RelationTable
import io.github.mee1080.umaishow.data.Store
import io.github.mee1080.umaishow.style.AppStyleSheet
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
    val model = ViewModel(Store)
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)
        CharaPanel(model)
        RelationTable(model)
    }
}