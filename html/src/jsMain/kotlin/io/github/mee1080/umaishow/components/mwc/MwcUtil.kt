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
package io.github.mee1080.umaishow.components.mwc

import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.StylePropertyValue
import org.jetbrains.compose.web.css.StyleScope

external fun require(module: String)

fun AttrsScope<*>.slot(value: String) = attr("slot", value)

class CssVar<T : StylePropertyValue>(
    private val scope: StyleScope,
    private val name: String,
    private val fallbackValue: (() -> T)? = null,
) {

    val value get() = fallbackValue?.let { "var($name, ${it()})" } ?: "var($name)"

    fun value(defaultValue: T): String {
        return "var($name, $defaultValue)"
    }

    operator fun invoke(value: T) {
        scope.variable(name, value)
    }

    operator fun invoke(other: CssVar<T>) {
        scope.variable(name, other.value)
    }

    operator fun invoke(other: CssVar<T>, defaultValue: T) {
        scope.variable(name, other.value(defaultValue))
    }
}

fun initLibraries() {
    require("@material/mwc-button")
    require("@material/mwc-dialog")
    require("@material/mwc-tab")
    require("@material/mwc-tab-bar")
    require("@material/mwc-slider")
}

val StyleScope.themePrimary get() = CssVar(this, "--mdc-theme-primary") { Color("#6200ee") }
val StyleScope.themeOnPrimary get() = CssVar(this, "--mdc-theme-on-primary") { Color("#fff") }
val StyleScope.themeSecondary get() = CssVar(this, "--mdc-theme-secondary") { Color("#018786") }
val StyleScope.themeOnSecondary get() = CssVar(this, "--mdc-theme-on-secondary") { Color("#fff") }

fun StyleScope.primaryToSecondary() {
    themePrimary(themeSecondary)
    themeOnPrimary(themeOnSecondary)
}

fun AttrsScope<*>.secondary() = style { primaryToSecondary() }