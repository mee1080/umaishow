package io.github.mee1080.umaishow.components.pages.factor

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.components.common.LabeledSlider
import io.github.mee1080.umaishow.roundToPercentString
import io.github.mee1080.umaishow.style.AppStyleSheet
import io.github.mee1080.umaishow.vm.FactorState
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun FactorPanel(state: FactorState, model: ViewModel) {
    H2 { Text("因子周回or本育成判定機") }
    Div { Text("因子周回を続けるべきか、妥協して本育成に行くべきか計算します。") }
    Div({
        style {
            display(DisplayStyle.Flex)
            flexWrap(FlexWrap.Wrap)
        }
    }) {
        Div({
            style {
                width(100.percent)
                maxWidth(700.px)
            }
        }) {
            H3 { Text("現在の因子で本育成成功する確率") }
            Div { Text("※因子発動を含め、適性スキルステ全て揃う確率を入力") }
            LabeledSlider(state.realSuccessRate, 1, 1000, toDisplay, { model.calcFactorState() }) {
                model.updateFactorState { copy(realSuccessRate = it.toInt()) }
            }
            H3 { Text("因子周回に成功する確率") }
            Div { Text("※白の数とか単純に成否で測れないけど、単純化のため成功/失敗の2択で計算") }
            LabeledSlider(state.circlingSuccessRate, 1, 1000, toDisplay, { model.calcFactorState() }) {
                model.updateFactorState { copy(circlingSuccessRate = it.toInt()) }
            }
            H3 { Text("因子周回成功後に本育成成功する確率") }
            Div { Text("※上の確率で因子周回成功した後、適性スキルステ全て揃う確率を入力") }
            LabeledSlider(state.circlingRealSuccessRate, 1, 1000, toDisplay, { model.calcFactorState() }) {
                model.updateFactorState { copy(circlingRealSuccessRate = it.toInt()) }
            }
            H3 { Text("育成予定回数") }
            LabeledSlider(state.challengeCount, 0, 100, onChange = { model.calcFactorState() }) {
                model.updateFactorState { copy(challengeCount = it.toInt()) }
            }
        }
        Div({
            style {
                width(100.percent)
                maxWidth(480.px)
            }
        }) {
            H3 { Text("計算結果") }
            if (state.result.isNotEmpty()) {
                Div { Text("因子周回すべき最大回数: ${state.maxRateIndex} 回") }
                Table({ classes(AppStyleSheet.table) }) {
                    Tr {
                        Th { Text("最大因子周回数") }
                        Th { Text("育成予定回数内での本育成成功率") }
                        Th { Text("最大") }
                    }
                    state.result.forEachIndexed { index, rate ->
                        Tr {
                            Td { Text(index.toString()) }
                            Td {
                                Text(rate.roundToPercentString(100))
                            }
                            Td({ style { textAlign("center") } }) {
                                if (index == state.maxRateIndex) Text("★")
                            }
                        }
                    }
                }
                Div { Text("※因子周回成功するか、最大因子周回数まで因子周回して、残り回数を本育成した場合に、本育成成功する確率をシミュレーション") }
                Div { Text("※要するに因子周回は最大でも★がついている回数までにすべき") }
            }
        }
    }
}

private val toDisplay: (Number) -> String = { "${it.toInt() / 10}.${it.toInt() % 10}" }