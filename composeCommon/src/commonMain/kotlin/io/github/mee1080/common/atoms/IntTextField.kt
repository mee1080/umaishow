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

import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IntTextField(
    value: Int,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    onValueChange: (Int) -> Unit,
) {
    var textValue by remember { mutableStateOf("") }
    LaunchedEffect(value) {
        textValue = value.toString()
    }
    OutlinedTextField(
        value = textValue,
        modifier = modifier.width(96.dp),
        label = label,
        singleLine = true,
        onValueChange = { input ->
            textValue = input
            input.toIntOrNull()?.let(onValueChange)
        },
    )
}