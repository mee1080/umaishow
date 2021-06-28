package io.github.mee1080.umaishow.components

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun CharaPanel(model: ViewModel) {
    Div({ style { display(DisplayStyle.Flex) } }) {
        Div {
            CharaSelect("子：", model.childList, model.child) { model.updateChild(it) }
            if (model.combinationError) {
                Div({ style { color("red") } }) { Text("組み合わせ重複") }
            } else {
                Div { Text("相性合計：${model.totalRelation}") }
                if (model.totalRelation >= 151) {
                    Div { Text("◎確定") }
                } else {
                    Div { Text("共通重賞 ${151 - model.totalRelation} で◎") }
                }
            }
            Div {
                LabeledRadio("order", "1", "相性順", model.orderByRelation) {
                    model.orderByRelation = true
                }
                LabeledRadio("order", "0", "名前順", !model.orderByRelation) {
                    model.orderByRelation = false
                }
            }
        }
        Div {
            Div({ style { display(DisplayStyle.Flex) } }) {
                CharaSelect("親1：", model.parent1List, model.parent1) { model.updateParent1(it) }
                Div {
                    CharaSelect("祖1-1：", model.parent11List, model.parent11) { model.updateParent11(it) }
                    CharaSelect("祖1-2：", model.parent12List, model.parent12) { model.updateParent12(it) }
                }
            }
            Div({ style { display(DisplayStyle.Flex) } }) {
                CharaSelect("親2：", model.parent2List, model.parent2) { model.updateParent2(it) }
                Div {
                    CharaSelect("祖2-1：", model.parent21List, model.parent21) { model.updateParent21(it) }
                    CharaSelect("祖2-2：", model.parent22List, model.parent22) { model.updateParent22(it) }
                }
            }
        }
    }
}