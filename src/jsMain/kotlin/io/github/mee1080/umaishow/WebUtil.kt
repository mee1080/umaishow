package io.github.mee1080.umaishow

import org.jetbrains.compose.web.events.WrappedEvent

fun <T> WrappedEvent.target() = nativeEvent.currentTarget!!.unsafeCast<T>()