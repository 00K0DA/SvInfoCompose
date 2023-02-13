package com.oukoda.svinfocompose.model.enumclass

enum class MoveTarget(val value: Int) {
    SelectOne(0),
    SelfOrAlly(1),
    AllyOne(2),
    None(3),
    WithoutSelf(4),
    EnemyAll(5),
    AllyAll(6),
    Self(7),
    All(8),
    RandomOne(9),
    AllField(10),
    EnemyField(11),
    AllyField(12),
    Undecided(13),
    ;

    companion object {
        fun fromValue(value: Int): MoveTarget {
            MoveTarget.values().forEach {
                if (it.value == value) {
                    return it
                }
            }
            throw Exception("Invalid value")
        }
    }
}
