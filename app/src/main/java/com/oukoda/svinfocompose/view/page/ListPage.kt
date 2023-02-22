package com.oukoda.svinfocompose.view.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.oukoda.svinfocompose.model.enumclass.BottomItems
import com.oukoda.svinfocompose.model.rememberForeverLazyListState
import com.oukoda.svinfocompose.repository.JsonRepository
import com.oukoda.svinfocompose.view.component.ListItemView

@Composable
fun ListPage() {
    val repository = JsonRepository(resource = LocalContext.current.resources)
    val pokemonList = repository.getPokemonList()
    LazyColumn(
        state = rememberForeverLazyListState(key = BottomItems.List.route()),
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(pokemonList) { index, pokemon ->
            ListItemView(number = index, pokemon = pokemon, onTap = {})
        }
    }
}
