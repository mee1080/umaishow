/*
 * Copyright 2024 mee1080
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
package io.github.mee1080.common.atoms

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import kotlinx.collections.immutable.ImmutableList

@Composable
fun <T> SelectBox(
    items: ImmutableList<T>,
    selectedItem: T?,
    onSelect: (T) -> Unit,
    modifier: Modifier = Modifier,
    outlined: Boolean = false,
    label: @Composable (() -> Unit)? = null,
    itemToString: (T) -> String = { it.toString() },
    itemToMenuContent: @Composable (T) -> Unit = { Text(itemToString(it)) },
) {
    var expanded by remember { mutableStateOf(false) }
    SelectBox(
        expanded, { expanded = it },
        items, selectedItem, onSelect, modifier, outlined, label, itemToString, itemToMenuContent
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SelectBox(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    items: ImmutableList<T>,
    selectedItem: T?,
    onSelect: (T) -> Unit,
    modifier: Modifier = Modifier,
    outlined: Boolean = false,
    label: @Composable (() -> Unit)? = null,
    itemToString: (T) -> String = { it.toString() },
    itemToMenuContent: @Composable (T) -> Unit = { Text(itemToString(it)) },
) {
    ExposedDropdownMenuBox(expanded, onExpandedChange, modifier) {
        if (outlined) {
            OutlinedTextField(
                value = selectedItem?.let(itemToString) ?: "",
                onValueChange = {},
                label = label,
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor().pointerHoverIcon(PointerIcon.Hand, overrideDescendants = true)
            )
        } else {
            TextField(
                value = selectedItem?.let(itemToString) ?: "",
                onValueChange = {},
                label = label,
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor().pointerHoverIcon(PointerIcon.Hand, overrideDescendants = true)
            )
        }
        ExposedDropdownMenu(expanded, { onExpandedChange(false) }) {
            items.forEach {
                DropdownMenuItem(
                    text = { itemToMenuContent(it) },
                    onClick = {
                        onSelect(it)
                        onExpandedChange(false)
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}