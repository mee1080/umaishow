package io.github.mee1080.umaishow

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import io.github.mee1080.umaishow.data.Store
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.HTMLSelectElement
import kotlin.math.max

fun main() {
    var chara: Int by mutableStateOf(0)

    renderComposable(rootElementId = "root") {
        Div {
            Select({
                onChange {
                    console.log(it.nativeEvent.currentTarget)
                    chara = it.target<HTMLSelectElement>().value.toInt()
                }
            }) {
                Store.charaList.forEachIndexed { index, value ->
                    Option(index.toString()) { Text(value) }
                }
            }
        }
        Div {
            Table {
                Tr {
                    Th { Text("") }
                    Store.charaList.forEach { Th({ style { property("writing-mode", "vertical-rl") } }) { Text(it) } }
                }
                Store.charaList.forEachIndexed { index, name ->
                    Tr {
                        Th({ style { property("white-space", "nowrap") } }) { Text(name) }
                        Store.grandParentList(chara, index).forEach {
                            val h = max(0, 27 - it) * 10
                            Td({
                                style {
                                    backgroundColor(Color.HSL(h, 100, 80))
                                }
                            }) {
                                Text(it.toString())
                            }
                        }
                    }
                }
            }
        }
    }
}