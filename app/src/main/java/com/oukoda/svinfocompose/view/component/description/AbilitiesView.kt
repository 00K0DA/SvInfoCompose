package com.oukoda.svinfocompose.view.component.description

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oukoda.svinfocompose.R
import com.oukoda.svinfocompose.model.dataclass.Ability
import com.oukoda.svinfocompose.view.component.common.ExpandView

@Composable
fun AbilitiesView(
    ability1st: Ability,
    ability2nd: Ability,
    hiddenAbility: Ability,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier, elevation = 4.dp) {
        Column(
            modifier = Modifier.padding(all = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                stringResource(id = R.string.description_ability_title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )

            if (ability1st.abilityId == ability2nd.abilityId && ability1st.abilityId == hiddenAbility.abilityId) {
                AbilityView(
                    ability = ability1st,
                    isHiddenAbility = false,
                )
            } else if (ability1st.abilityId == ability2nd.abilityId) {
                AbilityView(
                    ability = ability1st,
                    isHiddenAbility = false,
                )
                AbilityView(
                    ability = hiddenAbility,
                    isHiddenAbility = true,
                )
            } else {
                AbilityView(
                    ability = ability1st,
                    isHiddenAbility = false,
                    abilityNumber = 1,
                )
                AbilityView(
                    ability = ability2nd,
                    isHiddenAbility = false,
                    abilityNumber = 2,
                )
                AbilityView(
                    ability = hiddenAbility,
                    isHiddenAbility = true,
                )
            }
        }
    }
}

@Composable
private fun AbilityView(
    ability: Ability,
    isHiddenAbility: Boolean,
    modifier: Modifier = Modifier,
    abilityNumber: Int? = null,
) {
    var isExpand by remember { mutableStateOf(false) }

    val abilityLabelId =
        if (isHiddenAbility) {
            R.string.description_ability_hidden
        } else {
            R.string.description_ability_normal
        }
    var abilityLabelString = stringResource(id = abilityLabelId)
    abilityNumber?.let {
        abilityLabelString += it
    }

    Column(
        modifier = modifier.clickable { isExpand = !isExpand },
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.width(68.dp),
                text = abilityLabelString,
                fontSize = 14.sp,
            )
            Text(text = ability.name, fontSize = 20.sp)
            Spacer(
                modifier = Modifier
                    .weight(1f, false)
                    .fillMaxWidth(),
            )
            ExpandView(isExpand = isExpand, Modifier.size(24.dp))
        }
        AnimatedVisibility(visible = isExpand) {
            Text(text = ability.description, fontSize = 12.sp)
        }
    }
}
