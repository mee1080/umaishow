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
import io.github.mee1080.umaishow.components.mwc.*
import io.github.mee1080.umaishow.onClickOrTouch
import io.github.mee1080.umaishow.vm.FilterMode
import io.github.mee1080.umaishow.vm.State
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun CharaPanel(state: State, model: ViewModel) {
    Div({ style { display(DisplayStyle.Flex) } }) {
        Div {
            CharaSelect("表示対象：", state.charaList.childList, state.charaSelection.child) { model.updateChild(it) }
            if (!state.charaSelection.childSelected) {
                Div { Text("キャラを選択すると3世代相性を表示します") }
            } else if (state.charaSelection.combinationError) {
                Div({ style { color(Color.red) } }) { Text("組み合わせ重複") }
            } else {
                val totalRelation = state.charaSelection.totalRelation
                Div { Text("相性合計：${totalRelation}") }
                if (totalRelation >= 151) {
                    Div { Text("◎確定") }
                } else {
                    Div { Text("共通重賞 ${151 - totalRelation} で◎") }
                }
            }
            if (state.charaSelection.childSelected) {
                Div {
                    LabeledRadio("order", "1", "相性順", state.charaSelection.orderByRelation) {
                        model.updateOrderByRelation(true)
                    }
                    LabeledRadio("order", "0", "名前順", !state.charaSelection.orderByRelation) {
                        model.updateOrderByRelation(false)
                    }
                }
            }
        }
        if (state.charaSelection.childSelected) {
            Div {
                Div({ style { display(DisplayStyle.Flex) } }) {
                    CharaSelect(
                        "親1：",
                        state.charaSelection.parent1List,
                        state.charaSelection.parent1
                    ) { model.updateParent1(it) }
                    Div {
                        CharaSelect("祖1-1：", state.charaSelection.parent11List, state.charaSelection.parent11) {
                            model.updateParent11(it)
                        }
                        CharaSelect("祖1-2：", state.charaSelection.parent12List, state.charaSelection.parent12) {
                            model.updateParent12(it)
                        }
                    }
                }
                Div({ style { display(DisplayStyle.Flex) } }) {
                    CharaSelect(
                        "親2：",
                        state.charaSelection.parent2List,
                        state.charaSelection.parent2
                    ) { model.updateParent2(it) }
                    Div {
                        CharaSelect("祖2-1：", state.charaSelection.parent21List, state.charaSelection.parent21) {
                            model.updateParent21(it)
                        }
                        CharaSelect("祖2-2：", state.charaSelection.parent22List, state.charaSelection.parent22) {
                            model.updateParent22(it)
                        }
                    }
                }
                Div {
                    Button({
                        onClickOrTouch { model.autoSetParents() }
                    }) {
                        Text("相性が高くなるよう自動設定")
                    }
                    LabeledRadio("auto", "0", "全てのウマ娘", state.autoSetParentsTarget == 0) {
                        model.updateAutoSetParentsTarget(0)
                    }
                    LabeledRadio("auto", "1", "所持のみ", state.autoSetParentsTarget == 1) {
                        model.updateAutoSetParentsTarget(1)
                    }
                    Button({
                        onClickOrTouch { model.clearParents() }
                    }) {
                        Text("すべて未設定に")
                    }
                }
            }
        }
    }
    Div {
        Text("行表示対象")
        LabeledRadio("rowFilterMode", "0", "全て", state.rowFilter.mode == FilterMode.NONE) {
            model.updateRowFilter { copy(mode = FilterMode.NONE) }
        }
        LabeledRadio("rowFilterMode", "1", "所持のみ", state.rowFilter.mode == FilterMode.OWNED) {
            model.updateRowFilter { copy(mode = FilterMode.OWNED) }
        }
        LabeledRadio("rowFilterMode", "2", "非所持のみ", state.rowFilter.mode == FilterMode.NOT_OWNED) {
            model.updateRowFilter { copy(mode = FilterMode.NOT_OWNED) }
        }
        LabeledRadio("rowFilterMode", "3", "カスタム", state.rowFilter.mode == FilterMode.CUSTOM) {
            model.updateRowFilter { copy(mode = FilterMode.CUSTOM) }
        }
        Button({
            if (state.rowFilter.mode != FilterMode.CUSTOM) disabled()
            onClick {
                model.showRowCustomFilterDialog = true
            }
        }) {
            Text("設定")
        }
        LabeledRadio("rowFilterMode", "4", "要素", state.rowFilter.mode == FilterMode.RELATION) {
            model.updateRowFilter { copy(mode = FilterMode.RELATION) }
        }
        Button({
            if (state.rowFilter.mode != FilterMode.RELATION) disabled()
            onClick {
                model.showRowRelationFilterDialog = true
            }
        }) {
            Text("設定")
        }
        MwcDialog(
            onPrimaryButton = { model.showRowCustomFilterDialog = false },
            onSecondaryButton = { model.updateRowCustomFilterAll() },
            secondaryButtonLabel = { Text("全てON/OFF") },
            attrs = {
                if (model.showRowCustomFilterDialog) open()
                onClose { model.showRowCustomFilterDialog = false }
            }
        ) {
            state.charaNameList.forEach { name ->
                Div {
                    LabeledCheckbox(name, name, state.rowFilter.custom[name] ?: false) {
                        model.updateRowCustomFilter(name, it)
                    }
                }
            }
        }
        MwcDialog(
            onPrimaryButton = { model.showRowRelationFilterDialog = false },
            attrs = {
                if (model.showRowRelationFilterDialog) open()
                onClose { model.showRowRelationFilterDialog = false }
            }
        ) {
            val deleteEnabled = state.rowFilter.relation.size >= 2
            state.rowFilter.relation.forEachIndexed { index, value ->
                Div({ style { display(DisplayStyle.Flex) } }) {
                    if (deleteEnabled) {
                        MwcButton({
                            outlined()
                            dense()
                            onClick { model.deleteRowRelationFilter(index) }
                        }) {
                            Text("削除")
                        }
                    }
                    CharaSelect("", state.charaList.relationFilter, value) {
                        model.setRowRelationFilter(index, it)
                    }
                }
            }
            if (state.rowFilter.relation.last() >= 0) {
                Div {
                    MwcButton({
                        raised()
                        onClick { model.addRowRelationFilter() }
                    }) {
                        Text("追加")
                    }
                }
            }
        }
    }
    Div {
        Text("列表示対象")
        LabeledRadio("columnFilterMode", "0", "全て", state.columnFilter.mode == FilterMode.NONE) {
            model.updateColumnFilter { copy(mode = FilterMode.NONE) }
        }
        LabeledRadio("columnFilterMode", "1", "所持のみ", state.columnFilter.mode == FilterMode.OWNED) {
            model.updateColumnFilter { copy(mode = FilterMode.OWNED) }
        }
        LabeledRadio("columnFilterMode", "2", "非所持のみ", state.columnFilter.mode == FilterMode.NOT_OWNED) {
            model.updateColumnFilter { copy(mode = FilterMode.NOT_OWNED) }
        }
        LabeledRadio("columnFilterMode", "3", "カスタム", state.columnFilter.mode == FilterMode.CUSTOM) {
            model.updateColumnFilter { copy(mode = FilterMode.CUSTOM) }
        }
        Button({
            if (state.columnFilter.mode != FilterMode.CUSTOM) disabled()
            onClick {
                model.showColumnCustomFilterDialog = true
            }
        }) {
            Text("設定")
        }
        LabeledRadio("columnFilterMode", "4", "要素", state.columnFilter.mode == FilterMode.RELATION) {
            model.updateColumnFilter { copy(mode = FilterMode.RELATION) }
        }
        Button({
            if (state.columnFilter.mode != FilterMode.RELATION) disabled()
            onClick {
                model.showColumnRelationFilterDialog = true
            }
        }) {
            Text("設定")
        }
        MwcDialog(
            onPrimaryButton = { model.showColumnCustomFilterDialog = false },
            onSecondaryButton = { model.updateColumnCustomFilterAll() },
            secondaryButtonLabel = { Text("全てON/OFF") },
            attrs = {
                if (model.showColumnCustomFilterDialog) open()
                onClose { model.showColumnCustomFilterDialog = false }
            }
        ) {
            state.charaList.columnList.forEach { name ->
                Div {
                    LabeledCheckbox(name, name, state.columnFilter.custom[name] ?: false) {
                        model.updateColumnCustomFilter(name, it)
                    }
                }
            }
        }
        MwcDialog(
            onPrimaryButton = { model.showColumnRelationFilterDialog = false },
            attrs = {
                if (model.showColumnRelationFilterDialog) open()
                onClose { model.showColumnRelationFilterDialog = false }
            }
        ) {
            val deleteEnabled = state.columnFilter.relation.size >= 2
            state.columnFilter.relation.forEachIndexed { index, value ->
                Div({ style { display(DisplayStyle.Flex) } }) {
                    if (deleteEnabled) {
                        MwcButton({
                            outlined()
                            dense()
                            onClick { model.deleteColumnRelationFilter(index) }
                        }) {
                            Text("削除")
                        }
                    }
                    CharaSelect("", state.charaList.relationFilter, value) {
                        model.setColumnRelationFilter(index, it)
                    }
                }
            }
            if (state.columnFilter.relation.last() >= 0) {
                Div {
                    MwcButton({
                        raised()
                        onClick { model.addColumnRelationFilter() }
                    }) {
                        Text("追加")
                    }
                }
            }
        }
    }
}