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

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.mee1080.common.lib.asComposable

@Composable
fun WithTooltip(
    tooltip: String,
    modifier: Modifier = Modifier,
    isPersistent: Boolean = true,
    content: @Composable () -> Unit,
) {
    WithTooltip(tooltip.asComposable(), modifier, isPersistent, content)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WithTooltip(
    tooltip: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    isPersistent: Boolean = true,
    content: @Composable () -> Unit,
) {
    Box(modifier) {
        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = { PlainTooltip(content = tooltip) },
            state = rememberTooltipState(isPersistent = isPersistent),
            modifier = modifier,
            content = content,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WithRichTooltip(
    text: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit = {},
    action: @Composable () -> Unit = {},
    isPersistent: Boolean = true,
    content: @Composable () -> Unit,
) {
    Box(modifier) {
        TooltipBox(
            positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
            state = rememberTooltipState(isPersistent = isPersistent),
            tooltip = {
                RichTooltip(
                    title = title,
                    action = action,
                    text = text,
                )
            },
            content = content,
        )
    }
}
