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

    val charaNameList = charaList.map { it.first }

    val charaRelation = charaList.map { it.second }

    private val charaRange = charaList.indices

    private val parentRelation = List(charaList.size) { child ->
        val childSet = charaList[child].second
        List(charaList.size) { parent ->
            if (child == parent) emptySet() else childSet.intersect(charaList[parent].second)
        }
    }

    private val parentMap = parentRelation.map { sets ->
        sets.map { set ->
            set.sumOf { Source.relation[it]!! }
        }
    }

    private val grandParentMap = parentRelation.mapIndexed { child, sets ->
        sets.mapIndexed { parent, set ->
            List(charaList.size) { grand ->
                if (child == grand || parent == grand) 0 else set.intersect(charaList[grand].second)
                    .sumOf { Source.relation[it]!! }
            }
        }
    }

    fun parentList(index: Int) = parentMap[index]

    fun parent(index1: Int, index2: Int) =
        if (index1 in charaRange && index2 in charaRange) {
            parentMap[index1][index2]
        } else 0

    fun grandParentList(index1: Int, index2: Int): List<Int> {
        return grandParentMap[index1][index2]
    }

    fun grandParent(index1: Int, index2: Int, index3: Int) =
        if (index1 in charaRange && index2 in charaRange && index3 in charaRange) {
            grandParentMap[index1][index2][index3]
        } else 0
}