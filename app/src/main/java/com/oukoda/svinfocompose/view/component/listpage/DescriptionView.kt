package com.oukoda.svinfocompose.view.component.listpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oukoda.svinfocompose.R
import com.oukoda.svinfocompose.model.dataclass.Pokemon
import com.oukoda.svinfocompose.model.viewmodel.DescriptionViewModel
import com.oukoda.svinfocompose.repository.JsonRepository
import com.oukoda.svinfocompose.view.component.common.CommonButton
import com.oukoda.svinfocompose.view.component.common.PokemonImageView
import com.oukoda.svinfocompose.view.component.description.AbilitiesView
import com.oukoda.svinfocompose.view.component.description.MovesView
import com.oukoda.svinfocompose.view.component.description.NameTypeView
import com.oukoda.svinfocompose.view.component.description.StatusRowsView

@Composable
fun DescriptionView(
    pokemon: Pokemon,
    repository: JsonRepository,
    onTapClose: () -> Unit,
    viewModel: DescriptionViewModel = viewModel(
        factory = DescriptionViewModel.DescriptionViewModelFactory(repository, pokemon),
    ),
) {
    val backGroundAlpha = 0.5F
    val pokemonMoves by viewModel.pokemonMoves.collectAsState()
    Card(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier
                .let {
                    if (pokemon.type2 == null) {
                        it.background(
                            pokemon.type1
                                .color()
                                .copy(alpha = backGroundAlpha),
                        )
                    } else {
                        it.background(
                            Brush.linearGradient(
                                listOf(
                                    pokemon.type1
                                        .color()
                                        .copy(alpha = backGroundAlpha),
                                    pokemon.type2
                                        .color()
                                        .copy(alpha = backGroundAlpha),
                                ),
                            ),
                        )
                    }
                }
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        8.dp,
                        Alignment.CenterHorizontally,
                    ),
                ) {
                    Card(
                        elevation = 4.dp,
                    ) {
                        PokemonImageView(
                            pokemon = pokemon,
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
                        NameTypeView(
                            pokemon = pokemon,
                        )
                    }
                }
            }

            item {
                AbilitiesView(
                    ability1st = repository.getAbility(pokemon.ability1)!!,
                    ability2nd = repository.getAbility(pokemon.ability2)!!,
                    hiddenAbility = repository.getAbility(pokemon.hiddenAbility)!!,
                )
            }

            item {
                StatusRowsView(pokemon = pokemon)
            }

            item {
                CommonButton(stringId = R.string.description_view_close, onClick = { onTapClose() })
            }

            item {
                MovesView(pokemonMoves = pokemonMoves)
            }

            item {
                CommonButton(stringId = R.string.description_view_close, onClick = { onTapClose() })
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
