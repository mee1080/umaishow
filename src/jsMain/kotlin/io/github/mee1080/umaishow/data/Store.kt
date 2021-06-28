package io.github.mee1080.umaishow.data

object Store {
    val charaList = Source.chara

    val charaCount = charaList.size

    fun chara(index: Int) = charaList[index]

    fun parentList(index: Int) = Source.parent.slice(index * charaCount until (index + 1) * charaCount)

    fun parent(index1: Int, index2: Int) =
        if (charaList.indices.contains(index1)
            && charaList.indices.contains(index2)
        ) {
            Source.parent[index1 * charaCount + index2]
        } else 0

    fun grandParentList(index1: Int, index2: Int) = Source.grandParent.slice(
        index1 * charaCount * charaCount + index2 * charaCount until index1 * charaCount * charaCount + (index2 + 1) * charaCount
    )

    fun grandParentListList(index: Int) = (0 until charaCount).map { grandParentList(index, it) }

    fun grandParent(index1: Int, index2: Int, index3: Int) =
        if (charaList.indices.contains(index1)
            && charaList.indices.contains(index2)
            && charaList.indices.contains(index3)
        ) {
            Source.grandParent[index1 * charaCount * charaCount + index2 * charaCount + index3]
        } else 0
}