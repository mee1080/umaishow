package io.github.mee1080.umaishow.data

object Store {
    val charaList = Source.chara

    val charaRange = charaList.indices

    val parentMap = Source.parent

    private val grandParentMap = Source.grandParent

    fun parentList(index: Int) = parentMap[index]

    fun parent(index1: Int, index2: Int) =
        if (index1 in charaRange && index2 in charaRange) {
            parentMap[index1][index2]
        } else 0

    fun grandParentListList(index1: Int): List<List<Int>> {
        return grandParentMap[index1]
    }

    fun grandParentList(index1: Int, index2: Int): List<Int> {
        return grandParentMap[index1][index2]
    }

    fun grandParent(index1: Int, index2: Int, index3: Int) =
        if (index1 in charaRange && index2 in charaRange && index3 in charaRange) {
            grandParentMap[index1][index2][index3]
        } else 0
}