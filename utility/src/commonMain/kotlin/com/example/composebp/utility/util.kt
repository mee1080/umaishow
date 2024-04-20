@file:Suppress("unused")

package com.example.composebp.utility

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun <T> T.applyIf(
    condition: Boolean,
    block: T.() -> T,
): T {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    return if (condition) block() else this
}

@OptIn(ExperimentalContracts::class)
inline fun <T> T.applyIf(
    condition: (T) -> Boolean,
    block: T.() -> T,
): T {
    contract {
        callsInPlace(condition, InvocationKind.EXACTLY_ONCE)
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    return applyIf(condition(this), block)
}

@OptIn(ExperimentalContracts::class)
inline fun <T, U : Any> T.applyIfNotNull(
    obj: U?,
    block: T.(U) -> T,
): T {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    return applyIf(obj != null) { block(obj!!) }
}

fun Int.plusMinus(value: Int) = (this - value)..(this + value)

fun Long.plusMinus(value: Long) = (this - value)..(this + value)

fun CharRange.randomString(size: Int) = buildString(size) {
    repeat(size) {
        append(this@randomString.random())
    }
}

fun Collection<Char>.randomString(size: Int) = buildString(size) {
    repeat(size) {
        append(this@randomString.random())
    }
}
