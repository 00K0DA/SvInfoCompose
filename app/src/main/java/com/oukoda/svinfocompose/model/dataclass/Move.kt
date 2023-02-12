package com.oukoda.svinfocompose.model.dataclass

data class Move(
    val moveId: Int,
    val name: String,
    val moveType: Int,
    val category: Int,
    val power: Int,
    val accuracy: Int,
    val pp: Int,
    val target: Int,
    val isDirect: Boolean,
    val canProtect: Boolean,
    val magicCoat: Boolean,
    val snatch: Boolean,
    val mirrorMove: Boolean,
    val substitute: Boolean,
    val description: String
)