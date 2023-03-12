package com.oukoda.svinfocompose.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.oukoda.svinfocompose.model.dataclass.Pokemon
import com.oukoda.svinfocompose.model.enumclass.SortType
import com.oukoda.svinfocompose.util.Hira2KanaConverter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class ListPageViewModel(private val pokemonList: List<Pokemon>) : ViewModel() {

    private var selectedPokemon: Pokemon? = null
    var isAscending: MutableStateFlow<Boolean> = MutableStateFlow(true)
    var searchWord: MutableStateFlow<String> = MutableStateFlow("")
    var sortType: MutableStateFlow<SortType> = MutableStateFlow(SortType.Number)

    val showPokemonList: StateFlow<List<Pokemon>> = combine(
        sortType,
        isAscending,
        searchWord,
    ) { sortType: SortType, isAscending: Boolean, searchWord: String ->
        var newList = when (sortType) {
            SortType.Number -> pokemonList
            SortType.HP -> pokemonList.sortedBy { it.hp }
            SortType.Attack -> pokemonList.sortedBy { it.attack }
            SortType.Defence -> pokemonList.sortedBy { it.defence }
            SortType.SpAttack -> pokemonList.sortedBy { it.spAttack }
            SortType.SpDefence -> pokemonList.sortedBy { it.spDefence }
            SortType.Speed -> pokemonList.sortedBy { it.speed }
        }
        if (!isAscending) {
            newList = newList.reversed()
        }
        if (searchWord != "") {
            newList = newList.filter { it.name.startsWith(Hira2KanaConverter.convert(searchWord)) }
        }
        newList
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        listOf(),
    )

    fun setSort(sortType: SortType) {
        this.sortType.value = sortType
    }

    fun setSelectedPokemon(pokemon: Pokemon) {
        selectedPokemon = pokemon
    }

    fun getSelectedPokemon(): Pokemon? {
        return selectedPokemon
    }

    fun setSearchWord(searchWord: String) {
        this.searchWord.value = searchWord
    }

    fun setSortMode(isAscending: Boolean) {
        this.isAscending.value = isAscending
    }

    @Suppress("UNCHECKED_CAST")
    class ListPageViewModelFactory(private val pokemonList: List<Pokemon>) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ListPageViewModel(pokemonList) as T
        }
    }
}
