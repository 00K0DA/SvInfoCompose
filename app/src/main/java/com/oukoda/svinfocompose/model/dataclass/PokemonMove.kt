package com.oukoda.svinfocompose.model.dataclass

import com.oukoda.svinfocompose.model.enumclass.MoveLearningType

data class PokemonMove(
    val moveLearningType: MoveLearningType,
    val move: Move,
)
