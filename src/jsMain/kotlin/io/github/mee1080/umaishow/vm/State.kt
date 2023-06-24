package io.github.mee1080.umaishow.vm

import io.github.mee1080.umaishow.data.RelationInfo
import io.github.mee1080.umaishow.data.Store

enum class Page(val displayName: String, val icon: String) {
    Table("相性表", "table_view"),
    Calc("発動率計算", "calculate"),
}

data class State(
    val page: Page = Page.Table,
    val charaSelection: CharaSelection = CharaSelection(),
    val autoSetParentsTarget: Int = Preferences.loadAutoSetParentsTarget(),
    val tableState: TableState = TableState(),
    val calcState: CalcState = CalcState(),
) {
    val charaList = CharaList

    val charaNameList get() = charaList.nameList
}

data class TableState(
    val ownedChara: Map<String, Boolean> = loadCharaNameMap(Preferences.loadOwnedChara()),
    val rawRelationTable: List<RelationTableEntry> = emptyList(),
    val sortKey: Int = -2,
    val relationTable: List<RelationTableEntry> = emptyList(),
    val displayChild: Boolean = false,
    val rowFilter: FilterSetting = FilterSetting(
        custom = loadCharaNameMap(Preferences.loadRowCustomFilter()),
        relation = Preferences.loadRowRelationFilter(),
    ),
    val rowHideIndices: List<Int> = emptyList(),
    val columnFilter: FilterSetting = FilterSetting(
        custom = loadCharaNameMap(Preferences.loadColumnCustomFilter(), CharaList.columnList),
        relation = Preferences.loadColumnRelationFilter(),
    ),
    val columnHideIndices: List<Int> = emptyList(),
)

private fun loadCharaNameMap(saved: List<String>, target: List<String> = CharaList.nameList): Map<String, Boolean> {
    return mapOf(*(target.map { it to saved.contains(it) }).toTypedArray())
}

object CharaList {
    val charaList = Store.charaList
    val charaCount = charaList.size
    val nameList = charaList.map { it.first }
    val charaRelation = Store.charaList.map { it.second }
    val indexedCharaList = nameList.mapIndexed { index, name -> index to name }
    val childList = listOf(-1 to "2世代相性") + indexedCharaList
    val relationFilter = listOf(-1 to "未設定") + RelationInfo.filters
    val columnList = nameList + listOf("合計", "要素", "所持")
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
}

class RelationTableEntry(
    val index: Int,
    val name: String,
    val parentRelation: Int,
    val relationList: List<Int>,
    val info: String,
) {
    val relationTotal = relationList.sum()
}

enum class FilterMode {
    NONE, OWNED, NOT_OWNED, CUSTOM, RELATION,
}

data class FilterSetting(
    val mode: FilterMode = FilterMode.NONE,
    val custom: Map<String, Boolean> = emptyMap(),
    val relation: List<Int> = emptyList(),
) {
    fun check(index: Int, name: String, ownedChara: Map<String, Boolean>) = when (mode) {
        FilterMode.NONE -> true
        FilterMode.OWNED -> ownedChara[name] ?: false
        FilterMode.NOT_OWNED -> !(ownedChara[name] ?: false)
        FilterMode.CUSTOM -> custom[name] ?: false
        FilterMode.RELATION -> {
            CharaList.charaRelation.getOrNull(index)?.let { charaRelation ->
                relation.all { it < 0 || charaRelation.contains(it) }
            } ?: true
        }
    }
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
    val baseRate: List<Double> = listOf(0.0, 0.02, 0.04, 0.06),
    val parentBonus: Int = 20,

    val initialProperValue: List<Rank> = listOf(Rank.C, Rank.A, Rank.A),
    val goalProperValue: List<Rank> = listOf(Rank.A, Rank.S, Rank.A),
    val properType: List<Type> = List(6) { if (it == 1) Type.Distance else Type.Ground },
    val properLevel: List<Int> = List(6) { 3 },
)

class CalcResult(
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
