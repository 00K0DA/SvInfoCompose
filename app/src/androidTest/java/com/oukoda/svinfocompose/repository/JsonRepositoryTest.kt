package com.oukoda.svinfocompose.repository

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class JsonRepositoryTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun jsonReadPokemonTest() {
        val activity = composeTestRule.activity
        val repository = JsonRepository(activity.resources)
        assertEquals("n906", repository.getPokemonIdList()[0])
        assertEquals("ニャオハ", repository.getPokemon("n906")?.name)
    }

    @Test
    fun jsonReadMoveTest() {
        val activity = composeTestRule.activity
        val repository = JsonRepository(activity.resources)
        assertEquals("3ぼんのや", repository.getMove(858)?.name)
    }

    @Test
    fun jsonReadAbilityTest() {
        val activity = composeTestRule.activity
        val repository = JsonRepository(activity.resources)
        assertEquals("ARシステム", repository.getAbility(211)?.name)
    }
}
