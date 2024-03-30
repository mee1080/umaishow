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
package io.github.mee1080.umaishow.data

import io.github.mee1080.umaishow.PersistentList
import io.github.mee1080.umaishow.mapImmutable
import io.github.mee1080.umaishow.mapIndexedImmutable
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.collections.immutable.toImmutableSet

object Store {
    val charaList = Source.chara.mapImmutable { it.first to it.second.toImmutableSet() }

    val charaNameList = charaList.mapImmutable { it.first }

    val charaRelation = charaList.mapImmutable { it.second }

    private val charaRange = charaList.indices

    private val parentRelation = PersistentList(charaList.size) { child ->
        val childSet = charaList[child].second
        PersistentList(charaList.size) { parent ->
            if (child == parent) persistentSetOf() else childSet.intersect(charaList[parent].second).toImmutableSet()
        }
    }

    private val parentMap = parentRelation.mapImmutable { sets ->
        sets.mapImmutable { set ->
            set.sumOf { Source.relation[it]!! }
        }
    }

    private val grandParentMap = parentRelation.mapIndexedImmutable { child, sets ->
        sets.mapIndexedImmutable { parent, set ->
            PersistentList(charaList.size) { grand ->
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

    fun grandParentList(index1: Int, index2: Int) = grandParentMap[index1][index2]

    fun grandParent(index1: Int, index2: Int, index3: Int) =
        if (index1 in charaRange && index2 in charaRange && index3 in charaRange) {
            grandParentMap[index1][index2][index3]
        } else 0
}