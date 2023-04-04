package com.oukoda.svinfocompose.model.enumclass

import androidx.annotation.StringRes
import com.oukoda.svinfocompose.R

enum class MoveSortType(@StringRes val stringId: Int) {
    Number(R.string.sort_type_number),
    Power(-1),
    Category(-1),
}
