package com.oukoda.svinfocompose.model.dataclass

import com.oukoda.svinfocompose.model.enumclass.Type
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Test

@Suppress("NonAsciiCharacters", "TestFunctionName")
class PokemonTest {
    @Test
    fun fromJson_ニャオハ() {
        val jsonObject = JSONObject(testJson)
        val pokemon = Pokemon.fromJson(jsonObject)
        assertEquals("ニャオハ", pokemon.name)
        assertEquals(null, pokemon.formName)
        assertEquals(Type.Grass, pokemon.type1)
        assertEquals(null, pokemon.type2)
        assertEquals(40, pokemon.hp)
        assertEquals(61, pokemon.attack)
        assertEquals(54, pokemon.defence)
        assertEquals(45, pokemon.spAttack)
        assertEquals(45, pokemon.spDefence)
        assertEquals(65, pokemon.speed)
        assertEquals(13, pokemon.levelMoves.size)
    }

    @Test
    fun fromJson_パフュートン_メス() {
        val jsonObject = JSONObject(testJson2)
        val pokemon = Pokemon.fromJson(jsonObject)
        assertEquals("パフュートン", pokemon.name)
        assertEquals("メスのすがた", pokemon.formName)
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
        const val testJson2 = """{
            "pokemon_id": "n916f",
        "name": "\u30d1\u30d5\u30e5\u30fc\u30c8\u30f3 (\u30e1\u30b9\u306e\u3059\u304c\u305f)",
        "type_1": 0,
        "type_2": null,
        "ability_1": 180,
        "ability_2": 82,
        "hidden_ability": 47,
        "h": 115,
        "a": 90,
        "b": 70,
        "c": 59,
        "d": 90,
        "s": 65,
        "levelMoves": [
            29,
            33,
            36,
            38,
            39,
            91,
            253,
            281,
            341,
            343,
            414,
            497,
            526,
            566,
            599
        ],
        "machineMoves": [
            34,
            36,
            63,
            91,
            156,
            164,
            168,
            182,
            189,
            203,
            214,
            240,
            241,
            263,
            270,
            304,
            331,
            341,
            402,
            412,
            414,
            416,
            428,
            442,
            523,
            566,
            587,
            655,
            758,
            866,
            900,
            901
        ],
        "eggMoves": [
            254,
            255,
            256,
            283,
            729
        ]
    }"""
    }
}
