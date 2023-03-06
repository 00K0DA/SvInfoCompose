package com.oukoda.svinfocompose.view.component.description

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oukoda.svinfocompose.R
import com.oukoda.svinfocompose.model.dataclass.Pokemon
import com.oukoda.svinfocompose.view.component.common.ExpandView
import kotlinx.coroutines.delay

enum class StatusType(val statusLabelId: Int) {
    HP(R.string.status_row_hp),
    Attack(R.string.status_row_attack),
    Defence(R.string.status_row_defence),
    SpAttack(R.string.status_row_sp_attack),
    SpDefence(R.string.status_row_sp_defence),
    Speed(R.string.status_row_speed),
    ;

    fun getStatusValue(pokemon: Pokemon): Int {
        return when (this) {
            HP -> pokemon.hp
            Attack -> pokemon.attack
            Defence -> pokemon.defence
            SpAttack -> pokemon.spAttack
            SpDefence -> pokemon.spDefence
            Speed -> pokemon.speed
        }
    }

    @Composable
    fun GetDetailInfoRows(pokemon: Pokemon) {
        when (this) {
            HP -> Column() {
                InfoRow(
                    labelId = R.string.status_row_max,
                    value = pokemon.calculateHp(31, 252),
                )
                InfoRow(
                    labelId = R.string.status_row_plane,
                    value = pokemon.calculateHp(31, 0),
                )
                InfoRow(
                    labelId = R.string.status_row_min,
                    value = pokemon.calculateHp(0, 0),
                )
            }
            Attack -> Column() {
                InfoRow(
                    labelId = R.string.status_row_max,
                    value = pokemon.calculateAttack(31, 252, Pokemon.NATURE_CORRECT_POSITIVE),
                )
                InfoRow(
                    labelId = R.string.status_row_sub_max,
                    value = pokemon.calculateAttack(31, 252),
                )
                InfoRow(
                    labelId = R.string.status_row_plane,
                    value = pokemon.calculateAttack(31, 0),
                )
                InfoRow(
                    labelId = R.string.status_row_min,
                    value = pokemon.calculateAttack(0, 0, Pokemon.NATURE_CORRECT_NEGATIVE),
                )
            }
            Defence -> Column() {
                InfoRow(
                    labelId = R.string.status_row_max,
                    value = pokemon.calculateDefence(31, 252, Pokemon.NATURE_CORRECT_POSITIVE),
                )
                InfoRow(
                    labelId = R.string.status_row_sub_max,
                    value = pokemon.calculateDefence(31, 252),
                )
                InfoRow(
                    labelId = R.string.status_row_plane,
                    value = pokemon.calculateDefence(31, 0),
                )
                InfoRow(
                    labelId = R.string.status_row_min,
                    value = pokemon.calculateDefence(0, 0, Pokemon.NATURE_CORRECT_NEGATIVE),
                )
            }
            SpAttack -> Column() {
                InfoRow(
                    labelId = R.string.status_row_max,
                    value = pokemon.calculateSpAttack(31, 252, Pokemon.NATURE_CORRECT_POSITIVE),
                )
                InfoRow(
                    labelId = R.string.status_row_sub_max,
                    value = pokemon.calculateSpAttack(31, 252),
                )
                InfoRow(
                    labelId = R.string.status_row_plane,
                    value = pokemon.calculateSpAttack(31, 0),
                )
                InfoRow(
                    labelId = R.string.status_row_min,
                    value = pokemon.calculateSpAttack(0, 0, Pokemon.NATURE_CORRECT_NEGATIVE),
                )
            }
            SpDefence -> Column() {
                InfoRow(
                    labelId = R.string.status_row_max,
                    value = pokemon.calculateSpDefence(31, 252, Pokemon.NATURE_CORRECT_POSITIVE),
                )
                InfoRow(
                    labelId = R.string.status_row_sub_max,
                    value = pokemon.calculateSpDefence(31, 252),
                )
                InfoRow(
                    labelId = R.string.status_row_plane,
                    value = pokemon.calculateSpDefence(31, 0),
                )
                InfoRow(
                    labelId = R.string.status_row_min,
                    value = pokemon.calculateSpDefence(0, 0, Pokemon.NATURE_CORRECT_NEGATIVE),
                )
            }
            Speed -> Column() {
                InfoRow(
                    labelId = R.string.status_row_max,
                    value = pokemon.calculateSpeed(31, 252, Pokemon.NATURE_CORRECT_POSITIVE),
                )
                InfoRow(
                    labelId = R.string.status_row_sub_max,
                    value = pokemon.calculateSpeed(31, 252),
                )
                InfoRow(
                    labelId = R.string.status_row_plane,
                    value = pokemon.calculateSpeed(31, 0),
                )
                InfoRow(
                    labelId = R.string.status_row_min,
                    value = pokemon.calculateSpeed(0, 0, Pokemon.NATURE_CORRECT_NEGATIVE),
                )
            }
        }
    }

    @Composable
    private fun InfoRow(labelId: Int, value: Int) {
        val label = stringResource(id = labelId)
        Row {
            Text(modifier = Modifier.width(48.dp), text = label, fontSize = 12.sp)
            Text(text = value.toString(), fontSize = 12.sp)
        }
    }
}

@Composable
fun StatusRowsView(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier, elevation = 4.dp) {
        Column(
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            StatusType.values().forEach {
                StatusRowView(statusType = it, pokemon = pokemon)
            }
        }
    }
}

@Composable
fun StatusRowView(
    statusType: StatusType,
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
) {
    var isExpandBar by remember {
        mutableStateOf(false)
    }

    var isExpandInfo by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        delay(250)
        isExpandBar = true
    }

    Column {
        Row(
            modifier = modifier
                .clickable { isExpandInfo = !isExpandInfo }
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                modifier = Modifier.width(72.dp),
                text = stringResource(id = statusType.statusLabelId),
                fontSize = 20.sp,
            )
            Text(
                modifier = Modifier.width(40.dp),
                text = statusType.getStatusValue(pokemon).toString(),
                fontSize = 20.sp,
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart,
            ) {
                androidx.compose.animation.AnimatedVisibility(
                    modifier = modifier
                        .height(24.dp)
                        .padding(top = 8.dp, bottom = 8.dp, end = 32.dp),
                    visible = isExpandBar,
                    enter = expandHorizontally(expandFrom = Alignment.Start),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.LightGray),
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(fraction = statusType.getStatusValue(pokemon) / 255f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.Red),
                    )
                }
                ExpandView(
                    isExpand = isExpandInfo,
                    Modifier
                        .size(24.dp)
                        .align(Alignment.CenterEnd),
                )
            }
        }
        AnimatedVisibility(visible = isExpandInfo) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 112.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                statusType.GetDetailInfoRows(pokemon)
            }
        }
    }
}
