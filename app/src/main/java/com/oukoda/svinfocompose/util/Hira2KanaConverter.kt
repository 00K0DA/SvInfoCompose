package com.oukoda.svinfocompose.util

class Hira2KanaConverter {
    companion object {
        private val HIRAGANA_REGEX = "[\u3040-\u309F]".toRegex()
        fun convert(input: String): String {
            return input.map {
                if (HIRAGANA_REGEX.matches(it.toString())) {
                    it.plus(0x60)
                } else {
                    it
                }
            }.joinToString(separator = "")
        }
    }
}
