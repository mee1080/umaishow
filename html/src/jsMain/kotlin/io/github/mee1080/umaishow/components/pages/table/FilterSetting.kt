package io.github.mee1080.umaishow.components.pages.table

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.components.pages.chara.CharaSelect
import io.github.mee1080.umaishow.components.common.LabeledCheckbox
import io.github.mee1080.umaishow.components.common.LabeledRadio
import io.github.mee1080.umaishow.components.mwc.*
import io.github.mee1080.umaishow.vm.CharaList
import io.github.mee1080.umaishow.vm.FilterMode
import io.github.mee1080.umaishow.vm.TableState
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun FilterSetting(state: TableState, model: ViewModel) {

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
            CharaList.nameList.forEach { name ->
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
                    CharaSelect("", CharaList.relationFilter, value) {
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
            CharaList.columnList.forEach { name ->
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
                    CharaSelect("", CharaList.relationFilter, value) {
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