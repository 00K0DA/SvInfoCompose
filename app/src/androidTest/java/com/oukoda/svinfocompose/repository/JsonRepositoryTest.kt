package com.oukoda.svinfocompose.repository

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class JsonRepositoryTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var context: Context

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun jsonReadPokemonTest() {
        val repository = JsonRepository.getInstance(context.resources)
        assertEquals("n906", repository.getPokemonIdList()[0])
        assertEquals("ニャオハ", repository.getPokemon("n906")?.name)
    }

    @Test
    fun jsonReadMoveTest() {
        val repository = JsonRepository.getInstance(context.resources)
        assertEquals("3ぼんのや", repository.getMove(858)?.name)
    }

    @Test
    fun jsonReadAbilityTest() {
        val repository = JsonRepository.getInstance(context.resources)
        assertEquals("ARシステム", repository.getAbility(211)?.name)
    }
}
