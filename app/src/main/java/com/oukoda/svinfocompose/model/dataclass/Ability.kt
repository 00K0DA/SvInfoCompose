package com.oukoda.svinfocompose.model.dataclass

import org.json.JSONObject

data class Ability(
    val abilityId: Int,
    val name: String,
    val description: String,
) {
    companion object {
        private const val JSON_KEY_ABILITY_ID = "ability_id"
        private const val JSON_KEY_NAME = "name"
        private const val JSON_KEY_DESCRIPTION = "description"

        fun fromJson(jsonObject: JSONObject): Ability {
            return Ability(
                abilityId = jsonObject.getInt(JSON_KEY_ABILITY_ID),
                name = jsonObject.getString(JSON_KEY_NAME),
                description = jsonObject.getString(JSON_KEY_DESCRIPTION),
            )
        }
    }
}
