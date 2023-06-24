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
package io.github.mee1080.umaishow.components.pages.calc

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.components.common.LabeledRadio
import io.github.mee1080.umaishow.roundToPercentString
import io.github.mee1080.umaishow.vm.*
import org.jetbrains.compose.web.dom.*

@Composable
fun RatePanel(state: CalcState, charaSelection: CharaSelection, viewModel: ViewModel) {
    H2 { Text("設定") }
    H3 { Text("基本確率") }
    (1..3).forEach { level ->
        Div {
            Text("赤${level}基本発動率：")
            NumberInput(state.setting.baseRate[level] * 100) {
                onInput { e -> e.value?.let { viewModel.updateCalcBaseRate(level, it) } }
            }
        }
    }
    Div {
        Text("親の相性補正：")
        TextInput(state.setting.parentBonus.toString()) {
            onInput { viewModel.updateCalcSetting { copy(parentBonus = it.value.toIntOrNull() ?: parentBonus) } }
        }
    }
    H3 { Text("初期適性") }
    Type.values().forEach { type ->
        Div {
            Text("$type：")
            Rank.values().forEach { rank ->
                LabeledRadio(
                    "initial${type.name}",
                    rank.ordinal.toString(),
                    rank.name,
                    state.setting.initialProperValue[type.ordinal].ordinal == rank.ordinal
                ) {
                    viewModel.updateCalcInitialProper(type, rank)
                }
            }
        }
    }
    H3 { Text("因子") }
    Div {
        FactorSelect(state.setting, viewModel, CharaList.nameList.getOrElse(charaSelection.parent1) { "未選択" }, 0)
        FactorSelect(state.setting, viewModel, CharaList.nameList.getOrElse(charaSelection.parent2) { "未選択" }, 1)
        FactorSelect(state.setting, viewModel, CharaList.nameList.getOrElse(charaSelection.parent11) { "未選択" }, 2)
        FactorSelect(state.setting, viewModel, CharaList.nameList.getOrElse(charaSelection.parent12) { "未選択" }, 3)
        FactorSelect(state.setting, viewModel, CharaList.nameList.getOrElse(charaSelection.parent21) { "未選択" }, 4)
        FactorSelect(state.setting, viewModel, CharaList.nameList.getOrElse(charaSelection.parent22) { "未選択" }, 5)
    }
    H3 { Text("目標適性") }
    Type.values().forEach { type ->
        Div {
            Text("$type：")
            Rank.values().forEach { rank ->
                LabeledRadio(
                    "goal${type.name}",
                    rank.ordinal.toString(),
                    rank.name,
                    state.setting.goalProperValue[type.ordinal].ordinal == rank.ordinal
                ) {
                    viewModel.updateCalcGoalProper(type, rank)
                }
            }
        }
    }
    H2 { Text("計算結果（推定）") }
    H3 { Text("目標達成率： ${state.result.goalRate.roundToPercentString(100)}") }
    H3 { Text("個別発動率") }
    Table {
        Tr {
            Td { Text(CharaList.nameList.getOrElse(charaSelection.parent1) { "未選択" }) }
            Td { Text(state.result.rate1.roundToPercentString(100)) }
        }
        Tr {
            Td { Text(CharaList.nameList.getOrElse(charaSelection.parent2) { "未選択" }) }
            Td { Text(state.result.rate2.roundToPercentString(100)) }
        }
        Tr {
            Td { Text(CharaList.nameList.getOrElse(charaSelection.parent11) { "未選択" }) }
            Td { Text(state.result.rate11.roundToPercentString(100)) }
        }
        Tr {
            Td { Text(CharaList.nameList.getOrElse(charaSelection.parent12) { "未選択" }) }
            Td { Text(state.result.rate12.roundToPercentString(100)) }
        }
        Tr {
            Td { Text(CharaList.nameList.getOrElse(charaSelection.parent21) { "未選択" }) }
            Td { Text(state.result.rate21.roundToPercentString(100)) }
        }
        Tr {
            Td { Text(CharaList.nameList.getOrElse(charaSelection.parent22) { "未選択" }) }
            Td { Text(state.result.rate22.roundToPercentString(100)) }
        }
    }
    H3 { Text("適性別確率") }
    Table {
        Tr {
            Th { Text("種別") }
            Rank.values().forEach {
                Th { Text(it.name) }
            }
        }
        Tr {
            Th { Text("バ場") }
            state.result.groundRate.forEach {
                Td { Text(it.roundToPercentString(100)) }
            }
        }
        Tr {
            Th { Text("距離") }
            state.result.distanceRate.forEach {
                Td { Text(it.roundToPercentString(100)) }
            }
        }
        Tr {
            Th { Text("脚質") }
            state.result.runningTypeRate.forEach {
                Td { Text(it.roundToPercentString(100)) }
            }
        }
    }
}

@Composable
private fun FactorSelect(
    setting: CalcSetting,
    viewModel: ViewModel,
    charaName: String,
    index: Int,
) {
    Div { Text(charaName) }
    Div {
        Type.values().forEach { type ->
            LabeledRadio("type$index", type.ordinal.toString(), type.toString(), setting.properType[index] == type) {
                viewModel.updateCalcProperType(index, type)
            }
        }
    }
    Div {
        (1..3).forEach { level ->
            LabeledRadio("level$index", level.toString(), level.toString(), setting.properLevel[index] == level) {
                viewModel.updateCalcProperLevel(index, level)
            }
        }
    }
}