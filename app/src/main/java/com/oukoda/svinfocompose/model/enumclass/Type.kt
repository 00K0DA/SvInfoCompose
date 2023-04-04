package com.oukoda.svinfocompose.model.enumclass

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.oukoda.svinfocompose.R
import com.oukoda.svinfocompose.theme.typeColorBug
import com.oukoda.svinfocompose.theme.typeColorDark
import com.oukoda.svinfocompose.theme.typeColorDragon
import com.oukoda.svinfocompose.theme.typeColorElectric
import com.oukoda.svinfocompose.theme.typeColorFairy
import com.oukoda.svinfocompose.theme.typeColorFight
import com.oukoda.svinfocompose.theme.typeColorFire
import com.oukoda.svinfocompose.theme.typeColorFly
import com.oukoda.svinfocompose.theme.typeColorGhost
import com.oukoda.svinfocompose.theme.typeColorGrass
import com.oukoda.svinfocompose.theme.typeColorGround
import com.oukoda.svinfocompose.theme.typeColorIce
import com.oukoda.svinfocompose.theme.typeColorNormal
import com.oukoda.svinfocompose.theme.typeColorPoison
import com.oukoda.svinfocompose.theme.typeColorPsychic
import com.oukoda.svinfocompose.theme.typeColorRock
import com.oukoda.svinfocompose.theme.typeColorSteel
import com.oukoda.svinfocompose.theme.typeColorWater

enum class Type(val value: Int, @StringRes val stringId: Int) {
    Normal(0, R.string.type_name_normal),
    Fight(1, R.string.type_name_fight),
    Fly(2, R.string.type_name_fly),
    Poison(3, R.string.type_name_poison),
    Ground(4, R.string.type_name_ground),
    Rock(5, R.string.type_name_rock),
    Bug(6, R.string.type_name_bug),
    Ghost(7, R.string.type_name_ghost),
    Steel(8, R.string.type_name_steel),
    Fire(9, R.string.type_name_fire),
    Water(10, R.string.type_name_water),
    Grass(11, R.string.type_name_grass),
    Electric(12, R.string.type_name_electric),
    Psychic(13, R.string.type_name_psychic),
    Ice(14, R.string.type_name_ice),
    Dragon(15, R.string.type_name_dragon),
    Dark(16, R.string.type_name_dark),
    Fairy(17, R.string.type_name_fairy),
    ;

    companion object {
        fun fromValue(value: Int): Type {
            Type.values().forEach {
                if (it.value == value) {
                    return it
                }
            }
            throw Exception("Invalid value")
        }
    }

    fun color(): Color {
        return when (this) {
            Normal -> typeColorNormal
            Fight -> typeColorFight
            Fly -> typeColorFly
            Poison -> typeColorPoison
            Ground -> typeColorGround
            Rock -> typeColorRock
            Bug -> typeColorBug
            Ghost -> typeColorGhost
            Steel -> typeColorSteel
            Fire -> typeColorFire
            Water -> typeColorWater
            Grass -> typeColorGrass
            Electric -> typeColorElectric
            Psychic -> typeColorPsychic
            Ice -> typeColorIce
            Dragon -> typeColorDragon
            Dark -> typeColorDark
            Fairy -> typeColorFairy
        }
    }
}
