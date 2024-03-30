package io.github.mee1080.umaishow

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

fun <K, V> Map<K, V>.replace(key: K, value: V): Map<K, V> {
    return toMutableMap().apply { put(key, value) }
}

fun <T> List<T>.removedAt(index: Int): List<T> {
    return toMutableList().apply { removeAt(index) }
}

fun <T> List<T>.replaceAt(index: Int, value: T): List<T> {
    return toMutableList().apply { set(index, value) }
}

inline fun <reified T> buildPersistentList(builderAction: PersistentList.Builder<T>.() -> Unit): PersistentList<T> {
    return persistentListOf<T>().builder().apply(builderAction).build()
}

inline fun <reified T> PersistentList(size: Int, init: (index: Int) -> T): PersistentList<T> {
    return buildPersistentList {
        repeat(size) {
            add(init(it))
        }
    }
}

inline fun <T, reified R> Iterable<T>.mapImmutable(transform: (T) -> R): ImmutableList<R> {
    return buildPersistentList {
        for (item in this@mapImmutable) {
            add(transform(item))
        }
    }
}

inline fun <T, reified R> Iterable<T>.mapIndexedImmutable(transform: (index: Int, T) -> R): ImmutableList<R> {
    return buildPersistentList {
        for ((index, item) in this@mapIndexedImmutable.withIndex()) {
            add(transform(index, item))
        }
    }
}

inline fun <reified T> ImmutableList<T>.addImmutable(element: T): ImmutableList<T> {
    return buildPersistentList<T> {
        addAll(this@addImmutable)
        add(element)
    }
}

inline fun <reified T> Array<T>.toImmutableList(): ImmutableList<T> {
    return buildPersistentList { addAll(this@toImmutableList) }
}
