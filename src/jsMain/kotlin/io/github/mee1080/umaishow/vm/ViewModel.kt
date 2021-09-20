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
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateMap
import io.github.mee1080.umaishow.data.Store

class ViewModel(store: Store) {

    val charaList = store.charaList

    val totalRelation get() = calcTotalRelation()

    private fun calcTotalRelation(
        child: Int = this.child,
        parent1: Int = this.parent1,
        parent2: Int = this.parent2,
        parent11: Int = this.parent11,
        parent12: Int = this.parent12,
        parent21: Int = this.parent21,
        parent22: Int = this.parent22,
    ) = Store.parent(child, parent1) + Store.parent(child, parent2) + Store.parent(parent1, parent2) +
            Store.grandParent(child, parent1, parent11) + Store.grandParent(child, parent1, parent12) +
            Store.grandParent(child, parent2, parent21) + Store.grandParent(child, parent2, parent22)

    val combinationError
        get() = child == parent1 || child == parent2
                || (parent1 != -1 && (parent1 == parent2 || parent1 == parent11 || parent1 == parent12))
                || (parent2 != -1 && (parent2 == parent21 || parent2 == parent22))
                || (parent11 != -1 && parent11 == parent12)
                || (parent21 != -1 && parent21 == parent22)

    var orderByRelation by mutableStateOf(Preferences.loadParentSortOrder())
        private set

    fun updateOrderByRelation(value: Boolean) {
        orderByRelation = value
        Preferences.saveParentSortOrder(value)
    }

    val indexedCharaList = charaList.mapIndexed { index, name -> index to name }

    val childList = listOf(-1 to "2世代相性") + indexedCharaList

    var child by mutableStateOf(-1)
        private set

    val childSelected get() = child >= 0

    fun updateChild(value: Int) {
        child = value
        if (parent1 == value) parent1 = -1
        if (parent2 == value) parent2 = -1
    }

    val parent1List
        get() = generateParentList(false) {
            listOf(
                Store.parent(child, it),
                calcTotalRelation(parent1 = it)
            )
        }

    var parent1: Int by mutableStateOf(-1)
        private set

    fun updateParent1(value: Int) {
        parent1 = value
    }

    val parent2List
        get() = generateParentList(false) {
            listOf(
                Store.parent(child, it),
                calcTotalRelation(parent2 = it)
            )
        }

    var parent2: Int by mutableStateOf(-1)
        private set

    fun updateParent2(value: Int) {
        parent2 = value
    }

    val parent11List
        get() = generateParentList {
            listOf(
                Store.grandParent(child, parent1, it),
                calcTotalRelation(parent11 = it)
            )
        }

    var parent11: Int by mutableStateOf(-1)
        private set

    fun updateParent11(value: Int) {
        parent11 = value
    }

    val parent12List
        get() = generateParentList {
            listOf(
                Store.grandParent(child, parent1, it),
                calcTotalRelation(parent12 = it)
            )
        }

    var parent12: Int by mutableStateOf(-1)
        private set

    fun updateParent12(value: Int) {
        parent12 = value
    }

    val parent21List
        get() = generateParentList {
            listOf(
                Store.grandParent(child, parent2, it),
                calcTotalRelation(parent21 = it)
            )
        }

    var parent21: Int by mutableStateOf(-1)
        private set

    fun updateParent21(value: Int) {
        parent21 = value
    }

    val parent22List
        get() = generateParentList {
            listOf(
                Store.grandParent(child, parent2, it),
                calcTotalRelation(parent22 = it)
            )
        }

    var parent22: Int by mutableStateOf(-1)
        private set

    fun updateParent22(value: Int) {
        parent22 = value
    }

    private fun generateParentList(
        includeChild: Boolean = true,
        calcRelation: (Int) -> List<Int>
    ): List<Pair<Int, String>> {
        if (!childSelected) return emptyList()
        var list = indexedCharaList
            .filter { includeChild || it.first != child }
            .map { (index, name) ->
                val relation = calcRelation(index)
                Triple(index, "$name (${relation.joinToString("->")})", relation.last())
            }
        if (orderByRelation) {
            list = list.sortedByDescending { it.third }
        }
        return listOf(-1 to "未選択") + list.map { it.first to it.second }
    }

    var autoSetParentsTarget by mutableStateOf(Preferences.loadAutoSetParentsTarget())
        private set

    fun updateAutoSetParentsTarget(value: Int) {
        autoSetParentsTarget = value
        Preferences.saveAutoSetParentsTarget(value)
    }

    val ownedChara: SnapshotStateMap<String, Boolean>

    init {
        val saved = Preferences.loadOwnedChara()
        ownedChara = mutableStateMapOf(*(charaList.map { it to saved.contains(it) }).toTypedArray())
    }

    fun updateOwnedChara(name: String, value: Boolean) {
        ownedChara[name] = value
        Preferences.saveOwnedChara(ownedChara.filterValues { it }.keys)
    }

    fun autoSetParents() {
        if (!childSelected) return
        val targetList = indexedCharaList
            .filter { it.first != child && (autoSetParentsTarget == 0 || ownedChara[it.second] ?: false) }
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
        val checkedParent1 = BooleanArray(charaList.size) { false }
        p1List.forEach { p1Pair ->
            val p1 = p1Pair.first
            val p1Relation = p1Pair.second
            checkedParent1[p1] = true
            p2List.filterNot { checkedParent1[it.first] }.forEach { p2Pair ->
                val p2 = p2Pair.first
                val p2Relation = p2Pair.second
                val parentsRelation = Store.parent(p1, p2)
                if (p1Relation * 3 + p2Relation * 3 + parentsRelation > maxRelation) {
                    val checkedParent11 = BooleanArray(charaList.size) { it == p1 }
                    p11List.filter { it != p1 }.forEach { p11 ->
                        checkedParent11[p11] = true
                        val p11Relation = Store.grandParent(child, p1, p11)
                        p12List.filterNot { checkedParent11[it] }.forEach { p12 ->
                            val p12Relation = Store.grandParent(child, p1, p12)
                            if (p1Relation + p11Relation + p12Relation + p2Relation * 3 + parentsRelation > maxRelation) {
                                val checkedParent21 = BooleanArray(charaList.size) { it == p2 }
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
        parent1 = maxCombination[0]
        parent2 = maxCombination[1]
        parent11 = maxCombination[2]
        parent12 = maxCombination[3]
        parent21 = maxCombination[4]
        parent22 = maxCombination[5]
    }

    fun clearParents() {
        parent1 = -1
        parent2 = -1
        parent11 = -1
        parent12 = -1
        parent21 = -1
        parent22 = -1
    }

    val relationTable: List<Triple<String, Int, List<Int>>>
        get() {
            var list = if (childSelected) charaList.mapIndexed { index, name ->
                Triple(name, Store.parent(child, index), Store.grandParentList(child, index))
            } else charaList.mapIndexed { index, name ->
                Triple(name, 0, Store.parentList(index))
            }
            list = list.map {
                Triple(it.first, it.second, it.third + it.third.sum())
            }
            return when (sortKey) {
                -2 -> list
                -1 -> list.sortedByDescending { it.second }
                else -> list.sortedByDescending { it.third[sortKey] }
            }
        }

    var sortKey by mutableStateOf(-2)
        private set

    fun sort(key: Int) {
        sortKey = key
    }
}