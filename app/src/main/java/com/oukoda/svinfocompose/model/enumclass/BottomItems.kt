package com.oukoda.svinfocompose.model.enumclass

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.oukoda.svinfocompose.R

enum class BottomItems(@StringRes val stringId: Int, @DrawableRes val drawableId: Int) {
    List(R.string.bottom_item_list, R.drawable.list),
    Sort(R.string.bottom_item_sort, R.drawable.sort),
    Quiz(R.string.bottom_item_quiz, R.drawable.quiz),

    ;

    fun route(): String {
        return when (this) {
            List -> "list"
            Sort -> "sort"
            Quiz -> "quiz"
        }
    }

    fun index(): Int {
        return BottomItems.values().indexOf(this)
    }
}
