package io.github.mee1080.umaishow.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    var orderByRelation by mutableStateOf(true)

    val childList = listOf(-1 to "2世代相性") + charaList.mapIndexed { index, name -> index to name }

    var child by mutableStateOf(-1)
        private set

    val childSelected get() = child >= 0

    fun updateChild(value: Int) {
        child = value
        if (parent1 == value) parent1 = -1
        if (parent2 == value) parent2 = -1
        if (parent11 == value) parent11 = -1
        if (parent12 == value) parent12 = -1
        if (parent21 == value) parent21 = -1
        if (parent22 == value) parent22 = -1
    }

    val parent1List get() = generateParentList { listOf(Store.parent(child, it), calcTotalRelation(parent1 = it)) }

    var parent1: Int by mutableStateOf(-1)
        private set

    fun updateParent1(value: Int) {
        parent1 = value
    }

    val parent2List get() = generateParentList { listOf(Store.parent(child, it), calcTotalRelation(parent2 = it)) }

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

    private fun generateParentList(calcRelation: (Int) -> List<Int>): List<Pair<Int, String>> {
        if (!childSelected) return emptyList()
        var list = childList
            .filter { it.first != child }
            .map { (index, name) ->
                val relation = calcRelation(index)
                Triple(index, "$name (${relation.joinToString("->")})", relation.last())
            }
        if (orderByRelation) {
            list = list.sortedByDescending { it.third }
        }
        return listOf(-1 to "未選択") + list.map { it.first to it.second }
    }

    val relationTable
        get() = if (childSelected) charaList.mapIndexed { index, name ->
            Triple(name, Store.parent(child, index), Store.grandParentList(child, index))
        } else charaList.mapIndexed { index, name ->
            Triple(name, 0, Store.parentList(index))
        }

}