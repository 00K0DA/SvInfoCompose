package com.oukoda.svinfocompose.view.component.description

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oukoda.svinfocompose.R
import com.oukoda.svinfocompose.model.dataclass.Ability

@Composable
fun AbilitiesView(
    ability1st: Ability,
    ability2nd: Ability,
    hiddenAbility: Ability,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier, elevation = 4.dp) {
        Column(
            modifier = Modifier.padding(all = 8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            AbilityView(abilityLabelId = R.string.description_ability_1st, ability = ability1st)
            if (ability1st.abilityId != ability2nd.abilityId) {
                AbilityView(abilityLabelId = R.string.description_ability_2nd, ability = ability2nd)
            }
            AbilityView(
                abilityLabelId = R.string.description_ability_hidden,
                ability = hiddenAbility,
            )
        }
    }
}

@Composable
private fun AbilityView(abilityLabelId: Int, ability: Ability, modifier: Modifier = Modifier) {
    var isExpand by remember { mutableStateOf(false) }
    Column(
        modifier = modifier.clickable { isExpand = !isExpand },
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.width(60.dp),
                text = stringResource(id = abilityLabelId),
                fontSize = 14.sp,
            )
            Text(text = ability.name, fontSize = 20.sp)
        }
        AnimatedVisibility(visible = isExpand) {
            Text(text = ability.description, fontSize = 12.sp)
        }
    }
}
