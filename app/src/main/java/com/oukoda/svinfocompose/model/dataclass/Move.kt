package com.oukoda.svinfocompose.model.dataclass

import com.oukoda.svinfocompose.model.enumclass.MoveCategory
import com.oukoda.svinfocompose.model.enumclass.MoveTarget
import com.oukoda.svinfocompose.model.enumclass.Type
import org.json.JSONObject

data class Move(
    val moveId: Int,
    val name: String,
    val moveType: Type,
    val category: MoveCategory,
    val power: Int,
    val accuracy: Int,
    val pp: Int,
    val target: MoveTarget,
    val isDirect: Boolean,
    val canProtect: Boolean,
    val magicCoat: Boolean,
    val snatch: Boolean,
    val mirrorMove: Boolean,
    val substitute: Boolean,
    val description: String,
) {
    companion object {
        private const val JSON_KEY_MOVE_ID = "move_id"
        private const val JSON_KEY_NAME = "name"
        private const val JSON_KEY_MOVE_TYPE = "move_type"
        private const val JSON_KEY_CATEGORY = "category"
        private const val JSON_KEY_POWER = "power"
        private const val JSON_KEY_ACCURACY = "accuracy"
        private const val JSON_KEY_PP = "pp"
        private const val JSON_KEY_TARGET = "target"
        private const val JSON_KEY_IS_DIRECT = "is_direct"
        private const val JSON_KEY_CAN_PROTECT = "can_protect"
        private const val JSON_KEY_MAGIC_COAT = "magic_coat"
        private const val JSON_KEY_SNATCH = "snatch"
        private const val JSON_KEY_MIRROR_MOVE = "mirror_move"
        private const val JSON_KEY_SUBSTITUTE = "substitute"
        private const val JSON_KEY_DESCRIPTION = "description"
        fun fromJson(jsonObject: JSONObject): Move {
            return Move(
                moveId = jsonObject.getInt(JSON_KEY_MOVE_ID),
                name = jsonObject.getString(JSON_KEY_NAME),
                moveType = Type.fromValue(jsonObject.getInt(JSON_KEY_MOVE_TYPE)),
                category = MoveCategory.fromValue(jsonObject.getInt(JSON_KEY_CATEGORY)),
                power = jsonObject.getInt(JSON_KEY_POWER),
                accuracy = jsonObject.getInt(JSON_KEY_ACCURACY),
                pp = jsonObject.getInt(JSON_KEY_PP),
                target = MoveTarget.fromValue(jsonObject.getInt(JSON_KEY_TARGET)),
                isDirect = jsonObject.getBoolean(JSON_KEY_IS_DIRECT),
                canProtect = jsonObject.getBoolean(JSON_KEY_CAN_PROTECT),
                magicCoat = jsonObject.getBoolean(JSON_KEY_MAGIC_COAT),
                snatch = jsonObject.getBoolean(JSON_KEY_SNATCH),
                mirrorMove = jsonObject.getBoolean(JSON_KEY_MIRROR_MOVE),
                substitute = jsonObject.getBoolean(JSON_KEY_SUBSTITUTE),
                description = jsonObject.getString(JSON_KEY_DESCRIPTION),
            )
        }
    }
}
