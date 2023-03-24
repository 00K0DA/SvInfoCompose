package com.oukoda.svinfocompose.view.component.common

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CommonButton(stringId: Int, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = colors.surface),
    ) {
        Text(
            text = stringResource(id = stringId),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colors.onSurface,
        )
    }
}
