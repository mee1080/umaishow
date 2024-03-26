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
package io.github.mee1080.umaishow.components.pages.table

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.components.mwc.MwcDialog
import io.github.mee1080.umaishow.components.mwc.open
import io.github.mee1080.umaishow.onClickOrTouch
import io.github.mee1080.umaishow.style.AppStyleSheet
import io.github.mee1080.umaishow.vm.CharaList
import io.github.mee1080.umaishow.vm.TableState
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.dom.*

@Composable
fun RelationTable(state: TableState, model: ViewModel) {
    Div {
        Table({
            classes(
                *state.rowHideIndices.map { AppStyleSheet.hideRow[it] }.toTypedArray(),
                *state.columnHideIndices.map { AppStyleSheet.hideColumn[it] }.toTypedArray(),
            )
        }) {
            Tr {
                Th({ classes(AppStyleSheet.column[CharaList.ownedIndex]) }) {
                    Span({
                        classes(AppStyleSheet.verticalHeader)
                    }) { Text("所持") }
                }
                Th({
                    classes(AppStyleSheet.clickable)
                    onClickOrTouch { model.sort(-2) }
                }) { Small { Text("列クリックでソート→") } }
                if (state.displayChild) {
                    Th {
                        Span({
                            classes(AppStyleSheet.verticalHeader, AppStyleSheet.clickable)
                            onClickOrTouch { model.sort(-1) }
                        }) { Text("親相性") }
                    }
                }
                CharaList.nameList.forEachIndexed { index, name ->
                    Th({ classes(AppStyleSheet.column[index]) }) {
                        Span({
                            classes(AppStyleSheet.verticalHeader, AppStyleSheet.clickable)
                            onClickOrTouch { model.sort(index) }
                        }) { Text(name) }
                    }
                }
                Th({ classes(AppStyleSheet.column[CharaList.totalIndex]) }) {
                    Span({
                        classes(AppStyleSheet.verticalHeader, AppStyleSheet.clickable)
                        onClickOrTouch { model.sort(CharaList.charaCount) }
                    }) { Text("合計") }
                }
                Th({ classes(AppStyleSheet.column[CharaList.relationIndex]) }) {
                    Span({ classes(AppStyleSheet.verticalHeader) }) { Text("要素") }
                }
                Th {
                    Span({ classes(AppStyleSheet.verticalHeader) }) { Text("名前") }
                }
            }
            state.relationTable.forEach { entry ->
                Tr({ classes(AppStyleSheet.row[entry.index]) }) {
                    Td({ classes(AppStyleSheet.column[CharaList.ownedIndex]) }) {
                        CheckboxInput(state.ownedChara[entry.name] ?: false) {
                            onChange { model.updateOwnedChara(entry.name, it.value) }
                        }
                    }
                    Th({ classes(AppStyleSheet.horizontalHeader) }) { Text(entry.name) }
                    if (state.displayChild) {
                        RelationColumn(entry.parentRelation, "child", true)
                    }
                    entry.relationList.forEachIndexed { columnIndex, value ->
                        RelationColumn(value, AppStyleSheet.column[columnIndex], bold = false, colored = true)
                    }
                    RelationColumn(entry.relationTotal, AppStyleSheet.column[CharaList.totalIndex])
                    Td({ classes(AppStyleSheet.column[CharaList.relationIndex]) }) {
                        Span({ classes(AppStyleSheet.relationColumn) }) {
                            Text(entry.info)
                            Button({
                                onClick {
                                    model.showRelationInfo(entry.index)
                                }
                            }) {
                                Text("その他")
                            }
                        }
                    }
                    Th({ classes(AppStyleSheet.nameColumn) }) { Text(entry.name) }
                }
            }
        }
        MwcDialog(
            onPrimaryButton = { model.displayRelationInfo = emptyList() },
            attrs = {
                if (model.displayRelationInfo.isNotEmpty()) open()
                onClose { model.displayRelationInfo = emptyList() }
            }
        ) {
            Div {
                model.displayRelationInfo.forEach {
                    Div { Text(it) }
                }
            }
        }
    }
}