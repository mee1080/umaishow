package io.github.mee1080.umaishow.vm

import kotlinx.browser.localStorage

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
        load(KEY_OWNED_CHARA)?.split(",") ?: listOf("サクラバクシンオー", "ハルウララ", "ダイワスカーレット", "ウオッカ", "ゴールドシップ")

    private fun save(key: String, value: String) = localStorage.setItem(key, value)

    private fun load(key: String) = localStorage.getItem(key)
}