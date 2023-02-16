package com.oukoda.svinfocompose.model.dataclass

import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Test

class AbilityTest {

    @Test
    fun fromJsonTest() {
        val ability = Ability.fromJson(JSONObject(testJson1))
        assertEquals(211, ability.abilityId)
        assertEquals("ARシステム", ability.name)
    }

    companion object {
        const val testJson1 = """{
        "ability_id": 211,
        "name": "AR\u30b7\u30b9\u30c6\u30e0",
        "description": "\u6301\u3063\u3066\u3044\u308b\u5c02\u7528\u306e\u9053\u5177\u300e\u30e1\u30e2\u30ea\u300f\u306e\u7a2e\u985e\u306b\u5bfe\u5fdc\u3057\u3066\u81ea\u5206\u306e\u300e\u30bf\u30a4\u30d7\u300f\u304c\u5909\u5316\u3059\u308b\u3002"
    }"""
    }
}
