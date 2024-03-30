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
package io.github.mee1080.common.parts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Table(
    rowCount: Int,
    columnCount: Int,
    modifier: Modifier = Modifier,
    rowGap: Dp = 0.dp,
    columnGap: Dp = 0.dp,
    content: @Composable RowScope.(row: Int, column: Int) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(rowGap),
    ) {
        repeat(rowCount) { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(columnGap, Alignment.CenterHorizontally),
            ) {
                repeat(columnCount) { column ->
                    content(row, column)
                }
            }
        }
    }
}

@Composable
fun LinedTable(
    rowCount: Int,
    columnCount: Int,
    modifier: Modifier = Modifier,
    lineWidth: Dp = 1.dp,
    lineColor: Color = MaterialTheme.colorScheme.outlineVariant,
    content: @Composable RowScope.(row: Int, column: Int) -> Unit
) {
    Table(
        rowCount = rowCount,
        columnCount = columnCount,
        modifier = modifier.background(lineColor).border(lineWidth, lineColor),
        rowGap = lineWidth,
        columnGap = lineWidth,
        content = content,
    )
}

@Composable
fun ColumnTable(
    rowCount: Int,
    columnCount: Int,
    modifier: Modifier = Modifier,
    cellPadding: Dp = 4.dp,
    cellBackground: Color = MaterialTheme.colorScheme.surfaceVariant,
    headerBackground: Color = cellBackground,
    rowGap: Dp = 1.dp,
    columnGap: Dp = 1.dp,
    content: @Composable (row: Int, column: Int) -> Unit
) {
    Row(
        modifier = modifier.height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(columnGap),
    ) {
        repeat(columnCount) { column ->
            val background = if (column == 0) headerBackground else cellBackground
            val contentColor = MaterialTheme.colorScheme.contentColorFor(background)
            val cellModifier = Modifier
                .fillMaxWidth()
                .background(if (column == 0) headerBackground else cellBackground)
                .padding(cellPadding)
            Column(
                modifier = Modifier.width(IntrinsicSize.Max),
                verticalArrangement = Arrangement.spacedBy(rowGap, Alignment.CenterVertically),
            ) {
                repeat(rowCount) { row ->
                    Box(cellModifier) {
                        CompositionLocalProvider(LocalContentColor provides contentColor) {
                            content(row, column)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LinedColumnTable(
    rowCount: Int,
    columnCount: Int,
    modifier: Modifier = Modifier,
    cellPadding: Dp = 4.dp,
    cellBackground: Color = MaterialTheme.colorScheme.surface,
    headerBackground: Color = cellBackground,
    borderWidth: Dp = 1.dp,
    borderColor: Color = MaterialTheme.colorScheme.outlineVariant,
    content: @Composable (row: Int, column: Int) -> Unit
) {
    Row(
        modifier = modifier.height(IntrinsicSize.Min),
    ) {
        repeat(columnCount) { column ->
            val background = if (column == 0) headerBackground else cellBackground
            val contentColor = MaterialTheme.colorScheme.contentColorFor(background)
            val cellModifier = Modifier
                .fillMaxWidth()
                .background(background)
                .padding(cellPadding)
            VerticalDivider(Modifier.fillMaxHeight(), borderWidth, borderColor)
            Column(
                modifier = Modifier.width(IntrinsicSize.Max),
            ) {
                repeat(rowCount) { row ->
                    HorizontalDivider(Modifier.fillMaxWidth(), borderWidth, borderColor)
                    Box(cellModifier) {
                        CompositionLocalProvider(LocalContentColor provides contentColor) {
                            content(row, column)
                        }
                    }
                }
                HorizontalDivider(Modifier.fillMaxWidth(), borderWidth, borderColor)
            }
        }
        VerticalDivider(Modifier.fillMaxHeight(), borderWidth, borderColor)
    }
}