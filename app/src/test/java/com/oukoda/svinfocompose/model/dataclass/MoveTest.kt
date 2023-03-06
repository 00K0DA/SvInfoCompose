package com.oukoda.svinfocompose.model.dataclass

import com.oukoda.svinfocompose.model.enumclass.MoveCategory
import com.oukoda.svinfocompose.model.enumclass.MoveTarget
import com.oukoda.svinfocompose.model.enumclass.Type
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MoveTest {

    @Test
    fun fromJsonTest() {
        val move = Move.fromJson(JSONObject(testJson))
        assertEquals(359, move.moveId)
        assertEquals("アームハンマー", move.name)
        assertEquals(Type.Fight, move.moveType)
        assertEquals(MoveCategory.Physical, move.category)
        assertEquals(100, move.power)
        assertEquals(MoveTarget.SelectOne, move.target)
        assertFalse(move.isDirect)
        assertTrue(move.canProtect)
        assertFalse(move.magicCoat)
        assertFalse(move.snatch)
        assertTrue(move.mirrorMove)
        assertFalse(move.substitute)
    }

    companion object {
        const val testJson = """{
        "move_id": 359,
        "name": "\u30a2\u30fc\u30e0\u30cf\u30f3\u30de\u30fc",
        "move_type": 1,
        "category": 1,
        "power": 100,
        "accuracy": 90,
        "pp": 10,
        "target": 0,
        "is_direct": false,
        "can_protect": true,
        "magic_coat": false,
        "snatch": false,
        "mirror_move": true,
        "substitute": false,
        "description": "\u653b\u6483\u5f8c\u3001\u81ea\u5206\u306e\u300e\u3059\u3070\u3084\u3055\u300f\u30e9\u30f3\u30af\u304c1\u6bb5\u968e\u4e0b\u304c\u308b\u3002\u7279\u6027\u300e\u3066\u3064\u306e\u3053\u3076\u3057\u300f\u306e\u6642\u3001\u5a01\u529b\u304c1.2\u500d\u306b\u306a\u308b\u3002"
    }"""
    }
}
