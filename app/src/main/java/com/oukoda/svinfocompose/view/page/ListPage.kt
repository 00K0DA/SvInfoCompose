package com.oukoda.svinfocompose.view.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oukoda.svinfocompose.model.dataclass.Pokemon
import com.oukoda.svinfocompose.model.enumclass.BottomItems
import com.oukoda.svinfocompose.model.rememberForeverLazyListState
import com.oukoda.svinfocompose.repository.JsonRepository
import com.oukoda.svinfocompose.view.component.ListItemView
import com.oukoda.svinfocompose.view.component.listpage.DescriptionView

@Composable
fun ListPage() {
    val ROUTE_LIST = "list"
    val ROUTE_DESCRIPTION = "desc"
    val repository = JsonRepository(resource = LocalContext.current.resources)
    val pokemonList = repository.getPokemonList()
    val navController = rememberNavController()
    var selectedPokemon: Pokemon? = null

    NavHost(navController = navController, startDestination = ROUTE_LIST) {
        composable(ROUTE_LIST) {
            LazyColumn(
                state = rememberForeverLazyListState(key = BottomItems.List.route()),
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                item { Spacer(modifier = Modifier.height(16.dp)) }
                itemsIndexed(pokemonList) { index, pokemon ->
                    ListItemView(number = index, pokemon = pokemon, onTap = {
                        selectedPokemon = pokemon
                        navController.navigate(ROUTE_DESCRIPTION) {
                            launchSingleTop = true
                        }
                    })
                }
                item { Spacer(modifier = Modifier.height(16.dp)) }
            }
        }

        composable(ROUTE_DESCRIPTION) {
            DescriptionView(selectedPokemon!!, repository) { navController.navigate(ROUTE_LIST) }
        }
    }
}
