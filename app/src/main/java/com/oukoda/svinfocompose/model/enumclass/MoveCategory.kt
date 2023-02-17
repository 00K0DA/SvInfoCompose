package com.oukoda.svinfocompose.model.enumclass

enum class MoveCategory(val value: Int) {
    Change(0),
    Physics(1),
    Special(2),

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
