/*
 * Copyright 2022 mee1080
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
@file:Suppress("unused")

package io.github.mee1080.umaishow.components.mwc

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.TagElement
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement

@Composable
fun MwcDialog(
    onPrimaryButton: (() -> Unit)? = null,
    onSecondaryButton: (() -> Unit)? = null,
    primaryButtonLabel: @Composable ElementScope<MwcButtonElement>.() -> Unit = { Text("OK") },
    secondaryButtonLabel: @Composable ElementScope<MwcButtonElement>.() -> Unit = { Text("Cancel") },
    attrs: MwcDialogAttrsScope .() -> Unit = {},
    content: @Composable ElementScope<MwcDialogElement>.() -> Unit,
) {
    MwcDialog(attrs) {
        content()
        onPrimaryButton?.let {
            MwcDialogButton("primaryAction", it, primaryButtonLabel)
        }
        onSecondaryButton?.let {
            MwcDialogButton("secondaryAction", it, secondaryButtonLabel)
        }
    }
}

@Composable
fun MwcDialog(
    attrs: MwcDialogAttrsScope.() -> Unit,
    content: @Composable ElementScope<MwcDialogElement>.() -> Unit,
) {
    TagElement("mwc-dialog", {
        val scope = MwcDialogAttrsScope(this)
        attrs.invoke(scope)
    }, content)
}

@Composable
private fun MwcDialogButton(
    slot: String,
    onClick: () -> Unit,
    label: @Composable ElementScope<MwcButtonElement>.() -> Unit,
) {
    MwcButton({
        slot(slot)
        onClick { onClick() }
    }, label)
}

abstract external class MwcDialogElement : HTMLElement

class MwcDialogAttrsScope(
    attrsScope: AttrsScope<MwcDialogElement>,
) : AttrsScope<MwcDialogElement> by attrsScope {

    fun onClose(
        listener: () -> Unit
    ) {
        addEventListener("closed") {
            if (it.nativeEvent.asDynamic().detail?.action == "close") {
                listener()
            }
        }
    }
}

fun AttrsScope<MwcDialogElement>.open() = attr("open", "")
fun AttrsScope<MwcDialogElement>.hideActions() = attr("hideActions", "")
fun AttrsScope<MwcDialogElement>.stacked() = attr("stacked", "")
fun AttrsScope<MwcDialogElement>.heading(value: String) = attr("heading", value)
fun AttrsScope<MwcDialogElement>.scrimClickAction(value: String) = attr("scrimClickAction", value)
fun AttrsScope<MwcDialogElement>.escapeKeyAction(value: String) = attr("escapeKeyAction", value)
fun AttrsScope<MwcDialogElement>.defaultAction(value: String) = attr("defaultAction", value)
fun AttrsScope<MwcDialogElement>.actionAttribute(value: String) = attr("actionAttribute", value)
fun AttrsScope<MwcDialogElement>.initialFocusAttribute(value: String) = attr("initialFocusAttribute", value)

fun AttrsScope<MwcDialogElement>.preventClose() {
    scrimClickAction("")
    escapeKeyAction("")
}