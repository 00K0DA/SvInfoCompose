package com.oukoda.svinfocompose.view.component.listpage

import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.oukoda.svinfocompose.R
import com.oukoda.svinfocompose.model.enumclass.SortType

@Composable
fun SortView(
    sortType: SortType,
    isAscending: Boolean,
    onSelectSortType: (sortType: SortType) -> Unit,
    onChangeSortMode: (isAscending: Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    var isSelectTileExpand by remember {
        mutableStateOf(false)
    }

    Box(modifier = modifier) {
        ExtendedFloatingActionButton(
            modifier = Modifier.align(Alignment.CenterStart),
            text = { Text(text = stringResource(id = sortType.stringId)) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.sort),
                    contentDescription = "",
                )
            },
            onClick = {
                isSelectTileExpand = !isSelectTileExpand
            },
        )

        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "降順にする")
            Switch(
                checked = !isAscending,
                onCheckedChange = {
                    onChangeSortMode(!isAscending)
                },
            )
        }
    }

    DropdownMenu(
        expanded = isSelectTileExpand,
        onDismissRequest = {
            isSelectTileExpand = false
        },
    ) {
        SortType.values().forEachIndexed { _, itemValue ->
            DropdownMenuItem(
                onClick = {
                    onSelectSortType(itemValue)
                    isSelectTileExpand = false
                },
            ) {
                Text(text = stringResource(id = itemValue.stringId))
            }
        }
    }
}
