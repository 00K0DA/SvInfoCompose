package com.oukoda.svinfocompose.view.component.listpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.oukoda.svinfocompose.view.component.description.StatusRowsView

@Composable
fun DescriptionView(pokemon: Pokemon, repository: JsonRepository, onTapClose: () -> Unit) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onTapClose() },
    ) {
        Column(
            modifier = Modifier
                .padding(all = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            ) {
                Card(
                    elevation = 4.dp,
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(context)
                                .data(data = pokemon.getImageId(context))
                                .build(),
                        ),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(160.dp),
                    )
                }
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    elevation = 4.dp,
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            8.dp,
                            Alignment.CenterVertically,
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = pokemon.name,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(bottom = 8.dp),
                        )
                        TypeView(type = pokemon.type1)
                        pokemon.type2?.let {
                            TypeView(type = pokemon.type2)
                        }
                    }
                }
            }
            AbilitiesView(
                modifier = Modifier.align(Alignment.Start),
                ability1st = repository.getAbility(pokemon.ability1)!!,
                ability2nd = repository.getAbility(pokemon.ability2)!!,
                hiddenAbility = repository.getAbility(pokemon.hiddenAbility)!!,
            )
            StatusRowsView(modifier = Modifier.align(Alignment.Start), pokemon = pokemon)
        }
    }
}
