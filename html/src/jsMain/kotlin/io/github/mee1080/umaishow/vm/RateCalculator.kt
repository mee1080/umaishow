package io.github.mee1080.umaishow.vm

import io.github.mee1080.umaishow.data.Store
import kotlin.math.min

object RateCalculator {

    private fun doCalcRate(baseRate: Double, relation: Int) = baseRate * (100 + relation) / 100.0

    fun calc(setting: CalcSetting, selection: CharaSelection): CalcResult {
        val (child, parent1, parent2) = listOf(
            selection.child, selection.parent1, selection.parent2
        )
        val (parent11, parent12, parent21, parent22) = listOf(
            selection.parent11, selection.parent12, selection.parent21, selection.parent22
        )
        if (child == -1 || parent1 == -1 || parent2 == -1 || parent11 == -1 || parent12 == -1 || parent21 == -1 || parent22 == -1) {
            return CalcResult()
        }
        val parentRelation = Store.parent(parent1, parent2) / 2 + setting.bonusCount[0] * 3 / 2 + setting.parentBonus
        val rate1 = doCalcRate(
            setting.baseRate[setting.properLevel[0]],
            Store.parent(child, parent1) + parentRelation
        )
        val rate2 = doCalcRate(
            setting.baseRate[setting.properLevel[1]],
            Store.parent(child, parent2) + parentRelation
        )
        val rate11 = doCalcRate(
            setting.baseRate[setting.properLevel[2]],
            Store.grandParent(child, parent1, parent11) + setting.bonusCount[2] * 3
        )
        val rate12 = doCalcRate(
            setting.baseRate[setting.properLevel[3]],
            Store.grandParent(child, parent1, parent12) + setting.bonusCount[3] * 3
        )
        val rate21 = doCalcRate(
            setting.baseRate[setting.properLevel[4]],
            Store.grandParent(child, parent2, parent21) + setting.bonusCount[4] * 3
        )
        val rate22 = doCalcRate(
            setting.baseRate[setting.properLevel[5]],
            Store.grandParent(child, parent2, parent22) + setting.bonusCount[5] * 3
        )
        val upRates = arrayOf(
            rate1, rate1, rate2, rate2,
            rate11, rate11, rate12, rate12,
            rate21, rate21, rate22, rate22,
        )
        val upTargets = Array(12) { setting.properType[it / 2].ordinal }
        val initialUpLevels = Array(3) { 0 }
        setting.properType.forEachIndexed { index, type ->
            initialUpLevels[type.ordinal] += setting.properLevel[index]
        }
        val initialProperValues = setting.initialProperValue.mapIndexed { index, rank ->
            min(Rank.A.ordinal, rank.ordinal + min(4, (initialUpLevels[index] + 2) / 3))
        }
        val results = (0 until 4096).map { value -> Array(12) { value and (1 shl it) != 0 } }.map { upList ->
            upList.foldIndexed(initialProperValues to 1.0) { index, (values, rate), up ->
                if (up) {
                    values.mapIndexed { valueIndex, value ->
                        if (valueIndex == upTargets[index]) {
                            min(value + 1, 7)
                        } else value
                    } to rate * upRates[index]
                } else {
                    values to rate * (1 - upRates[index])
                }
            }
        }
        val totalRates = Array(3) { Array(8) { 0.0 } }
        var goalRate: Double = 0.0
        val goals = setting.goalProperValue.map { it.ordinal }
        results.forEach { (properValues, rate) ->
            totalRates[0][properValues[0]] += rate
            totalRates[1][properValues[1]] += rate
            totalRates[2][properValues[2]] += rate
            if (properValues[0] >= goals[0] && properValues[1] >= goals[1] && properValues[2] >= goals[2]) {
                goalRate += rate
            }
        }
        return CalcResult(
            rate1, rate2, rate11, rate12, rate21, rate22, initialProperValues.map { Rank.values()[it] },
            totalRates[0].toList(), totalRates[1].toList(), totalRates[2].toList(), goalRate,
        )
    }
}