package com.oukoda.svinfocompose.view.component.common

import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.oukoda.svinfocompose.R

@Composable
fun ExpandView(isExpand: Boolean, modifier: Modifier = Modifier) {
    val imageId = if (isExpand) R.drawable.expand_less else R.drawable.expand_more
    Image(
        modifier = modifier,
        painter = painterResource(id = imageId),
        contentDescription = null,
        colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
    )
}
