package io.github.mee1080.umaishow.components.pages.factor

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.components.common.LabeledSlider
import io.github.mee1080.umaishow.components.mwc.MwcButton
import io.github.mee1080.umaishow.components.mwc.raised
import io.github.mee1080.umaishow.onClickOrTouch
import io.github.mee1080.umaishow.roundToPercentString
import io.github.mee1080.umaishow.style.AppStyleSheet
import io.github.mee1080.umaishow.vm.FactorState
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.dom.*
import kotlin.math.roundToInt

@Composable
fun FactorPanel(state: FactorState, model: ViewModel) {
    H2 { Text("因子周回or本育成シミュレータ") }
    Div { Text("因子周回を続けるべきか、妥協して本育成に行くべきか計算します。") }
    Div { Text("シミュレーションで結果を出すため、実行するたびに多少の誤差が発生します。") }
    H3 { Text("現在の因子で本育成成功する確率") }
    Div { Text("※因子発動を含め、適性スキルステ全て揃う確率を入力") }
    LabeledSlider(state.realSuccessRate, 1, 1000, toDisplay) {
        model.updateFactorState { copy(realSuccessRate = it.toInt()) }
    }
    H3 { Text("因子周回に成功する確率") }
    Div { Text("※白の数とか単純に成否で測れないけど、単純化のため成功/失敗の2択で計算") }
    LabeledSlider(state.circlingSuccessRate, 1, 1000, toDisplay) {
        model.updateFactorState { copy(circlingSuccessRate = it.toInt()) }
    }
    H3 { Text("因子周回成功後に本育成成功する確率") }
    Div { Text("※上の確率で因子周回成功した後、適性スキルステ全て揃う確率を入力") }
    LabeledSlider(state.circlingRealSuccessRate, 1, 1000, toDisplay) {
        model.updateFactorState { copy(circlingRealSuccessRate = it.toInt()) }
    }
    H3 { Text("育成予定回数") }
    LabeledSlider(state.challengeCount, 0, 100) {
        model.updateFactorState { copy(challengeCount = it.toInt()) }
    }
    MwcButton({
        style { margin(16.px) }
        raised()
        onClickOrTouch { model.calcFactorState() }
    }) { Text("計算実行") }
    if (state.result.isNotEmpty()) {
        Table({ classes(AppStyleSheet.table) }) {
            Tr {
                Th { Text("最大因子周回数") }
                Th { Text("必要育成回数期待値") }
                Th { Text("育成予定回数内での本育成成功率") }
                Th { Text("最大") }
            }
            state.result.forEachIndexed { index, (average, rate) ->
                Tr {
                    Td { Text(index.toString()) }
                    Td {
                        Text(((average * 100).roundToInt().toDouble() / 100.0).toString())
                    }
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

private val toDisplay: (Number) -> String = { "${it.toInt() / 10}.${it.toInt() % 10}" }