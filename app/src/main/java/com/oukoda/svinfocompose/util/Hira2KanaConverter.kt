package com.oukoda.svinfocompose.util

class Hira2KanaConverter {
    companion object {
        private val HIRAGANA_REGEX = "[\u3040-\u309F]".toRegex()
        private val KATAKANA_REGEX = "[\u30A0-\u30FF]".toRegex()

        // ひらがなをカタカナに変換する。
        // ひらがな以外はそのままにする
        fun convert(input: String): String {
            return input.map {
                if (HIRAGANA_REGEX.matches(it.toString())) {
                    it.plus(0x60)
                } else {
                    it
                }
            }.joinToString(separator = "")
        }

        // カタカナの文字だけ抽出する
        fun hiraKataFilter(input: String): String {
            return input.filter {
                KATAKANA_REGEX.matches(it.toString()) || HIRAGANA_REGEX.matches(it.toString())
            }
        }
    }
}
