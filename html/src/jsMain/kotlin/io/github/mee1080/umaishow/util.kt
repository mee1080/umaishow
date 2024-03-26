package io.github.mee1080.umaishow

fun <K, V> Map<K, V>.replace(key: K, value: V): Map<K, V> {
    return toMutableMap().apply { put(key, value) }
}

fun <T> List<T>.removedAt(index: Int): List<T> {
    return toMutableList().apply { removeAt(index) }
}

fun <T> List<T>.replaceAt(index: Int, value: T): List<T> {
    return toMutableList().apply { set(index, value) }
}