package com.oukoda.svinfocompose.view.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oukoda.svinfocompose.model.dataclass.Pokemon
import com.oukoda.svinfocompose.model.enumclass.SortType
import com.oukoda.svinfocompose.repository.JsonRepository
import com.oukoda.svinfocompose.theme.SvInfoComposeTheme
import com.oukoda.svinfocompose.view.component.common.PokemonImageView

@Composable
fun ListItemView(
    pokemon: Pokemon,
    onTap: (pokemon: Pokemon) -> Unit,
    sortType: SortType,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable { onTap(pokemon) },
        elevation = 4.dp,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ValueText(pokemon, sortType)
            PokemonImageView(
                pokemon = pokemon,
                modifier = Modifier.size(80.dp),
            )
            if (pokemon.type2 == null) {
                TypeView(type = pokemon.type1)
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    TypeView(type = pokemon.type1)
                    TypeView(type = pokemon.type2)
                }
            }
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                if (pokemon.formName != null) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        NameText(text = pokemon.name)
                        FormText(text = pokemon.formName)
                    }
                } else {
                    NameText(text = pokemon.name)
                }
            }
        }
    }
}

@Composable
private fun ValueText(pokemon: Pokemon, sortType: SortType) {
    val text: String = when (sortType) {
        SortType.Number -> pokemon.number.toString().padStart(3, '0')
        SortType.HP -> pokemon.hp.toString()
        SortType.Attack -> pokemon.attack.toString()
        SortType.Defence -> pokemon.defence.toString()
        SortType.SpAttack -> pokemon.spAttack.toString()
        SortType.SpDefence -> pokemon.spDefence.toString()
        SortType.Speed -> pokemon.speed.toString()
    }
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold,
    )
}

@Composable
private fun NameText(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
private fun FormText(text: String) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Preview
@Composable
fun ListItemViewPreview() {
    SvInfoComposeTheme() {
        val repository = JsonRepository.getInstance(LocalContext.current.resources)
        val pokemonList = repository.getPokemonList()
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            itemsIndexed(pokemonList) { index, pokemon ->
                ListItemView(pokemon = pokemon, onTap = {}, SortType.Number)
            }
        }
    }
}
