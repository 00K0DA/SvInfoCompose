package com.oukoda.svinfocompose.view.component.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oukoda.svinfocompose.model.enumclass.MoveCategory

private val roundedCornerShape: Dp = 10.dp

@Composable
fun MoveCategoryView(moveCategory: MoveCategory, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .defaultMinSize(48.dp, 16.dp)
            .clip(RoundedCornerShape(roundedCornerShape))
            .background(moveCategory.color),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(id = moveCategory.stringId),
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
        )
    }
}
