package com.oukoda.svinfocompose.view.component.description

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oukoda.svinfocompose.R
import com.oukoda.svinfocompose.model.dataclass.Move
import com.oukoda.svinfocompose.model.dataclass.PokemonMove
import com.oukoda.svinfocompose.model.enumclass.MoveLearningType
import com.oukoda.svinfocompose.repository.JsonRepository
import com.oukoda.svinfocompose.theme.SvInfoComposeTheme
import com.oukoda.svinfocompose.view.component.TypeView
import com.oukoda.svinfocompose.view.component.common.ExpandView
import com.oukoda.svinfocompose.view.component.common.MoveCategoryView

@Composable
fun MovesView(pokemonMoves: List<PokemonMove>, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                stringResource(id = R.string.move_view_title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            pokemonMoves.forEach {
                MoveView(pokemonMove = it)
            }
        }
    }
}

@Composable
fun MoveView(pokemonMove: PokemonMove, modifier: Modifier = Modifier) {
    val move = pokemonMove.move
    var isExpand by remember { mutableStateOf(false) }
    val powerString: String = if (move.power != Move.INVALID_POWER) move.power.toString() else "-"
    Column(modifier = modifier.padding(vertical = 8.dp)) {
        Row(
            modifier = Modifier
                .clickable { isExpand = !isExpand },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(text = move.name, modifier = Modifier.weight(2f, true))
            MoveCategoryView(moveCategory = move.category, modifier = Modifier.width(48.dp))
            Text(
                text = powerString,
                modifier = Modifier.width(32.dp),
                textAlign = TextAlign.Center,
            )
            TypeView(type = move.moveType)
            Text(
                text = stringResource(pokemonMove.moveLearningType.stringId),
                fontSize = 12.sp,
                modifier = Modifier.width(24.dp),
                textAlign = TextAlign.Center,
            )
            ExpandView(isExpand = isExpand)
        }
        AnimatedVisibility(visible = isExpand) {
            Column(modifier = Modifier.fillMaxWidth()) {
                MoveDescriptionView(
                    move = pokemonMove.move,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoveViewPreview() {
    SvInfoComposeTheme(darkTheme = true) {
        val repository = JsonRepository.getInstance(LocalContext.current.resources)
        LazyColumn(
            Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(repository.getMoveList().toList()) {
                MoveView(pokemonMove = PokemonMove(MoveLearningType.Level, it))
            }
        }
    }
}
