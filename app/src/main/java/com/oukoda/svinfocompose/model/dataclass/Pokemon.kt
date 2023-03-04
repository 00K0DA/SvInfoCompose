package com.oukoda.svinfocompose.model.dataclass

import android.annotation.SuppressLint
import android.content.Context
import com.oukoda.svinfocompose.model.enumclass.Type
import org.json.JSONArray
import org.json.JSONObject
import kotlin.math.floor

data class Pokemon(
    val pokemonId: String,
    val name: String,
    val type1: Type,
    val type2: Type?,
    val ability1: Int,
    val ability2: Int,
    val hiddenAbility: Int,
    val hp: Int,
    val attack: Int,
    val defence: Int,
    val spAttack: Int,
    val spDefence: Int,
    val speed: Int,
    val levelMoves: List<Int>,
    val machineMoves: List<Int>,
    val eggMoves: List<Int>,
) {
    companion object {
        private const val JSON_KEY_POKEMON_ID = "pokemon_id"
        private const val JSON_KEY_NAME = "name"
        private const val JSON_KEY_TYPE_1 = "type_1"
        private const val JSON_KEY_TYPE_2 = "type_2"
        private const val JSON_KEY_ABILITY_1 = "ability_1"
        private const val JSON_KEY_ABILITY_2 = "ability_2"
        private const val JSON_KEY_HIDDEN_ABILITY = "hidden_ability"
        private const val JSON_KEY_HP = "h"
        private const val JSON_KEY_ATTACK = "a"
        private const val JSON_KEY_DEFENCE = "b"
        private const val JSON_KEY_SP_ATTACK = "c"
        private const val JSON_KEY_SP_DEFENCE = "d"
        private const val JSON_KEY_SPEED = "s"
        private const val JSON_KEY_LEVEL_MOVES = "levelMoves"
        private const val JSON_KEY_MACHINE_MOVE = "machineMoves"
        private const val JSON_KEY_EGG_MOVES = "eggMoves"

        const val NATURE_CORRECT_POSITIVE = 1
        const val NATURE_CORRECT_NONE = 0
        const val NATURE_CORRECT_NEGATIVE = -1

        private fun jsonArrayToIntList(jsonArray: JSONArray): List<Int> {
            return (0 until jsonArray.length()).map {
                jsonArray.getInt(it)
            }
        }

        fun fromJson(jsonObject: JSONObject): Pokemon {
            val type2 = if (!jsonObject.isNull(JSON_KEY_TYPE_2)) {
                Type.fromValue(jsonObject.getInt(JSON_KEY_TYPE_2))
            } else {
                null
            }

            val ability2 = if (!jsonObject.isNull(JSON_KEY_ABILITY_2)) {
                jsonObject.getInt(JSON_KEY_ABILITY_2)
            } else {
                jsonObject.getInt(JSON_KEY_ABILITY_1)
            }

            val hiddenAbility =
                if (!jsonObject.isNull(JSON_KEY_HIDDEN_ABILITY)) {
                    jsonObject.getInt(JSON_KEY_HIDDEN_ABILITY)
                } else {
                    jsonObject.getInt(JSON_KEY_ABILITY_1)
                }

            return Pokemon(
                pokemonId = jsonObject.getString(JSON_KEY_POKEMON_ID),
                name = jsonObject.getString(JSON_KEY_NAME),
                type1 = Type.fromValue(jsonObject.getInt(JSON_KEY_TYPE_1)),
                type2 = type2,
                ability1 = jsonObject.getInt(JSON_KEY_ABILITY_1),
                ability2 = ability2,
                hiddenAbility = hiddenAbility,
                hp = jsonObject.getInt(JSON_KEY_HP),
                attack = jsonObject.getInt(JSON_KEY_ATTACK),
                defence = jsonObject.getInt(JSON_KEY_DEFENCE),
                spAttack = jsonObject.getInt(JSON_KEY_SP_ATTACK),
                spDefence = jsonObject.getInt(JSON_KEY_SP_DEFENCE),
                speed = jsonObject.getInt(JSON_KEY_SPEED),
                levelMoves = jsonArrayToIntList(jsonObject.getJSONArray(JSON_KEY_LEVEL_MOVES)),
                machineMoves = jsonArrayToIntList(jsonObject.getJSONArray(JSON_KEY_MACHINE_MOVE)),
                eggMoves = jsonArrayToIntList(jsonObject.getJSONArray(JSON_KEY_EGG_MOVES)),
            )
        }
    }

    fun getTotalValue() = listOf(hp, attack, defence, spAttack, spDefence, speed).sum()

    fun calculateHp(individualValue: Int, effortValue: Int, level: Int = 50): Int {
        return floor(
            (
                (this.hp * 2 + individualValue + floor(effortValue / 4.0).toInt()) *
                    level
                ) /
                100.0,
        )
            .toInt() + level + 10
    }

    fun calculateAttack(
        individualValue: Int,
        effortValue: Int,
        natureCorrect: Int = NATURE_CORRECT_NONE,
        level: Int = 50,
    ): Int {
        return calculateStatus(this.attack, individualValue, effortValue, natureCorrect, level)
    }

    fun calculateDefence(
        individualValue: Int,
        effortValue: Int,
        natureCorrect: Int = NATURE_CORRECT_NONE,
        level: Int = 50,
    ): Int {
        return calculateStatus(this.defence, individualValue, effortValue, natureCorrect, level)
    }

    fun calculateSpAttack(
        individualValue: Int,
        effortValue: Int,
        natureCorrect: Int = NATURE_CORRECT_NONE,
        level: Int = 50,
    ): Int {
        return calculateStatus(this.spAttack, individualValue, effortValue, natureCorrect, level)
    }

    fun calculateSpDefence(
        individualValue: Int,
        effortValue: Int,
        natureCorrect: Int = NATURE_CORRECT_NONE,
        level: Int = 50,
    ): Int {
        return calculateStatus(this.spDefence, individualValue, effortValue, natureCorrect, level)
    }

    fun calculateSpeed(
        individualValue: Int,
        effortValue: Int,
        natureCorrect: Int = NATURE_CORRECT_NONE,
        level: Int = 50,
    ): Int {
        return calculateStatus(this.speed, individualValue, effortValue, natureCorrect, level)
    }

    private fun calculateStatus(
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
            NATURE_CORRECT_POSITIVE -> floor(statusValue * 1.1).toInt()
            NATURE_CORRECT_NEGATIVE -> floor(statusValue * 0.9).toInt()
            else -> statusValue
        }
    }

    @SuppressLint("DiscouragedApi")
    fun getImageId(context: Context): Int {
        return context.resources.getIdentifier(pokemonId, "drawable", context.packageName)
    }
}
