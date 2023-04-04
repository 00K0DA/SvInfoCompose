package com.oukoda.svinfocompose.model.enumclass

import androidx.annotation.StringRes
import com.oukoda.svinfocompose.R

enum class SortType(@StringRes val stringId: Int) {
    Number(R.string.sort_type_number),
    HP(R.string.sort_type_hp),
    Attack(R.string.sort_type_attack),
    Defence(R.string.sort_type_defence),
    SpAttack(R.string.sort_type_sp_attack),
    SpDefence(R.string.sort_type_sp_defence),
    Speed(R.string.sort_type_speed),
}
