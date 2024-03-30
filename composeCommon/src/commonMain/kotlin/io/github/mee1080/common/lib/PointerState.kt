package io.github.mee1080.common.lib

import androidx.compose.runtime.Stable
import androidx.compose.ui.input.pointer.PointerEvent
import kotlin.math.abs

@Stable
class PointerState {
    var x: Int = 0
    var y: Int = 0

    fun updateAndDiff(event: PointerEvent): Pair<Int, Int> {
        val change = event.changes.getOrNull(0) ?: return 0 to 0
        val newX = change.position.x.toInt()
        val newY = change.position.y.toInt()
        val diff = calcDiff(newX, x) to calcDiff(newY, y)
        x += diff.first
        y += diff.second
        return diff
    }

    private fun calcDiff(newValue: Int, oldValue: Int): Int {
        val diff = newValue - oldValue
        return if (abs(diff) >= 10) diff else 0
    }
}
