package io.github.mee1080.umaishow.pages.table

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import io.github.mee1080.common.atoms.LabeledRadioButton
import io.github.mee1080.common.atoms.MyButton
import io.github.mee1080.common.atoms.TextWithLink
import io.github.mee1080.umaishow.vm.FilterMode
import io.github.mee1080.umaishow.vm.State
import io.github.mee1080.umaishow.vm.ViewModel
import kotlinx.collections.immutable.persistentListOf

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SettingBlock(state: State, viewModel: ViewModel) {
    val tableState by derivedStateOf { state.tableState }
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
//        SelectBox(
//            items = state.charaList.childList,
//            selectedItem = state.charaSelection.childEntry,
//            onSelect = { viewModel.updateChild(it.first) },
//            label = { Text("表示対象") },
//            itemToString = { it.second },
//        )
        Column {
            FilterSettingPanel(
                label = "行表示対象",
                mode = tableState.rowFilter.mode,
                showRelationFilterDialog = { viewModel.showRowRelationFilterDialog = true },
                showNameFilterDialog = { viewModel.showRowNameFilterDialog = true },
                update = { viewModel.updateRowFilter { copy(mode = it) } },
            )
            FilterSettingPanel(
                label = "列表示対象",
                mode = tableState.columnFilter.mode,
                showRelationFilterDialog = { viewModel.showColumnRelationFilterDialog = true },
                showNameFilterDialog = { viewModel.showColumnNameFilterDialog = true },
                update = { viewModel.updateColumnFilter { copy(mode = it) } },
            )
        }
        TextWithLink(
            persistentListOf(
                "データは適当です。" to null,
                "#ウマ娘エイプリルフール" to "https://twitter.com/hashtag/%E3%82%A6%E3%83%9E%E5%A8%98%E3%82%A8%E3%82%A4%E3%83%97%E3%83%AA%E3%83%AB%E3%83%95%E3%83%BC%E3%83%AB",
            )
        )
    }
    RelationFilterSettingDialog(
        opened = viewModel.showRowRelationFilterDialog,
        onDismissRequest = { viewModel.showRowRelationFilterDialog = false },
        list = tableState.rowFilter.relation,
        delete = { viewModel.deleteRowRelationFilter(it) },
        add = { viewModel.addRowRelationFilter() },
        edit = { index, value -> viewModel.setRowRelationFilter(index, value) },
    )
    NameFilterSettingDialog(
        opened = viewModel.showRowNameFilterDialog,
        onDismissRequest = { viewModel.showRowNameFilterDialog = false },
        list = tableState.rowFilter.names,
        delete = { viewModel.deleteRowNameFilter(it) },
        add = { viewModel.addRowNameFilter() },
        edit = { index, value -> viewModel.setRowNameFilter(index, value) },
    )
    RelationFilterSettingDialog(
        opened = viewModel.showColumnRelationFilterDialog,
        onDismissRequest = { viewModel.showColumnRelationFilterDialog = false },
        list = tableState.columnFilter.relation,
        delete = { viewModel.deleteColumnRelationFilter(it) },
        add = { viewModel.addColumnRelationFilter() },
        edit = { index, value -> viewModel.setColumnRelationFilter(index, value) },
    )
    NameFilterSettingDialog(
        opened = viewModel.showColumnNameFilterDialog,
        onDismissRequest = { viewModel.showColumnNameFilterDialog = false },
        list = tableState.columnFilter.names,
        delete = { viewModel.deleteColumnNameFilter(it) },
        add = { viewModel.addColumnNameFilter() },
        edit = { index, value -> viewModel.setColumnNameFilter(index, value) },
    )
}

@Composable
fun FilterSettingPanel(
    label: String,
    mode: FilterMode,
    showRelationFilterDialog: () -> Unit,
    showNameFilterDialog: () -> Unit,
    update: (FilterMode) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(label)
        LabeledRadioButton(
            selected = mode == FilterMode.NONE,
            onClick = { update(FilterMode.NONE) },
        ) { Text("すべて") }
        LabeledRadioButton(
            selected = mode == FilterMode.RELATION,
            onClick = { update(FilterMode.RELATION) },
        ) { Text("要素") }
        MyButton(
            onClick = showRelationFilterDialog,
            enabled = mode == FilterMode.RELATION,
        ) { Text("設定") }
//        LabeledRadioButton(
//            selected = mode == FilterMode.NAME,
//            onClick = { update(FilterMode.NAME) },
//        ) { Text("名前") }
//        MyButton(
//            onClick = showNameFilterDialog,
//            enabled = mode == FilterMode.NAME,
//        ) { Text("設定") }
    }
}