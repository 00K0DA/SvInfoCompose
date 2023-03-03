package com.oukoda.svinfocompose.view.component.description

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oukoda.svinfocompose.model.dataclass.Pokemon
import com.oukoda.svinfocompose.view.component.TypeView

@Composable
fun NameTypeView(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            8.dp,
            Alignment.CenterVertically,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
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
