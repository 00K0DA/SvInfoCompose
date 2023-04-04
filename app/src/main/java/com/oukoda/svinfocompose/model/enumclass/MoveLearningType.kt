package com.oukoda.svinfocompose.model.enumclass

import androidx.annotation.StringRes
import com.oukoda.svinfocompose.R

enum class MoveLearningType(@StringRes val stringId: Int) {
    Level(R.string.move_learning_type_level),
    Machine(R.string.move_learning_type_machine),
    Egg(R.string.move_learning_type_egg),
}
