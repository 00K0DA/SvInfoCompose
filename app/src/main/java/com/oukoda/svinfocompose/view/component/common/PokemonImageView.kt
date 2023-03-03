package com.oukoda.svinfocompose.view.component.common

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.oukoda.svinfocompose.model.dataclass.Pokemon

@Composable
fun PokemonImageView(pokemon: Pokemon, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context)
                .data(data = pokemon.getImageId(context))
                .build(),
        ),
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = modifier,
    )
}
