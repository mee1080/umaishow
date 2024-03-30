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

import io.github.mee1080.umaishow.PersistentList
import io.github.mee1080.umaishow.data.RelationInfo
import io.github.mee1080.umaishow.data.Store
import kotlinx.collections.immutable.*

enum class Page(val displayName: String, val icon: String) {
    Table("相性表", "table_view"),
    Calc("魔改造計算", "calculate"),
    Factor("因子周回", "autorenew"),
}

data class State(
    val page: Page = Page.Table,
    val charaSelection: CharaSelection = CharaSelection(),
    val autoSetParentsTarget: Int = Preferences.loadAutoSetParentsTarget(),
    val tableState: TableState = TableState(),
    val calcState: CalcState = CalcState(),
    val factorState: FactorState = FactorState(),
) {
    val charaList = CharaList

    val charaNameList get() = charaList.nameList
}

data class TableState(
    val ownedChara: ImmutableMap<String, Boolean> = loadCharaNameMap(Preferences.loadOwnedChara()),
    val rawRelationTable: ImmutableList<RelationTableEntry> = persistentListOf(),
    val sortKey: Int = -2,
    val relationTable: ImmutableList<RelationTableEntry> = persistentListOf(),
    val displayChild: Boolean = false,
    val rowFilter: FilterSetting = FilterSetting(
        custom = loadCharaNameMap(Preferences.loadRowCustomFilter()),
        relation = Preferences.loadRowRelationFilter().toImmutableList(),
        names = Preferences.loadRowNameFilter().toImmutableList(),
    ),
    val rowHideIndices: ImmutableList<Int> = persistentListOf(),
    val columnFilter: FilterSetting = FilterSetting(
        custom = loadCharaNameMap(Preferences.loadColumnCustomFilter(), CharaList.columnList),
        relation = Preferences.loadColumnRelationFilter().toImmutableList(),
        names = Preferences.loadRowNameFilter().toImmutableList(),
    ),
    val columnHideIndices: ImmutableList<Int> = persistentListOf(),
    val headerCharaNames: ImmutableList<Pair<Int, String>> = CharaList.indexedCharaList,
)

private fun loadCharaNameMap(
    saved: List<String>,
    target: List<String> = CharaList.nameList,
): ImmutableMap<String, Boolean> {
    return persistentMapOf(*(target.map { it to saved.contains(it) }).toTypedArray())
}

object CharaList {
    val charaList = Store.charaList
    val charaCount = charaList.size
    val nameList = Store.charaNameList
    val charaRelation = Store.charaRelation
    val indexedCharaList = nameList.mapIndexed { index, name -> index to name }.toImmutableList()
    val childList = (listOf(-1 to "2世代相性") + indexedCharaList).toImmutableList()
    val relationFilter = (listOf(-1 to "未設定") + RelationInfo.filters).toImmutableList()
    val columnList = (nameList + listOf("合計", "要素", "所持")).toImmutableList()
    val ownedIndex = columnList.lastIndex
    val relationIndex = columnList.lastIndex - 1
    val totalIndex = columnList.lastIndex - 2
}

data class CharaSelection(
    val child: Int = -1,
    val parent1: Int = -1,
    val parent2: Int = -1,
    val parent11: Int = -1,
    val parent12: Int = -1,
    val parent21: Int = -1,
    val parent22: Int = -1,
    val orderByRelation: Boolean = Preferences.loadParentSortOrder(),
) {
    val totalRelation = calcTotalRelation()

    val combinationError = child == parent1 || child == parent2
            || (parent1 != -1 && (parent1 == parent2 || parent1 == parent11 || parent1 == parent12))
            || (parent2 != -1 && (parent2 == parent21 || parent2 == parent22))
            || (parent11 != -1 && parent11 == parent12)
            || (parent21 != -1 && parent21 == parent22)

    val childSelected = child >= 0

    val childEntry get() = child to getCharaName(child) { CharaList.childList[0].second }

    val parent1Name = "親1 : " + getCharaName(parent1)
    val parent2Name = "親2 : " + getCharaName(parent2)
    val parent11Name = "祖1-1 : " + getCharaName(parent11)
    val parent12Name = "祖1-2 : " + getCharaName(parent12)
    val parent21Name = "祖2-1 : " + getCharaName(parent21)
    val parent22Name = "祖2-2 : " + getCharaName(parent22)

    val parent1List = generateParentList { Store.parent(child, it) to calcTotalRelation(parent1 = it) }
    val parent2List = generateParentList { Store.parent(child, it) to calcTotalRelation(parent2 = it) }
    val parent11List = generateParentList { Store.grandParent(child, parent1, it) to calcTotalRelation(parent11 = it) }
    val parent12List = generateParentList { Store.grandParent(child, parent1, it) to calcTotalRelation(parent12 = it) }
    val parent21List = generateParentList { Store.grandParent(child, parent2, it) to calcTotalRelation(parent21 = it) }
    val parent22List = generateParentList { Store.grandParent(child, parent2, it) to calcTotalRelation(parent22 = it) }

    private fun calcTotalRelation(
        child: Int = this.child,
        parent1: Int = this.parent1,
        parent2: Int = this.parent2,
        parent11: Int = this.parent11,
        parent12: Int = this.parent12,
        parent21: Int = this.parent21,
        parent22: Int = this.parent22,
    ): Int {
        return Store.parent(child, parent1) + Store.parent(child, parent2) + Store.parent(parent1, parent2) +
                Store.grandParent(child, parent1, parent11) + Store.grandParent(child, parent1, parent12) +
                Store.grandParent(child, parent2, parent21) + Store.grandParent(child, parent2, parent22)
    }

    private fun generateParentList(
        calcRelation: (Int) -> Pair<Int, Int>
    ): List<Pair<Int, String>> {
        if (!childSelected) return emptyList()
        var list = CharaList.indexedCharaList
            .map { (index, name) ->
                val relation = calcRelation(index)
                Triple(index, "$name (${relation.first} -> ${relation.second})", relation.second)
            }
        if (orderByRelation) {
            list = list.sortedByDescending { it.third }
        }
        return listOf(-1 to "未選択") + list.map { it.first to it.second }
    }

    private fun getCharaName(index: Int, defaultValue: () -> String = { "未選択" }) =
        CharaList.nameList.getOrElse(index) { defaultValue() }
}

data class RelationTableEntry(
    val index: Int,
    val name: String,
    val parentRelation: Int,
    val relationList: ImmutableList<Int>,
    val info: String,
) {
    val relationTotal = relationList.sum()
}

enum class FilterMode {
    NONE, OWNED, NOT_OWNED, CUSTOM, RELATION, NAME,
}

data class FilterSetting(
    val mode: FilterMode = FilterMode.NONE,
    val custom: ImmutableMap<String, Boolean> = persistentMapOf(),
    val relation: ImmutableList<Int> = persistentListOf(-1),
    val names: ImmutableList<String> = persistentListOf(""),
) {
    private val checker: (index: Int, name: String, ownedChara: Map<String, Boolean>) -> Boolean = when (mode) {
        FilterMode.NONE -> { _, _, _ -> true }
        FilterMode.OWNED -> { _, name, ownedChara -> ownedChara[name] ?: false }
        FilterMode.NOT_OWNED -> { _, name, ownedChara -> !(ownedChara[name] ?: false) }
        FilterMode.CUSTOM -> { _, name, _ -> custom[name] ?: false }
        FilterMode.RELATION -> { index, _, _ ->
            CharaList.charaRelation.getOrNull(index)?.let { charaRelation ->
                relation.all { it < 0 || charaRelation.contains(it) }
            } ?: true
        }

        FilterMode.NAME -> { _, name, _ -> names.any { name.contains(it) } }
    }

    fun check(index: Int, name: String, ownedChara: Map<String, Boolean>) = checker(index, name, ownedChara)
}

data class CalcState(
    val setting: CalcSetting = CalcSetting(),
    val result: CalcResult = CalcResult(),
)

enum class Type(private val display: String) {
    Ground("バ場"), Distance("距離"), RunningStyle("脚質");

    override fun toString() = display
}

enum class Rank {
    G, F, E, D, C, B, A, S,
}

data class CalcSetting(
    val baseRate: ImmutableList<Double> = persistentListOf(0.0, 0.02, 0.04, 0.06),
    val parentBonus: Int = 20,

    val initialProperValue: ImmutableList<Rank> = persistentListOf(Rank.G, Rank.A, Rank.A),
    val goalProperValue: ImmutableList<Rank> = persistentListOf(Rank.A, Rank.S, Rank.A),
    val properType: ImmutableList<Type> = PersistentList(6) { if (it == 1) Type.Distance else Type.Ground },
    val properLevel: ImmutableList<Int> = PersistentList(6) { 3 },
    val bonusCount: ImmutableList<Int> = PersistentList(6) { 0 },
)

class CalcResult(
    val rate1: Double = 0.0,
    val rate2: Double = 0.0,
    val rate11: Double = 0.0,
    val rate12: Double = 0.0,
    val rate21: Double = 0.0,
    val rate22: Double = 0.0,

    val initialProperValue: ImmutableList<Rank> = PersistentList(3) { Rank.G },
    val groundRate: ImmutableList<Double> = PersistentList(8) { 0.0 },
    val distanceRate: ImmutableList<Double> = PersistentList(8) { 0.0 },
    val runningTypeRate: ImmutableList<Double> = PersistentList(8) { 0.0 },

    val goalRate: Double = 0.0,
)

data class FactorState(
    val realSuccessRate: Int = 50,
    val circlingSuccessRate: Int = 200,
    val circlingRealSuccessRate: Int = 80,
    val challengeCount: Int = 20,
    val result: ImmutableList<Double> = persistentListOf(),
    val maxRateIndex: Int = 0,
)