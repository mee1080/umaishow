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
                Th { Text("") }
                if (model.childSelected) {
                    Th({ classes(AppStyleSheet.verticalHeader) }) { Text("親相性") }
                }
                model.charaList.forEach {
                    Th({ classes(AppStyleSheet.verticalHeader) }) { Text(it) }
                }
            }
            model.relationTable.forEach { (name, parent, grandParent) ->
                Tr {
                    Th({ classes(AppStyleSheet.horizontalHeader) }) { Text(name) }
                    if (model.childSelected) {
                        RelationColumn(parent, true)
                    }
                    grandParent.forEach { RelationColumn(it) }
                }
            }
        }
    }
}