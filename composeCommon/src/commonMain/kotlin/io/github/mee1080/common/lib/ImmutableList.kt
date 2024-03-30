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
package io.github.mee1080.common.lib

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Immutable
class ImmutableList<out T>(
    val data: List<T>,
) : List<T> by data {
    override fun toString() = data.toString()
}

fun <T> List<T>.toImmutable() = ImmutableList(this)

fun <T> Array<T>.toImmutable() = ImmutableList(this.asList())

fun <T> immutableListOf(vararg data: T) = data.toImmutable()

inline fun <reified T> buildPersistentList(builderAction: PersistentList.Builder<T>.() -> Unit): PersistentList<T> {
    return persistentListOf<T>().builder().apply(builderAction).build()
}
