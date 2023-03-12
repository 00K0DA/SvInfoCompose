package com.oukoda.svinfocompose.util

import org.junit.Assert.assertEquals
import org.junit.Test

@Suppress("NonAsciiCharacters", "TestFunctionName")
class Hira2KataConverterTest {
    @Test
    fun test_ひらがな一文字が変換できること() {
        val testTaskList: List<Pair<String, String>> = listOf(
            Pair("あ", "ア"),
            Pair("い", "イ"),
            Pair("う", "ウ"),
            Pair("え", "エ"),
            Pair("お", "オ"),
            Pair("か", "カ"),
            Pair("き", "キ"),
            Pair("く", "ク"),
            Pair("け", "ケ"),
            Pair("こ", "コ"),
            Pair("さ", "サ"),
            Pair("し", "シ"),
            Pair("す", "ス"),
            Pair("せ", "セ"),
            Pair("そ", "ソ"),
        )
        testTaskList.forEach { testTask ->
            convertTest(testTask.first, testTask.second)
        }
    }

    @Test
    fun test_小文字の一文字が変換できること() {
        val testTaskList: List<Pair<String, String>> = listOf(
            Pair("ぁ", "ァ"),
            Pair("ぃ", "ィ"),
            Pair("ぅ", "ゥ"),
            Pair("ぇ", "ェ"),
            Pair("ぉ", "ォ"),
            Pair("っ", "ッ"),
            Pair("ゃ", "ャ"),
            Pair("ゅ", "ュ"),
            Pair("ょ", "ョ"),
        )
        testTaskList.forEach { testTask ->
            convertTest(testTask.first, testTask.second)
        }
    }

    @Test
    fun test_複数文字のひらがなが変換されること() {
        val testTaskList: List<Pair<String, String>> = listOf(
            Pair("うそっきー", "ウソッキー"),
            Pair("げんがー", "ゲンガー"),
            Pair("がぶりあす", "ガブリアス"),
            Pair("ぎゃらどす", "ギャラドス"),
        )
        testTaskList.forEach { testTask ->
            convertTest(testTask.first, testTask.second)
        }
    }

    @Test
    fun test_カタカナが変換されないこと() {
        val testTaskList: List<Pair<String, String>> = listOf(
            Pair("ア", "ア"),
            Pair("イ", "イ"),
            Pair("ウ", "ウ"),
            Pair("エ", "エ"),
            Pair("オ", "オ"),
            Pair("ァ", "ァ"),
        )
        testTaskList.forEach { testTask ->
            convertTest(testTask.first, testTask.second)
        }
    }

    @Test
    fun test_ひらがなのみが変換されること() {
        val testTaskList: List<Pair<String, String>> = listOf(
            Pair("ガブリあす", "ガブリアス"),
            Pair("ふしギダネ", "フシギダネ"),
            Pair("りザーどン", "リザードン"),
            Pair("ミずゴろウ", "ミズゴロウ"),
            Pair("半分、青い", "半分、青イ"),
        )
        testTaskList.forEach { testTask ->
            convertTest(testTask.first, testTask.second)
        }
    }

    @Test
    fun test_漢字が変換されないこと() {
        val testTaskList: List<Pair<String, String>> = listOf(
            Pair("勇気凛凛", "勇気凛凛"),
            Pair("元気溌剌", "元気溌剌"),
            Pair("興味津々", "興味津々"),
            Pair("意気揚々", "意気揚々"),
        )
        testTaskList.forEach { testTask ->
            convertTest(testTask.first, testTask.second)
        }
    }

    private fun convertTest(input: String, expected: String) {
        assertEquals(expected, Hira2KanaConverter.convert(input))
    }

    @Test
    fun test_カタカナがフィルタを通過すること() {
        val testTaskList: List<Pair<String, String>> = listOf(
            Pair("ガブリアス", "ガブリアス"),
            Pair("ゼニガメ", "ゼニガメ"),
            Pair("ヒトカゲ", "ヒトカゲ"),
        )
        testTaskList.forEach {
            filterTest(it.first, it.second)
        }
    }

    @Test
    fun test_ひらがながフィルタを通過すること() {
        val testTaskList: List<Pair<String, String>> = listOf(
            Pair("がぶりあす", "がぶりあす"),
            Pair("ぜにがめ", "ぜにがめ"),
        )
        testTaskList.forEach {
            filterTest(it.first, it.second)
        }
    }

    @Test
    fun test_漢字がフィルタされること() {
        val testTaskList: List<Pair<String, String>> = listOf(
            Pair("古今トウザイ", "トウザイ"),
            Pair("きそう天外", "きそう"),
            Pair("抱フクゼッ倒", "フクゼッ"),
        )
        testTaskList.forEach {
            filterTest(it.first, it.second)
        }
    }

    private fun filterTest(input: String, expected: String) {
        assertEquals(Hira2KanaConverter.hiraKataFilter(input), expected)
    }
}
