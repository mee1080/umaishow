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

import io.github.mee1080.umaishow.components.mwc.initLibraries
import io.github.mee1080.umaishow.components.pages.calc.RatePanel
import io.github.mee1080.umaishow.components.pages.chara.CharaPanel
import io.github.mee1080.umaishow.components.pages.factor.FactorPanel
import io.github.mee1080.umaishow.components.pages.table.TablePage
import io.github.mee1080.umaishow.style.AppStyleSheet
import io.github.mee1080.umaishow.vm.Page
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Hr
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    initLibraries()
    val model = ViewModel()
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)
        CharaPanel(model.state, model)
//        MwcTabBar(
//            Page.values().asList(),
//            model.state.page,
//            { it.displayName },
//            { it.icon },
//            onSelect = { model.navigate(it) },
//        ) {
//            style {
//                marginTop(8.px)
//                marginBottom(8.px)
//            }
//        }
        when (model.state.page) {
            Page.Table -> TablePage(model.state.tableState, model)
            Page.Calc -> RatePanel(model.state.calcState, model.state.charaSelection, model)
            Page.Factor -> FactorPanel(model.state.factorState, model)
        }
        Hr { style { marginTop(16.px) } }
        A(
            href = "https://github.com/mee1080/umaishow/blob/main/Library/web.md",
            attrs = {
                target(ATarget.Blank)
                attr("rel", "noreferrer noopener")
            }
        ) { Text("使用ライブラリ") }
    }
}