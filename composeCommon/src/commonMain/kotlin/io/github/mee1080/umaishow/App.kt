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
package io.github.mee1080.umaishow

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.pages.table.TablePage
import io.github.mee1080.umaishow.theme.AppTheme
import io.github.mee1080.umaishow.vm.State
import io.github.mee1080.umaishow.vm.ViewModel

@Composable
fun App(state: State, viewModel: ViewModel, font: String) {
    AppTheme(fontResource = font) {
        TablePage(state.tableState, viewModel)
    }
}