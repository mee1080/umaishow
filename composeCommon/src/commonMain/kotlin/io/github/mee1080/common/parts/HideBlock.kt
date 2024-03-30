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

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HideBlock(
    header: String,
    modifier: Modifier = Modifier,
    headerClosed: String = header,
    headerBackground: Color = MaterialTheme.colorScheme.secondaryContainer,
    headerContentColor: Color = MaterialTheme.colorScheme.contentColorFor(headerBackground),
    contentBackGround: Color = MaterialTheme.colorScheme.surface,
    contentContentColor: Color = MaterialTheme.colorScheme.contentColorFor(contentBackGround),
    content: @Composable BoxScope.() -> Unit,
) {
    var open by remember { mutableStateOf(false) }
    HideBlock(
        open = open,
        onToggle = { open = !open },
        header = { Text(header) },
        modifier = modifier,
        headerClosed = { Text(headerClosed) },
        headerBackground = headerBackground,
        headerContentColor = headerContentColor,
        contentBackGround = contentBackGround,
        contentContentColor = contentContentColor,
        content = content,
    )
}

@Composable
fun HideBlock(
    header: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    headerClosed: @Composable RowScope.() -> Unit = header,
    headerBackground: Color = MaterialTheme.colorScheme.secondaryContainer,
    headerContentColor: Color = MaterialTheme.colorScheme.contentColorFor(headerBackground),
    contentBackGround: Color = MaterialTheme.colorScheme.surface,
    contentContentColor: Color = MaterialTheme.colorScheme.contentColorFor(contentBackGround),
    content: @Composable BoxScope.() -> Unit,
) {
    var open by remember { mutableStateOf(false) }
    HideBlock(
        open = open,
        onToggle = { open = !open },
        header = header,
        modifier = modifier,
        headerClosed = headerClosed,
        headerBackground = headerBackground,
        headerContentColor = headerContentColor,
        contentBackGround = contentBackGround,
        contentContentColor = contentContentColor,
        content = content,
    )
}

@Composable
fun HideBlock(
    open: Boolean,
    onToggle: () -> Unit,
    header: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    headerClosed: @Composable RowScope.() -> Unit = header,
    headerBackground: Color = MaterialTheme.colorScheme.secondaryContainer,
    headerContentColor: Color = MaterialTheme.colorScheme.contentColorFor(headerBackground),
    contentBackGround: Color = MaterialTheme.colorScheme.surface,
    contentContentColor: Color = MaterialTheme.colorScheme.contentColorFor(contentBackGround),
    content: @Composable BoxScope.() -> Unit,
) {
    Surface(modifier.then(defaultSurfaceModifier)) {
        Column {
            Row(headerModifier(open, headerBackground, onToggle)) {
                CompositionLocalProvider(LocalContentColor provides headerContentColor) {
                    if (open) {
                        Icon(Icons.Default.ArrowDropUp, "Close")
                        header()
                    } else {
                        Icon(Icons.Default.ArrowDropDown, "Open")
                        headerClosed()
                    }
                }
            }
            Box(contentModifier(open, contentBackGround)) {
                CompositionLocalProvider(LocalContentColor provides contentContentColor) {
                    content()
                }
            }
        }
    }
}

private val surfaceShape @Composable get() = MaterialTheme.shapes.medium

private val topShape
    @Composable get() = surfaceShape.copy(
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp),
    )

private val bottomShape
    @Composable get() = surfaceShape.copy(
        topStart = CornerSize(0.dp),
        topEnd = CornerSize(0.dp),
    )

private val defaultSurfaceModifier
    @Composable get() = Modifier
        .clip(surfaceShape)
        .border(1.dp, MaterialTheme.colorScheme.outlineVariant, surfaceShape)

@Composable
private fun headerModifier(open: Boolean, background: Color, onClick: () -> Unit) = Modifier
    .fillMaxWidth()
    .clip(if (open) topShape else surfaceShape)
    .background(background)
    .clickable(onClick = onClick)
    .pointerHoverIcon(PointerIcon.Hand)
    .padding(8.dp)

@Composable
private fun contentModifier(open: Boolean, background: Color) = Modifier
    .fillMaxWidth()
    .animateContentSize()
    .height(if (open) Dp.Unspecified else 0.dp)
    .background(background, bottomShape)
    .padding(8.dp)
