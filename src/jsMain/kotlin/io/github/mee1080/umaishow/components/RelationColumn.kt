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
import io.github.mee1080.umaishow.style.AppStyleSheet
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.dom.Td
import org.jetbrains.compose.web.dom.Text
import kotlin.math.max

@Composable
fun RelationColumn(value: Int, bold: Boolean = false, colored: Boolean = true) {
    val h = max(0, 27 - value) * 10
    Td({
        classes(RelationColumnStyle.relationColumn)
        style {
            if (bold) property("font-weight", "bold")
            if (colored) backgroundColor(Color.HSL(h, 100, 80))
        }
    }) {
        Text(value.toString())
    }
}

private object RelationColumnStyle : StyleSheet(AppStyleSheet) {
    val relationColumn by style {
        property("text-align", "right")
    }
}