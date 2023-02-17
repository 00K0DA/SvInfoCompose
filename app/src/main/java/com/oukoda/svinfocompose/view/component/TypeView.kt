package com.oukoda.svinfocompose.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oukoda.svinfocompose.model.enumclass.Type
import com.oukoda.svinfocompose.theme.SvInfoComposeTheme

private val roundedCornerShape: Dp = 10.dp

@Composable
fun TypeView(type: Type) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .clip(RoundedCornerShape(roundedCornerShape))
            .background(type.color()),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(id = type.stringId()),
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TypeViewPreview() {
    SvInfoComposeTheme() {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .width(64.dp)
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                for (type in Type.values()) {
                    TypeView(type = type)
                }
            }
        }
    }
}
