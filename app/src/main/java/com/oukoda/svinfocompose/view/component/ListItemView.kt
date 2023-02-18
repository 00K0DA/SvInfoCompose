package com.oukoda.svinfocompose.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.oukoda.svinfocompose.model.dataclass.Pokemon
import com.oukoda.svinfocompose.repository.JsonRepository
import com.oukoda.svinfocompose.theme.SvInfoComposeTheme

@Composable
fun ListItemView(
    number: Int,
    pokemon: Pokemon,
    onTap: (pokemon: Pokemon) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable { onTap(pokemon) }
            .padding(horizontal = 16.dp),
        elevation = 4.dp,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val context = LocalContext.current
            Text(
                text = (number + 1).toString().padStart(3, '0'),
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
            )
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(context).data(data = pokemon.getImageId(context))
                        .build(),
                ),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(80.dp),
            )

            if (pokemon.type2 == null) {
                TypeView(type = pokemon.type1)
            } else {
                Column() {
                    TypeView(type = pokemon.type1)
                    Spacer(modifier = Modifier.height(8.dp))
                    TypeView(type = pokemon.type2)
                }
            }
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                if (pokemon.name.contains("(")) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        val name = pokemon.name.split("(")[0]
                        val form = pokemon.name.split("(")[1].replace(")", "")
                        NameText(text = name)
                        FormText(text = form)
                    }
                } else {
                    NameText(text = pokemon.name)
                }
            }
        }
    }
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
        val repository = JsonRepository(resource = LocalContext.current.resources)
        val pokemonList = repository.getPokemonList()
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            itemsIndexed(pokemonList) { index, pokemon ->
                ListItemView(number = index, pokemon = pokemon, onTap = {})
            }
        }
    }
}
