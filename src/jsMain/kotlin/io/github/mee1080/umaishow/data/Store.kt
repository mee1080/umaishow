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