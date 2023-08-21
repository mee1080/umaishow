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
package io.github.mee1080.umaishow.style

import io.github.mee1080.umaishow.data.Store
import org.jetbrains.compose.web.css.*

object AppStyleSheet : StyleSheet() {

    val row = Array(Store.charaList.size) { "row-$it" }

    val hideRow = Array(Store.charaList.size) { "hide-row-$it" }

    val column = Array(Store.charaList.size + 3) { "column-$it" }

    val hideColumn = Array(Store.charaList.size + 3) { "hide-column-$it" }

    init {
        for (i in Store.charaList.indices) {
            ".${hideRow[i]} .${row[i]}" style {
                display(DisplayStyle.None)
            }
        }
        for (i in 0..Store.charaList.lastIndex + 2) {
            ".${hideColumn[i]} .${column[i]}" style {
                display(DisplayStyle.None)
            }
        }
    }

    val table by style {
        property("border-collapse", "collapse")

        self + " th" style {
            border(1.px, LineStyle.Solid, Color("black"))
            width(80.px)
        }

        self + " td" style {
            textAlign("right")
            border(1.px, LineStyle.Solid, Color("black"))
            width(80.px)
        }
    }

    val verticalHeader by style {
        property("writing-mode", "vertical-rl")
        property("text-align", "right")
        height(10.em)
        width(1.5.em)
    }

    val horizontalHeader by style {
        whiteSpace("nowrap")
        property("text-align", "right")
    }

    val clickable by style {
        property("cursor", "pointer")
    }

    val relationColumn by style {
        display(DisplayStyle.Flex)
        whiteSpace("nowrap")
    }

    val nameColumn by style {
        whiteSpace("nowrap")
        textAlign("left")
    }
}