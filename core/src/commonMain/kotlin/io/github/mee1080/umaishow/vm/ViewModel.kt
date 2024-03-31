/*
 * Copyright 2024 mee1080
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

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import io.github.mee1080.umaishow.*
import io.github.mee1080.umaishow.data.RelationInfo
import io.github.mee1080.umaishow.data.Store
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import kotlin.math.pow
import kotlin.random.Random

@Stable
class ViewModel(private val doFilterRelationTable: Boolean = false) {

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

    private fun updateTableState(action: TableState.() -> TableState) {
        updateState {
            copy(tableState = tableState.action())
        }
    }

    fun navigate(page: Page) {
        updateState { copy(page = page) }
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
        updateTableState { copy(ownedChara = ownedChara.replace(name, value).toImmutableMap()) }
        Preferences.saveOwnedChara(state.tableState.ownedChara.filterValues { it }.keys)
    }

//    fun autoSetParents() {
//        val state = state
//        val selection = state.charaSelection
//        if (!selection.childSelected) return
//        val (child, parent1, parent2) = listOf(
//            selection.child, selection.parent1, selection.parent2
//        )
//        val (parent11, parent12, parent21, parent22) = listOf(
//            selection.parent11, selection.parent12, selection.parent21, selection.parent22
//        )
//        val targetList = CharaList.indexedCharaList
//            .filter { it.first != child && (state.autoSetParentsTarget == 0 || state.tableState.ownedChara[it.second] ?: false) }
//            .map { it.first }
//            .sortedByDescending { Store.parent(child, it) }
//        val p1List = (if (parent1 == -1) targetList else listOf(parent1))
//            .map { it to Store.parent(child, it) }
//        val p2List = (if (parent2 == -1) targetList else listOf(parent2))
//            .map { it to Store.parent(child, it) }
//        val p11List = if (parent11 == -1) targetList else listOf(parent11)
//        val p12List = if (parent12 == -1) targetList else listOf(parent12)
//        val p21List = if (parent21 == -1) targetList else listOf(parent21)
//        val p22List = if (parent22 == -1) targetList else listOf(parent22)
//        var maxRelation = 0
//        var maxCombination = listOf(parent1, parent2, parent11, parent12, parent21, parent22)
//        val charaCount = CharaList.charaList.size
//        val checkedParent1 = BooleanArray(charaCount) { false }
//        p1List.forEach { p1Pair ->
//            val p1 = p1Pair.first
//            val p1Relation = p1Pair.second
//            checkedParent1[p1] = true
//            p2List.filterNot { checkedParent1[it.first] }.forEach { p2Pair ->
//                val p2 = p2Pair.first
//                val p2Relation = p2Pair.second
//                val parentsRelation = Store.parent(p1, p2)
//                if (p1Relation * 3 + p2Relation * 3 + parentsRelation > maxRelation) {
//                    val checkedParent11 = BooleanArray(charaCount) { it == p1 }
//                    p11List.filter { it != p1 }.forEach { p11 ->
//                        checkedParent11[p11] = true
//                        val p11Relation = Store.grandParent(child, p1, p11)
//                        p12List.filterNot { checkedParent11[it] }.forEach { p12 ->
//                            val p12Relation = Store.grandParent(child, p1, p12)
//                            if (p1Relation + p11Relation + p12Relation + p2Relation * 3 + parentsRelation > maxRelation) {
//                                val checkedParent21 = BooleanArray(charaCount) { it == p2 }
//                                p21List.filter { it != p2 }.forEach { p21 ->
//                                    checkedParent21[p21] = true
//                                    val p21Relation = Store.grandParent(child, p2, p21)
//                                    p22List.filterNot { checkedParent21[it] }.forEach { p22 ->
//                                        val p22Relation = Store.grandParent(child, p2, p22)
//                                        val relation =
//                                            p1Relation + p11Relation + p12Relation + p2Relation + p21Relation + p22Relation + parentsRelation
//                                        if (relation > maxRelation) {
//                                            maxRelation = relation
//                                            maxCombination = listOf(p1, p2, p11, p12, p21, p22)
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        updateSelection {
//            copy(
//                parent1 = maxCombination[0],
//                parent2 = maxCombination[1],
//                parent11 = maxCombination[2],
//                parent12 = maxCombination[3],
//                parent21 = maxCombination[4],
//                parent22 = maxCombination[5],
//            )
//        }
//        calcRate()
//    }

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
//        val child = selection.child
//        val table = if (selection.childSelected) CharaList.charaList.mapIndexedImmutable { index, chara ->
//            RelationTableEntry(
//                index,
//                chara.first,
//                Store.parent(child, index),
//                Store.grandParentList(child, index),
//                RelationInfo.getShortString(chara.second),
//            )
        val table = CharaList.charaList.mapIndexedImmutable { index, chara ->
            RelationTableEntry(
                index,
                chara.first,
                0,
                Store.parentList(index),
                RelationInfo.getShortString(chara.second),
            )
        }
        updateTableState { copy(rawRelationTable = table, displayChild = selection.childSelected) }
        sortRelationTable()
    }

    private fun sortRelationTable() {
        val table = state.tableState.rawRelationTable
        var sorted = when (val sortKey = state.tableState.sortKey) {
            -2 -> table
            -1 -> table.sortedByDescending { it.parentRelation }.toImmutableList()
            else -> table.sortedByDescending {
                if (sortKey < it.relationList.size) it.relationList[sortKey] else it.relationTotal
            }.toImmutableList()
        }
        var charaNames = CharaList.indexedCharaList
        if (doFilterRelationTable) {
            val rowHideIndices = state.tableState.rowHideIndices.toSet()
            val columnHideIndices = state.tableState.columnHideIndices.toSet()
            sorted = sorted.map {
                val newList = it.relationList.filterIndexed { index, _ ->
                    !columnHideIndices.contains(index)
                }.toImmutableList()
                it.copy(relationList = newList)
            }.filter {
                !rowHideIndices.contains(it.index)
            }.toImmutableList()
            charaNames = charaNames.filterIndexed { index, _ ->
                !columnHideIndices.contains(index)
            }.toImmutableList()
        }
        updateTableState { copy(relationTable = sorted, headerCharaNames = charaNames) }
    }

    fun sort(key: Int) {
        updateTableState { copy(sortKey = key) }
        sortRelationTable()
    }

    fun updateRowFilter(action: FilterSetting.() -> FilterSetting) {
        updateTableState { copy(rowFilter = rowFilter.action()) }
        applyRowFilter()
    }

    private fun applyRowFilter() {
        updateTableState {
            val rowHideIndices = CharaList.nameList.mapIndexedNotNull { index, name ->
                if (rowFilter.check(index, name, ownedChara)) null else index
            }.toImmutableList()
            copy(rowHideIndices = rowHideIndices)
        }
        if (doFilterRelationTable) sortRelationTable()
    }

    var showRowCustomFilterDialog by mutableStateOf(false)

    fun updateRowCustomFilter(name: String, value: Boolean) {
        updateRowFilter { copy(custom = custom.replace(name, value).toImmutableMap()) }
        Preferences.saveRowCustomFilter(state.tableState.rowFilter.custom.filterValues { it }.keys)
    }

    fun updateRowCustomFilterAll() {
        val value = !state.tableState.rowFilter.custom.values.any { it }
        updateRowFilter { copy(custom = custom.mapValues { value }.toImmutableMap()) }
        Preferences.saveRowCustomFilter(state.tableState.rowFilter.custom.filterValues { it }.keys)
    }

    var showRowRelationFilterDialog by mutableStateOf(false)

    fun addRowRelationFilter() {
        updateRowFilter { copy(relation = (relation + -1).toImmutableList()) }
        Preferences.saveRowRelationFilter(state.tableState.rowFilter.relation)
    }

    fun deleteRowRelationFilter(index: Int) {
        updateRowFilter { copy(relation = relation.removedAt(index).toImmutableList()) }
        Preferences.saveRowRelationFilter(state.tableState.rowFilter.relation)
    }

    fun setRowRelationFilter(index: Int, value: Int) {
        updateRowFilter { copy(relation = relation.replaceAt(index, value).toImmutableList()) }
        Preferences.saveRowRelationFilter(state.tableState.rowFilter.relation)
    }

    var showRowNameFilterDialog by mutableStateOf(false)

    fun addRowNameFilter() {
        updateRowFilter { copy(names = (names + "").toImmutableList()) }
        Preferences.saveRowNameFilter(state.tableState.rowFilter.names)
    }

    fun deleteRowNameFilter(index: Int) {
        updateRowFilter { copy(names = names.removedAt(index).toImmutableList()) }
        Preferences.saveRowNameFilter(state.tableState.rowFilter.names)
    }

    fun setRowNameFilter(index: Int, value: String) {
        updateRowFilter { copy(names = names.replaceAt(index, value).toImmutableList()) }
        Preferences.saveRowNameFilter(state.tableState.rowFilter.names)
    }

    fun updateColumnFilter(action: FilterSetting.() -> FilterSetting) {
        updateTableState { copy(columnFilter = columnFilter.action()) }
        applyColumnFilter()
    }

    private fun applyColumnFilter() {
        updateTableState {
            val columnHideIndices = CharaList.nameList.mapIndexedNotNull { index, name ->
                if (columnFilter.check(index, name, ownedChara)) null else index
            }.toImmutableList()
            copy(columnHideIndices = columnHideIndices)
        }
        if (doFilterRelationTable) sortRelationTable()
    }

    var showColumnCustomFilterDialog by mutableStateOf(false)

    fun updateColumnCustomFilter(name: String, value: Boolean) {
        updateColumnFilter { copy(custom = custom.replace(name, value).toImmutableMap()) }
        Preferences.saveColumnCustomFilter(state.tableState.columnFilter.custom.filterValues { it }.keys)
    }

    fun updateColumnCustomFilterAll() {
        val value = !state.tableState.columnFilter.custom.values.any { it }
        updateColumnFilter { copy(custom = custom.mapValues { value }.toImmutableMap()) }
        Preferences.saveColumnCustomFilter(state.tableState.columnFilter.custom.filterValues { it }.keys)
    }

    var showColumnRelationFilterDialog by mutableStateOf(false)

    fun addColumnRelationFilter() {
        updateColumnFilter { copy(relation = (relation + -1).toImmutableList()) }
        Preferences.saveColumnRelationFilter(state.tableState.columnFilter.relation)
    }

    fun deleteColumnRelationFilter(index: Int) {
        updateColumnFilter { copy(relation = relation.removedAt(index).toImmutableList()) }
        Preferences.saveColumnRelationFilter(state.tableState.columnFilter.relation)
    }

    fun setColumnRelationFilter(index: Int, value: Int) {
        updateColumnFilter { copy(relation = relation.replaceAt(index, value).toImmutableList()) }
        Preferences.saveColumnRelationFilter(state.tableState.columnFilter.relation)
    }

    var showColumnNameFilterDialog by mutableStateOf(false)

    fun addColumnNameFilter() {
        updateColumnFilter { copy(names = (names + "").toImmutableList()) }
        Preferences.saveColumnNameFilter(state.tableState.columnFilter.names)
    }

    fun deleteColumnNameFilter(index: Int) {
        updateColumnFilter { copy(names = names.removedAt(index).toImmutableList()) }
        Preferences.saveColumnNameFilter(state.tableState.columnFilter.names)
    }

    fun setColumnNameFilter(index: Int, value: String) {
        updateColumnFilter { copy(names = names.replaceAt(index, value).toImmutableList()) }
        Preferences.saveColumnNameFilter(state.tableState.columnFilter.names)
    }

    fun updateCalcState(action: CalcState.() -> CalcState) {
        updateState { copy(calcState = calcState.action()) }
    }

    fun updateCalcSetting(action: CalcSetting.() -> CalcSetting) {
        updateCalcState { copy(setting = setting.action()) }
        calcRate()
    }

    fun updateCalcBaseRate(level: Int, value: Number) {
        updateCalcSetting {
            copy(baseRate = baseRate.replaceAt(level, value.toDouble() / 100).toImmutableList())
        }
    }

    fun updateCalcInitialProper(type: Type, rank: Rank) {
        updateCalcSetting {
            copy(initialProperValue = initialProperValue.replaceAt(type.ordinal, rank).toImmutableList())
        }
    }

    fun updateCalcGoalProper(type: Type, rank: Rank) {
        updateCalcSetting {
            copy(goalProperValue = goalProperValue.replaceAt(type.ordinal, rank).toImmutableList())
        }
    }

    fun updateCalcProperType(target: Int, type: Type) {
        updateCalcSetting {
            copy(properType = properType.replaceAt(target, type).toImmutableList())
        }
    }

    fun updateCalcProperLevel(target: Int, level: Int) {
        updateCalcSetting {
            copy(properLevel = properLevel.replaceAt(target, level).toImmutableList())
        }
    }

    fun updateCalcBonusCount(target: Int, count: Number) {
        updateCalcSetting {
            copy(bonusCount = bonusCount.replaceAt(target, count.toInt()).toImmutableList())
        }
    }

    private fun calcRate() {
        val result = RateCalculator.calc(state.calcState.setting, state.charaSelection)
        updateCalcState { copy(result = result) }
    }

    var displayRelationInfo by mutableStateOf(emptyList<String>())

    fun showRelationInfo(index: Int) {
        displayRelationInfo =
            listOf(CharaList.nameList[index]) + RelationInfo.getLongString(CharaList.charaRelation[index])
    }

    fun updateFactorState(action: FactorState.() -> FactorState) {
        updateState { copy(factorState = factorState.action()) }
    }

    fun calcFactorState() {
        val factorState = state.factorState
        val realSuccessRate = factorState.realSuccessRate / 1000.0
        val circlingSuccessRate = factorState.circlingSuccessRate / 1000.0
        val circlingRealSuccessRate = factorState.circlingRealSuccessRate / 1000.0
        val challengeCount = factorState.challengeCount
        var maxRate = 0.0
        var maxIndex = 0
        val result = PersistentList(factorState.challengeCount) { circlingMax ->
            val rate = calc(realSuccessRate, circlingSuccessRate, circlingRealSuccessRate, challengeCount, circlingMax)
            if (rate > maxRate) {
                maxRate = rate
                maxIndex = circlingMax
            }
            rate
        }
        updateFactorState { copy(result = result, maxRateIndex = maxIndex) }
    }

    private fun calc(
        realSuccessRate: Double,
        circlingSuccessRate: Double,
        circlingRealSuccessRate: Double,
        challengeCount: Int,
        circlingMax: Int,
    ): Double {
        return (1..circlingMax).sumOf {
            (1 - circlingSuccessRate).pow(it - 1) *
                    circlingSuccessRate *
                    (1 - (1 - circlingRealSuccessRate).pow(challengeCount - it))
        } + (1 - circlingSuccessRate).pow(circlingMax) * (1 - (1 - realSuccessRate).pow(challengeCount - circlingMax))
    }

    private fun calcFactor(
        realSuccessRate: Double,
        circlingSuccessRate: Double,
        circlingRealSuccessRate: Double,
        circlingMax: Int,
    ): Int {
        var success = false
        for (i in 0 until Int.MAX_VALUE) {
            if (!success && i < circlingMax) {
                success = Random.nextDouble() < circlingSuccessRate
            } else {
                val rate = if (success) circlingRealSuccessRate else realSuccessRate
                if (Random.nextDouble() < rate) {
                    return i + 1
                }
            }
        }
        return Int.MAX_VALUE
    }
}