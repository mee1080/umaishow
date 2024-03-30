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

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextDecoration
import io.github.mee1080.common.lib.buildPersistentList
import io.github.mee1080.common.lib.jumpToUrl
import kotlinx.collections.immutable.ImmutableList

private val urlRegex = "https?://[\\w/:%#$&?()~.=+\\-]+".toRegex()

@Composable
fun TextWithLink(
    text: String,
    modifier: Modifier = Modifier,
    linkStyle: SpanStyle = SpanStyle(
        color = Color.Blue,
        textDecoration = TextDecoration.Underline,
    ),
) {
    val contents = buildPersistentList {
        var index = 0
        var result = urlRegex.find(text)
        while (result != null) {
            val start = result.range.first
            if (start > index) {
                add(text.substring(index, start) to null)
            }
            val url = text.substring(result.range)
            add(url to url)
            index = result.range.last + 1
            result = result.next()
        }
        if (index < text.length) {
            add(text.substring(index) to null)
        }
    }
    TextWithLink(contents, modifier, linkStyle)
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun TextWithLink(
    contents: ImmutableList<Pair<String, String?>>,
    modifier: Modifier = Modifier,
    linkStyle: SpanStyle = SpanStyle(
        color = Color.Blue,
        textDecoration = TextDecoration.Underline,
    ),
) {
    val content = buildAnnotatedString {
        contents.forEach { (text, url) ->
            if (url == null) {
                append(text)
            } else {
                withAnnotation(UrlAnnotation(url)) {
                    withStyle(linkStyle) {
                        append(text)
                    }
                }
            }
        }
    }
    ClickableText(
        text = content,
        style = LocalTextStyle.current,
        modifier = modifier,
    ) { offset ->
        content.getUrlAnnotations(offset, offset).firstOrNull()?.let { annotation ->
            jumpToUrl(annotation.item.url)
        }
    }
}