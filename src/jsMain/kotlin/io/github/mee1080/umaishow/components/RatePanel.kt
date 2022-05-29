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
package io.github.mee1080.umaishow.components

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.roundToPercentString
import io.github.mee1080.umaishow.vm.ViewModel
import org.jetbrains.compose.web.dom.*

@Composable
fun RatePanel(viewModel: ViewModel) {
    H2 { Text("設定") }
    H3 { Text("基本確率") }
    (1..3).forEach { level ->
        Div {
            Text("赤${level}基本発動率：")
            NumberInput(viewModel.calcSetting.baseRate[level] * 100) {
                onInput { e -> e.value?.let { viewModel.updateCalcBaseRate(level, it) } }
            }
        }
    }
    Div {
        Text("親の相性補正：")
        TextInput(viewModel.calcSetting.parentBonus.toString()) {
            onInput { viewModel.updateCalcSetting { copy(parentBonus = it.value.toIntOrNull() ?: parentBonus) } }
        }
    }
    H3 { Text("初期適性") }
    ViewModel.Type.values().forEach { type ->
        Div {
            Text("$type：")
            ViewModel.Rank.values().forEach { rank ->
                LabeledRadio(
                    "initial${type.name}",
                    rank.ordinal.toString(),
                    rank.name,
                    viewModel.calcSetting.initialProperValue[type.ordinal].ordinal == rank.ordinal
                ) {
                    viewModel.updateCalcInitialProper(type, rank)
                }
            }
        }
    }
    H3 { Text("因子") }
    Div {
        FactorSelect(viewModel, viewModel.charaList[viewModel.parent1], 0)
        FactorSelect(viewModel, viewModel.charaList[viewModel.parent2], 1)
        FactorSelect(viewModel, viewModel.charaList[viewModel.parent11], 2)
        FactorSelect(viewModel, viewModel.charaList[viewModel.parent12], 3)
        FactorSelect(viewModel, viewModel.charaList[viewModel.parent21], 4)
        FactorSelect(viewModel, viewModel.charaList[viewModel.parent22], 5)
    }
    H3 { Text("目標適性") }
    ViewModel.Type.values().forEach { type ->
        Div {
            Text("$type：")
            ViewModel.Rank.values().forEach { rank ->
                LabeledRadio(
                    "goal${type.name}",
                    rank.ordinal.toString(),
                    rank.name,
                    viewModel.calcSetting.goalProperValue[type.ordinal].ordinal == rank.ordinal
                ) {
                    viewModel.updateCalcGoalProper(type, rank)
                }
            }
        }
    }
    H2 { Text("計算結果（推定）") }
    H3 { Text("目標達成率： ${viewModel.calcResult.goalRate.roundToPercentString(100)}") }
    H3 { Text("個別発動率") }
    Table {
        Tr {
            Td { Text(viewModel.charaList[viewModel.parent1]) }
            Td { Text(viewModel.calcResult.rate1.roundToPercentString(100)) }
        }
        Tr {
            Td { Text(viewModel.charaList[viewModel.parent2]) }
            Td { Text(viewModel.calcResult.rate2.roundToPercentString(100)) }
        }
        Tr {
            Td { Text(viewModel.charaList[viewModel.parent11]) }
            Td { Text(viewModel.calcResult.rate11.roundToPercentString(100)) }
        }
        Tr {
            Td { Text(viewModel.charaList[viewModel.parent12]) }
            Td { Text(viewModel.calcResult.rate12.roundToPercentString(100)) }
        }
        Tr {
            Td { Text(viewModel.charaList[viewModel.parent21]) }
            Td { Text(viewModel.calcResult.rate21.roundToPercentString(100)) }
        }
        Tr {
            Td { Text(viewModel.charaList[viewModel.parent22]) }
            Td { Text(viewModel.calcResult.rate22.roundToPercentString(100)) }
        }
    }
    H3 { Text("適性別確率") }
    Table {
        Tr {
            Th { Text("種別") }
            ViewModel.Rank.values().forEach {
                Th { Text(it.name) }
            }
        }
        Tr {
            Th { Text("バ場") }
            viewModel.calcResult.groundRate.forEach {
                Td { Text(it.roundToPercentString(100)) }
            }
        }
        Tr {
            Th { Text("距離") }
            viewModel.calcResult.distanceRate.forEach {
                Td { Text(it.roundToPercentString(100)) }
            }
        }
        Tr {
            Th { Text("脚質") }
            viewModel.calcResult.runningTypeRate.forEach {
                Td { Text(it.roundToPercentString(100)) }
            }
        }
    }
}

@Composable
private fun FactorSelect(
    viewModel: ViewModel,
    charaName: String,
    index: Int,
) {
    val setting = viewModel.calcSetting
    Div { Text(charaName) }
    Div {
        ViewModel.Type.values().forEach { type ->
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