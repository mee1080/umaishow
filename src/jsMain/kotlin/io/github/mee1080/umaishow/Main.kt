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
package io.github.mee1080.umaishow

import io.github.mee1080.umaishow.components.CharaPanel
import io.github.mee1080.umaishow.components.RelationTable
import io.github.mee1080.umaishow.data.Store
import io.github.mee1080.umaishow.style.AppStyleSheet
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
    val model = ViewModel(Store)
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)
        CharaPanel(model)
        RelationTable(model)
    }
}