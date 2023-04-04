package com.oukoda.svinfocompose.view.component

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.oukoda.svinfocompose.model.enumclass.BottomItems
import com.oukoda.svinfocompose.theme.selectedColor
import com.oukoda.svinfocompose.theme.unSelectedColor

@Composable
fun BottomBar(initialRoute: String, onTap: (BottomItems) -> Unit) {
    var route by remember { mutableStateOf(initialRoute) }
    BottomNavigation(elevation = 10.dp) {
        for (bottomItem in BottomItems.values()) {
            BottomNavigationItem(
                selected = route == bottomItem.route(),
                onClick = {
                    route = bottomItem.route()
                    onTap(bottomItem)
                },
                label = { Text(stringResource(id = bottomItem.stringId)) },
                icon = {
                    Icon(
                        painter = painterResource(id = bottomItem.drawableId),
                        contentDescription = "",
                    )
                },
                selectedContentColor = selectedColor,
                unselectedContentColor = unSelectedColor,
            )
        }
    }
}
