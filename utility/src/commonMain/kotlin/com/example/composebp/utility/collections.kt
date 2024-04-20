package com.example.composebp.utility

inline fun <T> List<T>.mapIf(
    condition: (T) -> Boolean,
    mapper: (T) -> T,
) = map { if (condition(it)) mapper(it) else it }

inline fun <T> List<T>.mapIfIndexed(
    condition: (index: Int, T) -> Boolean,
    mapper: (index: Int, T) -> T,
) = mapIndexed { index, element -> if (condition(index, element)) mapper(index, element) else element }

fun <T> List<T>.replaced(
    index: Int,
    value: T,
) = toMutableList().apply { set(index, value) } as List<T>

fun <K, V> Map<K, V>.replaced(
    key: K,
    value: V,
) = toMutableMap().apply { put(key, value) } as Map<K, V>
