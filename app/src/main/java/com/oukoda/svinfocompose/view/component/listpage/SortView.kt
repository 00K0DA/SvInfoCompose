package com.oukoda.svinfocompose.view.component.listpage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.oukoda.svinfocompose.R
import com.oukoda.svinfocompose.model.enumclass.SortType

@Composable
fun SortView(
    initialSortType: SortType,
    onSelectSortType: (sortType: SortType) -> Unit,
    onChangeSortMode: (isAscending: Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    var sortType by rememberSaveable {
        mutableStateOf(initialSortType)
    }

    var isExpand by remember {
        mutableStateOf(false)
    }

    var isChecked by remember {
        mutableStateOf(false)
    }

    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.End) {
            ExtendedFloatingActionButton(
                text = { Text(text = stringResource(id = sortType.stringId)) },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.sort),
                        contentDescription = "",
                    )
                },
                onClick = {
                    isExpand = !isExpand
                },
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "降順にする")
                Switch(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = it
                        onChangeSortMode(!isChecked)
                    },
                )
            }
        }

        DropdownMenu(
            expanded = isExpand,
            onDismissRequest = {
                isExpand = false
            },
        ) {
            SortType.values().forEachIndexed { _, itemValue ->
                DropdownMenuItem(
                    onClick = {
                        sortType = itemValue
                        onSelectSortType(itemValue)
                        isExpand = false
                    },
                ) {
                    Text(text = stringResource(id = itemValue.stringId))
                }
            }
        }
    }
}
