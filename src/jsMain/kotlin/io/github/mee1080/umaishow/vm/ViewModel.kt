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
package io.github.mee1080.umaishow.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import io.github.mee1080.umaishow.data.RelationInfo
import io.github.mee1080.umaishow.data.Store
import io.github.mee1080.umaishow.removedAt
import io.github.mee1080.umaishow.replace
import io.github.mee1080.umaishow.replaceAt
import kotlin.math.min

class ViewModel() {

    var state by mutableStateOf(State())

    init {
        updateRelationTable()
    }

    private fun updateState(action: State.() -> State) {
        state = state.action()
    }

    private fun updateSelection(action: CharaSelection.() -> CharaSelection) {
        updateState {
            copy(charaSelection = charaSelection.action())
        }
        updateRelationTable()
    }

    fun updateOrderByRelation(value: Boolean) {
        updateSelection { copy(orderByRelation = value) }
        Preferences.saveParentSortOrder(value)
    }

    fun updateChild(value: Int) {
        updateSelection { copy(child = value) }
    }

    fun updateParent1(value: Int) {
        updateSelection { copy(parent1 = value) }
        calcRate()
    }

    fun updateParent2(value: Int) {
        updateSelection { copy(parent2 = value) }
        calcRate()
    }

    fun updateParent11(value: Int) {
        updateSelection { copy(parent11 = value) }
        calcRate()
    }

    fun updateParent12(value: Int) {
        updateSelection { copy(parent12 = value) }
        calcRate()
    }

    fun updateParent21(value: Int) {
        updateSelection { copy(parent21 = value) }
        calcRate()
    }

    fun updateParent22(value: Int) {
        updateSelection { copy(parent22 = value) }
        calcRate()
    }

    fun updateAutoSetParentsTarget(value: Int) {
        updateState { copy(autoSetParentsTarget = value) }
        Preferences.saveAutoSetParentsTarget(value)
    }

    fun updateOwnedChara(name: String, value: Boolean) {
        updateState { copy(ownedChara = ownedChara.replace(name, value)) }
        Preferences.saveOwnedChara(state.ownedChara.filterValues { it }.keys)
    }

    fun autoSetParents() {
        val state = state
        val selection = state.charaSelection
        if (!selection.childSelected) return
        val (child, parent1, parent2) = listOf(
            selection.child, selection.parent1, selection.parent2
        )
        val (parent11, parent12, parent21, parent22) = listOf(
            selection.parent11, selection.parent12, selection.parent21, selection.parent22
        )
        val targetList = CharaList.indexedCharaList
            .filter { it.first != child && (state.autoSetParentsTarget == 0 || state.ownedChara[it.second] ?: false) }
            .map { it.first }
            .sortedByDescending { Store.parent(child, it) }
        val p1List = (if (parent1 == -1) targetList else listOf(parent1))
            .map { it to Store.parent(child, it) }
        val p2List = (if (parent2 == -1) targetList else listOf(parent2))
            .map { it to Store.parent(child, it) }
        val p11List = if (parent11 == -1) targetList else listOf(parent11)
        val p12List = if (parent12 == -1) targetList else listOf(parent12)
        val p21List = if (parent21 == -1) targetList else listOf(parent21)
        val p22List = if (parent22 == -1) targetList else listOf(parent22)
        var maxRelation = 0
        var maxCombination = listOf(parent1, parent2, parent11, parent12, parent21, parent22)
        val charaCount = CharaList.charaList.size
        val checkedParent1 = BooleanArray(charaCount) { false }
        p1List.forEach { p1Pair ->
            val p1 = p1Pair.first
            val p1Relation = p1Pair.second
            checkedParent1[p1] = true
            p2List.filterNot { checkedParent1[it.first] }.forEach { p2Pair ->
                val p2 = p2Pair.first
                val p2Relation = p2Pair.second
                val parentsRelation = Store.parent(p1, p2)
                if (p1Relation * 3 + p2Relation * 3 + parentsRelation > maxRelation) {
                    val checkedParent11 = BooleanArray(charaCount) { it == p1 }
                    p11List.filter { it != p1 }.forEach { p11 ->
                        checkedParent11[p11] = true
                        val p11Relation = Store.grandParent(child, p1, p11)
                        p12List.filterNot { checkedParent11[it] }.forEach { p12 ->
                            val p12Relation = Store.grandParent(child, p1, p12)
                            if (p1Relation + p11Relation + p12Relation + p2Relation * 3 + parentsRelation > maxRelation) {
                                val checkedParent21 = BooleanArray(charaCount) { it == p2 }
                                p21List.filter { it != p2 }.forEach { p21 ->
                                    checkedParent21[p21] = true
                                    val p21Relation = Store.grandParent(child, p2, p21)
                                    p22List.filterNot { checkedParent21[it] }.forEach { p22 ->
                                        val p22Relation = Store.grandParent(child, p2, p22)
                                        val relation =
                                            p1Relation + p11Relation + p12Relation + p2Relation + p21Relation + p22Relation + parentsRelation
                                        if (relation > maxRelation) {
                                            maxRelation = relation
                                            maxCombination = listOf(p1, p2, p11, p12, p21, p22)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        updateSelection {
            copy(
                parent1 = maxCombination[0],
                parent2 = maxCombination[1],
                parent11 = maxCombination[2],
                parent12 = maxCombination[3],
                parent21 = maxCombination[4],
                parent22 = maxCombination[5],
            )
        }
        calcRate()
    }

    fun clearParents() {
        updateSelection {
            copy(
                parent1 = -1, parent2 = -1,
                parent11 = -1, parent12 = -1,
                parent21 = -1, parent22 = -1,
            )
        }
        calcRate()
    }

    private fun updateRelationTable() {
        val selection = state.charaSelection
        val child = selection.child
        val table = if (selection.childSelected) CharaList.charaList.mapIndexed { index, chara ->
            RelationTableEntry(
                index,
                chara.first,
                Store.parent(child, index),
                Store.grandParentList(child, index),
                RelationInfo.getShortString(chara.second),
            )
        } else CharaList.charaList.mapIndexed { index, chara ->
            RelationTableEntry(
                index,
                chara.first,
                0,
                Store.parentList(index),
                RelationInfo.getShortString(chara.second),
            )
        }
        updateState { copy(rawRelationTable = table) }
        sortRelationTable()
    }

    private fun sortRelationTable() {
        val table = state.rawRelationTable
        val sorted = when (val sortKey = state.sortKey) {
            -2 -> table
            -1 -> table.sortedByDescending { it.parentRelation }
            else -> table.sortedByDescending {
                if (sortKey < it.relationList.size) it.relationList[sortKey] else it.relationTotal
            }
        }
        updateState { copy(relationTable = sorted) }
    }

    fun sort(key: Int) {
        updateState { copy(sortKey = key) }
        sortRelationTable()
    }

    fun updateRowFilter(action: FilterSetting.() -> FilterSetting) {
        updateState { copy(rowFilter = rowFilter.action()) }
        applyRowFilter()
    }

    private fun applyRowFilter() {
        updateState {
            val rowHideIndices = charaList.nameList.mapIndexedNotNull { index, name ->
                if (rowFilter.check(index, name, ownedChara)) null else index
            }
            copy(rowHideIndices = rowHideIndices)
        }
    }

    var showRowCustomFilterDialog by mutableStateOf(false)

    fun updateRowCustomFilter(name: String, value: Boolean) {
        updateRowFilter { copy(custom = custom.replace(name, value)) }
        Preferences.saveRowCustomFilter(state.rowFilter.custom.filterValues { it }.keys)
    }

    fun updateRowCustomFilterAll() {
        val value = !state.rowFilter.custom.values.any { it }
        updateRowFilter { copy(custom = custom.mapValues { value }) }
        Preferences.saveRowCustomFilter(state.rowFilter.custom.filterValues { it }.keys)
    }

    var showRowRelationFilterDialog by mutableStateOf(false)

    fun addRowRelationFilter() {
        updateRowFilter { copy(relation = relation + -1) }
        Preferences.saveRowRelationFilter(state.rowFilter.relation.toList())
    }

    fun deleteRowRelationFilter(index: Int) {
        updateRowFilter { copy(relation = relation.removedAt(index)) }
        Preferences.saveRowRelationFilter(state.rowFilter.relation.toList())
    }

    fun setRowRelationFilter(index: Int, value: Int) {
        updateRowFilter { copy(relation = relation.replaceAt(index, value)) }
        Preferences.saveRowRelationFilter(state.rowFilter.relation.toList())
    }

    fun updateColumnFilter(action: FilterSetting.() -> FilterSetting) {
        updateState { copy(columnFilter = columnFilter.action()) }
        applyColumnFilter()
    }

    private fun applyColumnFilter() {
        updateState {
            val columnHideIndices = charaList.nameList.mapIndexedNotNull { index, name ->
                if (columnFilter.check(index, name, ownedChara)) null else index
            }
            copy(columnHideIndices = columnHideIndices)
        }
    }

    var showColumnCustomFilterDialog by mutableStateOf(false)

    fun updateColumnCustomFilter(name: String, value: Boolean) {
        updateColumnFilter { copy(custom = custom.replace(name, value)) }
        Preferences.saveColumnCustomFilter(state.columnFilter.custom.filterValues { it }.keys)
    }

    fun updateColumnCustomFilterAll() {
        val value = !state.columnFilter.custom.values.any { it }
        updateColumnFilter { copy(custom = custom.mapValues { value }) }
        Preferences.saveColumnCustomFilter(state.columnFilter.custom.filterValues { it }.keys)
    }

    var showColumnRelationFilterDialog by mutableStateOf(false)

    fun addColumnRelationFilter() {
        updateColumnFilter { copy(relation = relation + -1) }
        Preferences.saveColumnRelationFilter(state.columnFilter.relation.toList())
    }

    fun deleteColumnRelationFilter(index: Int) {
        updateColumnFilter { copy(relation = relation.removedAt(index)) }
        Preferences.saveColumnRelationFilter(state.columnFilter.relation.toList())
    }

    fun setColumnRelationFilter(index: Int, value: Int) {
        updateColumnFilter { copy(relation = relation.replaceAt(index, value)) }
        Preferences.saveColumnRelationFilter(state.columnFilter.relation.toList())
    }

    enum class Type(private val display: String) {
        Ground("バ場"), Distance("距離"), RunningStyle("脚質");

        override fun toString() = display
    }

    enum class Rank {
        G, F, E, D, C, B, A, S,
    }

    data class CalcSetting(
        val baseRate: List<Double> = listOf(0.0, 0.02, 0.04, 0.06),
        val parentBonus: Int = 20,

        val initialProperValue: List<Rank> = listOf(Rank.C, Rank.A, Rank.A),
        val goalProperValue: List<Rank> = listOf(Rank.A, Rank.S, Rank.A),
        val properType: List<Type> = List(6) { if (it == 1) Type.Distance else Type.Ground },
        val properLevel: List<Int> = List(6) { 3 },
    )

    data class CalcResult(
        val rate1: Double = 0.0,
        val rate2: Double = 0.0,
        val rate11: Double = 0.0,
        val rate12: Double = 0.0,
        val rate21: Double = 0.0,
        val rate22: Double = 0.0,

        val groundRate: List<Double> = List(8) { 0.0 },
        val distanceRate: List<Double> = List(8) { 0.0 },
        val runningTypeRate: List<Double> = List(8) { 0.0 },

        val goalRate: Double = 0.0,
    )

    var calcSetting by mutableStateOf(CalcSetting())

    var calcResult by mutableStateOf(CalcResult())

    fun updateCalcSetting(update: CalcSetting.() -> CalcSetting) {
        calcSetting = calcSetting.update()
        calcRate()
    }

    fun updateCalcBaseRate(level: Int, value: Number) {
        updateCalcSetting {
            copy(baseRate = baseRate.mapIndexed { index, current -> if (index == level) value.toDouble() / 100 else current })
        }
    }

    fun updateCalcInitialProper(type: Type, rank: Rank) {
        updateCalcSetting {
            copy(
                initialProperValue = initialProperValue.mapIndexed { index, oldRank ->
                    if (index == type.ordinal) rank else oldRank
                }
            )
        }
    }

    fun updateCalcGoalProper(type: Type, rank: Rank) {
        updateCalcSetting {
            copy(
                goalProperValue = goalProperValue.mapIndexed { index, oldRank ->
                    if (index == type.ordinal) rank else oldRank
                }
            )
        }
    }

    fun updateCalcProperType(target: Int, type: Type) {
        updateCalcSetting {
            copy(
                properType = properType.mapIndexed { index, oldType -> if (index == target) type else oldType },
            )
        }
    }

    fun updateCalcProperLevel(target: Int, level: Int) {
        updateCalcSetting {
            copy(
                properLevel = properLevel.mapIndexed { index, oldLevel -> if (index == target) level else oldLevel },
            )
        }
    }

    private fun calcRate() {
        val state = state
        val selection = state.charaSelection
        val (child, parent1, parent2) = listOf(
            selection.child, selection.parent1, selection.parent2
        )
        val (parent11, parent12, parent21, parent22) = listOf(
            selection.parent11, selection.parent12, selection.parent21, selection.parent22
        )
        if (child == -1 || parent1 == -1 || parent2 == -1 || parent11 == -1 || parent12 == -1 || parent21 == -1 || parent22 == -1) {
            calcResult = CalcResult()
        }
        val setting = calcSetting
        val rate1 =
            doCalcRate(setting.baseRate[setting.properLevel[0]], Store.parent(child, parent1) + setting.parentBonus)
        val rate2 =
            doCalcRate(setting.baseRate[setting.properLevel[1]], Store.parent(child, parent2) + setting.parentBonus)
        val rate11 = doCalcRate(setting.baseRate[setting.properLevel[2]], Store.grandParent(child, parent1, parent11))
        val rate12 = doCalcRate(setting.baseRate[setting.properLevel[3]], Store.grandParent(child, parent1, parent12))
        val rate21 = doCalcRate(setting.baseRate[setting.properLevel[4]], Store.grandParent(child, parent2, parent21))
        val rate22 = doCalcRate(setting.baseRate[setting.properLevel[5]], Store.grandParent(child, parent2, parent22))
        val upRates =
            arrayOf(rate1, rate1, rate2, rate2, rate11, rate11, rate12, rate12, rate21, rate21, rate22, rate22)
        val upTargets = Array(12) { setting.properType[it / 2].ordinal }
        val initialProperValues = setting.initialProperValue.map { it.ordinal }
        val results = (0 until 4096).map { value -> Array(12) { value and (1 shl it) != 0 } }.map { upList ->
            upList.foldIndexed(initialProperValues to 1.0) { index, (values, rate), up ->
                if (up) {
                    values.mapIndexed { valueIndex, value ->
                        if (valueIndex == upTargets[index]) {
                            min(value + 1, 7)
                        } else value
                    } to rate * upRates[index]
                } else {
                    values to rate * (1 - upRates[index])
                }
            }
        }
        val totalRates = Array(3) { Array(8) { 0.0 } }
        var goalRate: Double = 0.0
        val goals = setting.goalProperValue.map { it.ordinal }
        results.forEach { (properValues, rate) ->
            totalRates[0][properValues[0]] += rate
            totalRates[1][properValues[1]] += rate
            totalRates[2][properValues[2]] += rate
            if (properValues[0] >= goals[0] && properValues[1] >= goals[1] && properValues[2] >= goals[2]) {
                goalRate += rate
            }
        }
        calcResult = CalcResult(
            rate1, rate2, rate11, rate12, rate21, rate22,
            totalRates[0].toList(), totalRates[1].toList(), totalRates[2].toList(), goalRate,
        )
    }

    private fun doCalcRate(baseRate: Double, relation: Int) = baseRate * (100 + relation) / 100.0

    var displayRelationInfo by mutableStateOf(emptyList<String>())

    fun showRelationInfo(index: Int) {
        displayRelationInfo =
            listOf(CharaList.nameList[index]) + RelationInfo.getLongString(CharaList.charaRelation[index])
    }
}