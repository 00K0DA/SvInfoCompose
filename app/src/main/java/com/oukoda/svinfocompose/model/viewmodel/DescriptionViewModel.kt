package com.oukoda.svinfocompose.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oukoda.svinfocompose.model.dataclass.Pokemon
import com.oukoda.svinfocompose.model.dataclass.PokemonMove
import com.oukoda.svinfocompose.model.enumclass.MoveLearningType
import com.oukoda.svinfocompose.repository.JsonRepository
import kotlinx.coroutines.flow.MutableStateFlow

class DescriptionViewModel private constructor(
    private val repository: JsonRepository,
    private val pokemon: Pokemon,
) : ViewModel() {
    private val _pokemonMoves = MutableStateFlow(listOf<PokemonMove>())
    val pokemonMoves = _pokemonMoves

    init {
        val mutablePokemonMoves = mutableListOf<PokemonMove>()
        pokemon.levelMoves.forEach {
            val move = repository.getMove(it)!!
            mutablePokemonMoves.add(PokemonMove(MoveLearningType.Level, move))
        }
        pokemon.machineMoves.forEach {
            val move = repository.getMove(it)!!
            mutablePokemonMoves.add(PokemonMove(MoveLearningType.Machine, move))
        }
        pokemon.eggMoves.forEach {
            val move = repository.getMove(it)!!
            mutablePokemonMoves.add(PokemonMove(MoveLearningType.Egg, move))
        }
        _pokemonMoves.value = mutablePokemonMoves.toList()
    }

    @Suppress("UNCHECKED_CAST")
    class DescriptionViewModelFactory(
        private val repository: JsonRepository,
        private val pokemon: Pokemon,
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DescriptionViewModel(repository, pokemon) as T
        }
    }
}
