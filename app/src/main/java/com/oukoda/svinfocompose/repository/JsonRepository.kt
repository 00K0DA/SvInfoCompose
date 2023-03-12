package com.oukoda.svinfocompose.repository

import android.content.res.Resources
import com.oukoda.svinfocompose.model.dataclass.Ability
import com.oukoda.svinfocompose.model.dataclass.Move
import com.oukoda.svinfocompose.model.dataclass.Pokemon
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class JsonRepository private constructor(resource: Resources) {
    private var pokemonMap: Map<String, Pokemon>
    private var moveMap: Map<Int, Move>
    private var abilityMap: Map<Int, Ability>

    init {
        val pokemonJsonArray = getJsonObject(resource, "pokemon.json")
        pokemonMap = (0 until pokemonJsonArray.length()).associate {
            val pokemon = Pokemon.fromJson(it + 1, pokemonJsonArray[it] as JSONObject)
            pokemon.pokemonId to pokemon
        }
        val moveJsonArray = getJsonObject(resource, "move.json")
        moveMap = (0 until moveJsonArray.length()).associate {
            val move = Move.fromJson(moveJsonArray[it] as JSONObject)
            move.moveId to move
        }

        val abilityJsonArray = getJsonObject(resource, "ability.json")
        abilityMap = (0 until abilityJsonArray.length()).associate {
            val ability = Ability.fromJson(abilityJsonArray[it] as JSONObject)
            ability.abilityId to ability
        }
    }

    fun getPokemonIdList() = pokemonMap.map { it.value.pokemonId }

    fun getPokemonList() = pokemonMap.map { it.value }

    fun getPokemon(pokemonId: String) = pokemonMap[pokemonId]

    fun getMoveList() = moveMap.values

    fun getMove(moveId: Int) = moveMap[moveId]

    fun getAbility(abilityId: Int) = abilityMap[abilityId]

    companion object {
        private fun getJsonObject(resources: Resources, fileName: String): JSONArray {
            val assetManager = resources.assets
            return JSONArray(BufferedReader(InputStreamReader(assetManager.open(fileName))).readText())
        }

        private var INSTANCE: JsonRepository? = null

        fun getInstance(resources: Resources): JsonRepository {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = JsonRepository(resources)
                }
            }
            return INSTANCE!!
        }
    }
}
