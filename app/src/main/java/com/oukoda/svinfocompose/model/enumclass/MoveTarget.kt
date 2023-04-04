package com.oukoda.svinfocompose.model.enumclass

import androidx.annotation.StringRes
import com.oukoda.svinfocompose.R

enum class MoveTarget(val value: Int, @StringRes val stringId: Int) {
    SelectOne(0, R.string.move_target_select_one),
    SelfOrAlly(1, R.string.move_target_self_or_ally),
    AllyOne(2, R.string.move_target_ally_one),
    None(3, R.string.move_target_none),
    WithoutSelf(4, R.string.move_target_without_self),
    EnemyAll(5, R.string.move_target_enemy_all),
    AllyAll(6, R.string.move_target_ally_all),
    Self(7, R.string.move_target_self),
    All(8, R.string.move_target_all),
    RandomOne(9, R.string.move_target_random_one),
    AllField(10, R.string.move_target_all_field),
    EnemyField(11, R.string.move_target_enemy_field),
    AllyField(12, R.string.move_target_ally_field),
    Undecided(13, R.string.move_target_undecided),
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
