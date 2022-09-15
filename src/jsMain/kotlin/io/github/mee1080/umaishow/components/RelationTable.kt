/*
 * Copyright 2021 mee1080
 *
 * This file is part of umaishow.
 *
 * umaishow is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * umaishow is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with umaishow.  If not, see <https://www.gnu.org/licenses/>.
 */
package io.github.mee1080.umaishow.components

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.onClickOrTouch
import io.github.mee1080.umaishow.style.AppStyleSheet
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.dom.*

@Composable
fun RelationTable(model: ViewModel) {
    Div {
        Table({
            classes(
                *model.rowHideIndices.map { AppStyleSheet.hideRow[it] }.toTypedArray(),
                *model.columnHideIndices.map { AppStyleSheet.hideColumn[it] }.toTypedArray(),
            )
        }) {
            Tr {
                Th {
                    Span({
                        classes(AppStyleSheet.verticalHeader)
                    }) { Text("所持") }
                }
                Th({
                    classes(AppStyleSheet.clickable)
                    onClickOrTouch { model.sort(-2) }
                }) { Small { Text("列クリックでソート→") } }
                if (model.childSelected) {
                    Th {
                        Span({
                            classes(AppStyleSheet.verticalHeader, AppStyleSheet.clickable)
                            onClickOrTouch { model.sort(-1) }
                        }) { Text("親相性") }
                    }
                }
                model.charaList.forEachIndexed { index, name ->
                    Th({ classes(AppStyleSheet.column[index]) }) {
                        Span({
                            classes(AppStyleSheet.verticalHeader, AppStyleSheet.clickable)
                            onClickOrTouch { model.sort(index) }
                        }) { Text(name) }
                    }
                }
                Th {
                    Span({
                        classes(AppStyleSheet.verticalHeader, AppStyleSheet.clickable)
                        onClickOrTouch { model.sort(model.charaList.size) }
                    }) { Text("合計") }
                }
            }
            model.relationTable.forEach { (target, parent, grandParent) ->
                val (rowIndex, name) = target
                Tr({ classes(AppStyleSheet.row[rowIndex]) }) {
                    Td {
                        CheckboxInput(model.ownedChara[name] ?: false) {
                            onChange { model.updateOwnedChara(name, it.value) }
                        }
                    }
                    Th({ classes(AppStyleSheet.horizontalHeader) }) { Text(name) }
                    if (model.childSelected) {
                        RelationColumn(parent, "child", true)
                    }
                    grandParent.forEachIndexed { columnIndex, value ->
                        RelationColumn(
                            value,
                            AppStyleSheet.column[columnIndex],
                            false,
                            columnIndex < grandParent.lastIndex
                        )
                    }
                }
            }
        }
    }
}