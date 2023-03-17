package com.oukoda.svinfocompose.view.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oukoda.svinfocompose.model.enumclass.BottomItems
import com.oukoda.svinfocompose.model.rememberForeverLazyListState
import com.oukoda.svinfocompose.model.viewmodel.ListPageViewModel
import com.oukoda.svinfocompose.repository.JsonRepository
import com.oukoda.svinfocompose.view.component.ListItemView
import com.oukoda.svinfocompose.view.component.listpage.DescriptionView
import com.oukoda.svinfocompose.view.component.listpage.SearchTextField
import com.oukoda.svinfocompose.view.component.listpage.SortView

private const val ROUTE_LIST = "list"
private const val ROUTE_DESCRIPTION = "desc"

@Composable
fun ListPage(
    repository: JsonRepository,
    viewModel: ListPageViewModel = viewModel(
        factory = ListPageViewModel.ListPageViewModelFactory(repository.getPokemonList()),
    ),
) {
    val pokemonList by viewModel.showPokemonList.collectAsState()
    val sortType by viewModel.sortType.collectAsState()
    val isAscending by viewModel.isAscending.collectAsState()
    val searchWord by viewModel.searchWord.collectAsState()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ROUTE_LIST) {
        composable(ROUTE_LIST) {
            LazyColumn(
                state = rememberForeverLazyListState(key = BottomItems.List.route()),
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                item { Spacer(modifier = Modifier.height(16.dp)) }
                item {
                    SearchTextField(
                        modifier = Modifier.fillMaxWidth(),
                        searchWord = searchWord,
                        onValueChange = { viewModel.setSearchWord(it) },
                    )
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        Box(modifier = Modifier.padding(vertical = 8.dp)) {
                            SortView(
                                sortType = sortType,
                                isAscending = isAscending,
                                onSelectSortType = { viewModel.setSort(it) },
                                onChangeSortMode = { viewModel.setSortMode(it) },
                                modifier = Modifier.fillMaxWidth(),
                            )
                        }
                    }
                }
                itemsIndexed(pokemonList) { _, pokemon ->
                    ListItemView(
                        pokemon = pokemon,
                        sortType = sortType,
                        onTap = {
                            viewModel.setSelectedPokemon(it)
                            navController.navigate(ROUTE_DESCRIPTION) {
                                launchSingleTop = true
                            }
                        },
                    )
                }
                item { Spacer(modifier = Modifier.height(16.dp)) }
            }
        }
        composable(ROUTE_DESCRIPTION) {
            val selectedPokemon = viewModel.getSelectedPokemon()
            if (selectedPokemon == null) {
                navController.navigate(ROUTE_LIST) {
                    launchSingleTop = true
                }
            } else {
                DescriptionView(
                    selectedPokemon,
                    repository,
                    { navController.navigate(ROUTE_LIST) },
                )
            }
        }
    }
}
