package com.oukoda.svinfocompose.view.component.description

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oukoda.svinfocompose.R
import com.oukoda.svinfocompose.model.dataclass.Move

@Composable
fun MoveDescriptionView(move: Move, modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        MoveDescriptionString(move.description)
        MoveDescriptionRow(
            title = stringResource(id = R.string.move_description_view_accuracy),
            value = if (move.accuracy == Move.INVALID_ACCURACY) "-" else move.accuracy.toString(),
        )
        MoveDescriptionRow(
            title = stringResource(id = R.string.move_description_view_pp),
            value = move.pp.toString(),
        )
        MoveDescriptionRow(
            title = stringResource(id = R.string.move_description_view_target),
            value = stringResource(id = move.target.stringId),
        )
        MoveDescriptionRowWithBoolean(
            title = stringResource(id = R.string.move_description_view_is_direct),
            value = move.isDirect,
        )
        MoveDescriptionRowWithBoolean(
            title = stringResource(id = R.string.move_description_view_can_protect),
            value = move.canProtect,
        )
        MoveDescriptionRowWithBoolean(
            title = stringResource(id = R.string.move_description_view_magic_coat),
            value = move.magicCoat,
        )
        MoveDescriptionRowWithBoolean(
            title = stringResource(id = R.string.move_description_view_snatch),
            value = move.snatch,
        )
        MoveDescriptionRowWithBoolean(
            title = stringResource(id = R.string.move_description_view_mirror_move),
            value = move.mirrorMove,
        )
        MoveDescriptionRowWithBoolean(
            title = stringResource(id = R.string.move_description_view_substitute),
            value = move.substitute,
        )
    }
}

@Composable
fun MoveDescriptionRow(title: String, value: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Text(text = title, Modifier.width(160.dp), fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Text(text = value, fontSize = 12.sp)
    }
}

@Composable
fun MoveDescriptionRowWithBoolean(title: String, value: Boolean, modifier: Modifier = Modifier) {
    MoveDescriptionRow(title = title, value = if (value) "○" else "×")
}

@Composable
fun MoveDescriptionString(description: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "技説明", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Text(text = description, fontSize = 12.sp)
    }
}
