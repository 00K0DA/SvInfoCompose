package com.oukoda.svinfocompose.model.enumclass

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

enum class Type(val value: Int) {
    Normal(0),
    Fight(1),
    Fly(2),
    Poison(3),
    Ground(4),
    Rock(5),
    Bug(6),
    Ghost(7),
    Steel(8),
    Fire(9),
    Water(10),
    Grass(11),
    Electric(12),
    Psychic(13),
    Ice(14),
    Dragon(15),
    Dark(16),
    Fairy(17),
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

    fun stringId(): Int {
        return when (this) {
            Normal -> R.string.type_name_normal
            Fight -> R.string.type_name_fight
            Fly -> R.string.type_name_fly
            Poison -> R.string.type_name_poison
            Ground -> R.string.type_name_ground
            Rock -> R.string.type_name_rock
            Bug -> R.string.type_name_bug
            Ghost -> R.string.type_name_ghost
            Steel -> R.string.type_name_steel
            Fire -> R.string.type_name_fire
            Water -> R.string.type_name_water
            Grass -> R.string.type_name_grass
            Electric -> R.string.type_name_electric
            Psychic -> R.string.type_name_psychic
            Ice -> R.string.type_name_ice
            Dragon -> R.string.type_name_dragon
            Dark -> R.string.type_name_dark
            Fairy -> R.string.type_name_fairy
        }
    }
}
