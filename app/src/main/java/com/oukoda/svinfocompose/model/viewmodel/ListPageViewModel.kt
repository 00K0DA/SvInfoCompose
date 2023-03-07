package com.oukoda.svinfocompose.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oukoda.svinfocompose.model.dataclass.Pokemon
import com.oukoda.svinfocompose.model.enumclass.SortType
import kotlinx.coroutines.flow.MutableStateFlow

class ListPageViewModel(private val pokemonList: List<Pokemon>) : ViewModel() {

    private val _showPokemonList: MutableStateFlow<List<Pokemon>> = MutableStateFlow(pokemonList)
    val showPokemonList = _showPokemonList

    private var selectedPokemon: Pokemon? = null
    private var searchWord: String = ""

    fun sort(sortType: SortType) {
        val newList = when (sortType) {
            SortType.Number -> pokemonList
            SortType.HP -> pokemonList.sortedBy { it.hp }
            SortType.Attack -> pokemonList.sortedBy { it.attack }
            SortType.Defence -> pokemonList.sortedBy { it.defence }
            SortType.SpAttack -> pokemonList.sortedBy { it.spAttack }
            SortType.SpDefence -> pokemonList.sortedBy { it.defence }
            SortType.Speed -> pokemonList.sortedBy { it.speed }
        }
        _showPokemonList.value = newList
    }

    fun setSelectedPokemon(pokemon: Pokemon) {
        selectedPokemon = pokemon
    }

    fun getSelectedPokemon(): Pokemon? {
        return selectedPokemon
    }

    fun setSearchWord(searchWord: String) {
        this.searchWord = searchWord
        filterBySearchWord()
    }

    private fun filterBySearchWord() {
        val showList = showPokemonList.value
        val startWithList = showList.filter { it.name.startsWith(searchWord) }
        val containsList = showList.minus(showList.toSet()).filter { it.name.contains(searchWord) }
        _showPokemonList.value = startWithList + containsList
    }

    @Suppress("UNCHECKED_CAST")
    class ListPageViewModelFactory(private val pokemonList: List<Pokemon>) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ListPageViewModel(pokemonList) as T
        }
    }
}
