package com.oukoda.svinfocompose.view.component.listpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.oukoda.svinfocompose.model.dataclass.Pokemon
import com.oukoda.svinfocompose.repository.JsonRepository
import com.oukoda.svinfocompose.view.component.TypeView
import com.oukoda.svinfocompose.view.component.description.AbilitiesView

@Composable
fun DescriptionView(pokemon: Pokemon, repository: JsonRepository, onTapClose: () -> Unit) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onTapClose() },
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(context).data(data = pokemon.getImageId(context))
                            .build(),
                    ),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(180.dp),
                )
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = pokemon.name, fontSize = 24.sp)
                    TypeView(type = pokemon.type1)
                    pokemon.type2?.let {
                        TypeView(type = pokemon.type2)
                    }
                }
            }
            AbilitiesView(
                modifier = Modifier.align(Alignment.Start),
                ability1st = repository.getAbility(pokemon.ability1)!!,
                ability2nd = repository.getAbility(pokemon.ability2)!!,
                hiddenAbility = repository.getAbility(pokemon.hiddenAbility)!!,
            )
        }
    }
}
