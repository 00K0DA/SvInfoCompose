package com.oukoda.svinfocompose.model.enumclass

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.oukoda.svinfocompose.R
import com.oukoda.svinfocompose.theme.moveCategoryPhysical
import com.oukoda.svinfocompose.theme.moveCategorySpecial
import com.oukoda.svinfocompose.theme.moveCategoryStatus

enum class MoveCategory(val value: Int, @StringRes val stringId: Int, val color: Color) {
    Status(0, R.string.move_category_status, moveCategoryStatus),
    Physical(1, R.string.move_category_physical, moveCategoryPhysical),
    Special(2, R.string.move_category_special, moveCategorySpecial),
    ;

    companion object {
        fun fromValue(value: Int): MoveCategory {
            MoveCategory.values().forEach {
                if (it.value == value) {
                    return it
                }
            }
            throw Exception("Invalid value")
        }
    }
}
