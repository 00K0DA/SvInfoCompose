package com.oukoda.svinfocompose.model.enumclass

enum class Type(val value: Int) {
    None(-1),
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
}
