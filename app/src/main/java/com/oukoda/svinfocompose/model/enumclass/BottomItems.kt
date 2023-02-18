package com.oukoda.svinfocompose.model.enumclass

import com.oukoda.svinfocompose.R

enum class BottomItems {
    List,
    Sort,
    Quiz,

    ;

    fun stringId(): Int {
        return when (this) {
            List -> R.string.bottom_item_list
            Sort -> R.string.bottom_item_sort
            Quiz -> R.string.bottom_item_quiz
        }
    }

    fun route(): String {
        return when (this) {
            List -> "list"
            Sort -> "sort"
            Quiz -> "quiz"
        }
    }

    fun drawableId(): Int {
        return when (this) {
            List -> R.drawable.list
            Sort -> R.drawable.sort
            Quiz -> R.drawable.quiz
        }
    }

    fun index(): Int {
        return BottomItems.values().indexOf(this)
    }
}
