package io.github.mee1080.umaishow.pages.table

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.github.mee1080.common.atoms.MyButton
import io.github.mee1080.common.atoms.MyTextField
import io.github.mee1080.common.atoms.SelectBox
import io.github.mee1080.umaishow.vm.CharaList
import kotlinx.collections.immutable.ImmutableList

@Composable
fun RelationFilterSettingDialog(
    opened: Boolean,
    onDismissRequest: () -> Unit,
    list: ImmutableList<Int>,
    delete: (Int) -> Unit,
    add: () -> Unit,
    edit: (Int, Int) -> Unit,
) {
    FilterSettingDialog(opened, onDismissRequest, list, delete, add) { index, value ->
        SelectBox(
            items = CharaList.relationFilter,
            selectedItem = CharaList.relationFilter.firstOrNull { it.first == value }
                ?: CharaList.relationFilter.first(),
            onSelect = { edit(index, it.first) },
            itemToString = { it.second },
        )
    }
}

@Composable
fun NameFilterSettingDialog(
    opened: Boolean,
    onDismissRequest: () -> Unit,
    list: ImmutableList<String>,
    delete: (Int) -> Unit,
    add: () -> Unit,
    edit: (Int, String) -> Unit,
) {
    FilterSettingDialog(opened, onDismissRequest, list, delete, add) { index, value ->
        MyTextField(
            value = value,
            onValueChange = { edit(index, it) },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> FilterSettingDialog(
    opened: Boolean,
    onDismissRequest: () -> Unit,
    list: ImmutableList<T>,
    delete: (Int) -> Unit,
    add: () -> Unit,
    editor: @Composable (index: Int, T) -> Unit,
) {
    if (opened) {
        BasicAlertDialog(
            onDismissRequest = onDismissRequest,
        ) {
            Column(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.large)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                val deleteEnabled = list.size >= 2
                list.forEachIndexed { index, value ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        editor(index, value)
                        if (deleteEnabled) {
                            MyButton(
                                onClick = { delete(index) },
                                modifier = Modifier.padding(start = 8.dp),
                            ) { Text("削除") }
                        }
                    }
                }
                MyButton(
                    onClick = add,
                ) { Text("追加") }
            }
        }
    }
}