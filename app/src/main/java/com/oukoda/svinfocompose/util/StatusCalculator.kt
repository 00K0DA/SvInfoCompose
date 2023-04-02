package com.oukoda.svinfocompose.util

import com.oukoda.svinfocompose.model.dataclass.Pokemon
import kotlin.math.floor

class StatusCalculator {
    companion object {
        fun calculateHp(
            baseStats: Int,
            individualValue: Int,
            effortValue: Int,
            level: Int = 50,
        ): Int {
            return floor(
                (
                    (baseStats * 2 + individualValue + floor(effortValue / 4.0).toInt()) *
                        level
                    ) / 100.0,
            )
                .toInt() + level + 10
        }

        fun calculateStatus(
            baseStats: Int,
            individualValue: Int,
            effortValue: Int,
            natureCorrect: Int,
            level: Int,
        ): Int {
            val statusValue: Int = floor(
                ((baseStats * 2 + individualValue + floor(effortValue / 4.0).toInt()) * level) / 100.0,
            ).toInt() + 5
            return when (natureCorrect) {
                Pokemon.NATURE_CORRECT_POSITIVE -> floor(statusValue * 1.1).toInt()
                Pokemon.NATURE_CORRECT_NEGATIVE -> floor(statusValue * 0.9).toInt()
                else -> statusValue
            }
        }
    }
}
