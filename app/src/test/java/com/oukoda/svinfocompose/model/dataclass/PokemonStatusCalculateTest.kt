package com.oukoda.svinfocompose.model.dataclass

import com.oukoda.svinfocompose.model.enumclass.Type
import org.junit.Assert.assertEquals
import org.junit.Test

// テスト名に日本語を利用するため、Warningを抑制
@Suppress("NonAsciiCharacters", "TestFunctionName")
class PokemonStatusCalculateTest {

    @Test
    fun test_最大HP() {
        assertEquals(215, garchomp.calculateHp(31, 252))
    }

    @Test
    fun test_無振りHP() {
        assertEquals(183, garchomp.calculateHp(31, 0))
    }

    @Test
    fun test_最小HP() {
        assertEquals(168, garchomp.calculateHp(0, 0))
    }

    @Test
    fun test_攻撃最大() {
        assertEquals(200, garchomp.calculateAttack(31, 252, Pokemon.NATURE_CORRECT_POSITIVE))
    }

    @Test
    fun test_攻撃準最大() {
        assertEquals(182, garchomp.calculateAttack(31, 252, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_攻撃4振り() {
        assertEquals(151, garchomp.calculateAttack(31, 4, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_攻撃無振り() {
        assertEquals(150, garchomp.calculateAttack(31, 0, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_攻撃最低() {
        assertEquals(121, garchomp.calculateAttack(0, 0, Pokemon.NATURE_CORRECT_NEGATIVE))
    }

    @Test
    fun test_防御最大() {
        assertEquals(161, garchomp.calculateDefence(31, 252, Pokemon.NATURE_CORRECT_POSITIVE))
    }

    @Test
    fun test_防御準最大() {
        assertEquals(147, garchomp.calculateDefence(31, 252, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_防御4振り() {
        assertEquals(116, garchomp.calculateDefence(31, 4, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_防御無振り() {
        assertEquals(115, garchomp.calculateDefence(31, 0, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_防御最低() {
        assertEquals(90, garchomp.calculateDefence(0, 0, Pokemon.NATURE_CORRECT_NEGATIVE))
    }

    @Test
    fun test_特攻最大() {
        assertEquals(145, garchomp.calculateSpAttack(31, 252, Pokemon.NATURE_CORRECT_POSITIVE))
    }

    @Test
    fun test_特攻準最大() {
        assertEquals(132, garchomp.calculateSpAttack(31, 252, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_特攻4振り() {
        assertEquals(101, garchomp.calculateSpAttack(31, 4, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_特攻無振り() {
        assertEquals(100, garchomp.calculateSpAttack(31, 0, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_特攻最低() {
        assertEquals(76, garchomp.calculateSpAttack(0, 0, Pokemon.NATURE_CORRECT_NEGATIVE))
    }

    @Test
    fun test_特防最大() {
        assertEquals(150, garchomp.calculateSpDefence(31, 252, Pokemon.NATURE_CORRECT_POSITIVE))
    }

    @Test
    fun test_特防準最大() {
        assertEquals(137, garchomp.calculateSpDefence(31, 252, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_特防4振り() {
        assertEquals(106, garchomp.calculateSpDefence(31, 4, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_特防無振り() {
        assertEquals(105, garchomp.calculateSpDefence(31, 0, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_特防最低() {
        assertEquals(81, garchomp.calculateSpDefence(0, 0, Pokemon.NATURE_CORRECT_NEGATIVE))
    }

    @Test
    fun test_素早最大() {
        assertEquals(169, garchomp.calculateSpeed(31, 252, Pokemon.NATURE_CORRECT_POSITIVE))
    }

    @Test
    fun test_素早準最大() {
        assertEquals(154, garchomp.calculateSpeed(31, 252, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_素早4振り() {
        assertEquals(123, garchomp.calculateSpeed(31, 4, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_素早無振り() {
        assertEquals(122, garchomp.calculateSpeed(31, 0, Pokemon.NATURE_CORRECT_NONE))
    }

    @Test
    fun test_素早最低() {
        assertEquals(96, garchomp.calculateSpeed(0, 0, Pokemon.NATURE_CORRECT_NEGATIVE))
    }

    companion object {
        val garchomp = Pokemon(
            0,
            "n445",
            "ガブリアス",
            null,
            Type.Dragon,
            Type.Ground,
            8,
            8,
            24,
            108,
            130,
            95,
            80,
            85,
            102,
            emptyList(),
            emptyList(),
            emptyList(),
        )
    }
}
