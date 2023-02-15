package com.oukoda.svinfocompose.model.dataclass

import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Test

class PokemonTest {
    @Test
    fun fromJson() {
        val jsonObject = JSONObject(testJson)
        val pokemon = Pokemon.fromJson(jsonObject)
        assertEquals("ニャオハ", pokemon.name)
        assertEquals(11, pokemon.type1)
        assertEquals(null, pokemon.type2)
        assertEquals(40, pokemon.hp)
        assertEquals(61, pokemon.attack)
        assertEquals(54, pokemon.defence)
        assertEquals(45, pokemon.spAttack)
        assertEquals(45, pokemon.spDefence)
        assertEquals(65, pokemon.speed)
        assertEquals(13, pokemon.levelMoves.size)
    }

    companion object {
        const val testJson = """{
        "pokemon_id": "n906",
        "name": "\u30cb\u30e3\u30aa\u30cf",
        "type_1": 11,
        "type_2": null,
        "ability_1": 65,
        "ability_2": null,
        "hidden_ability": 179,
        "h": 40,
        "a": 61,
        "b": 54,
        "c": 45,
        "d": 45,
        "s": 65,
        "levelMoves": [
            10,
            39,
            44,
            98,
            163,
            345,
            369,
            388,
            402,
            412,
            468,
            587,
            621
        ],
        "machineMoves": [
            36,
            76,
            97,
            129,
            156,
            164,
            182,
            189,
            202,
            203,
            204,
            214,
            263,
            269,
            270,
            313,
            331,
            345,
            369,
            402,
            412,
            417,
            421,
            437,
            447,
            512,
            520,
            566,
            568,
            587,
            866,
            900
        ],
        "eggMoves": [
            73,
            383,
            389,
            502,
            577
        ]
    }"""
    }
}
