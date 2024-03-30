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

internal expect fun save(key: String, value: String)
internal expect fun load(key: String): String?

object Preferences {

    private const val KEY_PARENT_SORT_ORDER = "ParentSortOrder"

    fun saveParentSortOrder(value: Boolean) = save(KEY_PARENT_SORT_ORDER, (if (value) 1 else 0).toString())

    fun loadParentSortOrder() = load(KEY_PARENT_SORT_ORDER)?.toIntOrNull() != 0

    private const val KEY_AUTO_SET_PARENTS_TARGET = "AutoSetParentsTarget"

    fun saveAutoSetParentsTarget(value: Int) = save(KEY_AUTO_SET_PARENTS_TARGET, value.toString())

    fun loadAutoSetParentsTarget() = load(KEY_AUTO_SET_PARENTS_TARGET)?.toIntOrNull() ?: 0

    private const val KEY_OWNED_CHARA = "OwnedChara"

    fun saveOwnedChara(value: Collection<String>) = save(KEY_OWNED_CHARA, value.joinToString(","))

    fun loadOwnedChara() =
        load(KEY_OWNED_CHARA)?.split(",") ?: listOf(
            "サクラバクシンオー",
            "ハルウララ",
            "ダイワスカーレット",
            "ウオッカ",
            "ゴールドシップ"
        )

    private const val KEY_ROW_CUSTOM_FILTER = "RowCustomFilter"

    fun saveRowCustomFilter(value: Collection<String>) = save(KEY_ROW_CUSTOM_FILTER, value.joinToString(","))

    fun loadRowCustomFilter() =
        load(KEY_ROW_CUSTOM_FILTER)?.split(",") ?: listOf()

    private const val KEY_COLUMN_CUSTOM_FILTER = "ColumnCustomFilter"

    fun saveColumnCustomFilter(value: Collection<String>) = save(KEY_COLUMN_CUSTOM_FILTER, value.joinToString(","))

    fun loadColumnCustomFilter() =
        load(KEY_COLUMN_CUSTOM_FILTER)?.split(",") ?: listOf()

    private const val KEY_ROW_RELATION_FILTER = "RowRelationFilter"

    fun loadRowRelationFilter() =
        load(KEY_ROW_RELATION_FILTER)?.split(",")?.mapNotNull { it.toIntOrNull() } ?: listOf(-1)

    fun saveRowRelationFilter(value: Collection<Int>) = save(KEY_ROW_RELATION_FILTER, value.joinToString(","))

    private const val KEY_COLUMN_RELATION_FILTER = "ColumnRelationFilter"

    fun loadColumnRelationFilter() =
        load(KEY_COLUMN_RELATION_FILTER)?.split(",")?.mapNotNull { it.toIntOrNull() } ?: listOf(-1)

    fun saveColumnRelationFilter(value: Collection<Int>) = save(KEY_COLUMN_RELATION_FILTER, value.joinToString(","))
}
