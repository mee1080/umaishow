package io.github.mee1080.umaishow.components

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.style.AppStyleSheet
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.dom.*

@Composable
fun RelationTable(model: ViewModel) {
    Div {
        Table {
            Tr {
                Th({
                    classes(AppStyleSheet.ckickable)
                    onClick { model.sort(-2) }
                }) { Small { Text("列クリックでソート→") } }
                if (model.childSelected) {
                    Th({
                        classes(AppStyleSheet.verticalHeader, AppStyleSheet.ckickable)
                        onClick { model.sort(-1) }
                    }) { Text("親相性") }
                }
                model.charaList.forEachIndexed { index, name ->
                    Th({
                        classes(AppStyleSheet.verticalHeader, AppStyleSheet.ckickable)
                        onClick { model.sort(index) }
                    }) { Text(name) }
                }
                Th({
                    classes(AppStyleSheet.verticalHeader, AppStyleSheet.ckickable)
                    onClick { model.sort(model.charaList.size) }
                }) { Text("合計") }
            }
            model.relationTable.forEach { (name, parent, grandParent) ->
                Tr {
                    Th({ classes(AppStyleSheet.horizontalHeader) }) { Text(name) }
                    if (model.childSelected) {
                        RelationColumn(parent, true)
                    }
                    grandParent.forEachIndexed { index, value ->
                        RelationColumn(
                            value,
                            false,
                            index < grandParent.lastIndex
                        )
                    }
                }
            }
        }
    }
}