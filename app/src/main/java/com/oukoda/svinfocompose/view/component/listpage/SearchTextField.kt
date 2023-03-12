package com.oukoda.svinfocompose.view.component.listpage

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.oukoda.svinfocompose.R
import com.oukoda.svinfocompose.util.Hira2KanaConverter

@Composable
fun SearchTextField(
    searchWord: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        modifier = modifier,
        value = searchWord,
        label = { Text(stringResource(id = R.string.search_text_field_label)) },
        onValueChange = {
            val newInputText = Hira2KanaConverter.hiraKataFilter(it)
            if (searchWord != newInputText) {
                onValueChange(newInputText)
            }
        },
    )
}
