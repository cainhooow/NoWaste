package com.drkryz.nowaste.ui.components.global

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.drkryz.nowaste.AppScreens
import com.drkryz.nowaste.R

@Composable
fun IconButton(resId: Int, text: String, onClick: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp),
        shape = RoundedCornerShape(100.dp),
        border = BorderStroke(
            1.dp, if (!isSystemInDarkTheme()) MaterialTheme.colors.onBackground.copy(0.1f)
            else MaterialTheme.colors.onPrimary.copy(0.1f)
        ),
        onClick = {
            onClick.invoke();
        }) {
        Row {
            Icon(
                modifier = Modifier.padding(end = 10.dp),
                painter = painterResource(id = resId),
                contentDescription = null,
                tint = if (!isSystemInDarkTheme()) MaterialTheme.colors.onBackground
                else MaterialTheme.colors.onPrimary
            )

            Text(
                text = text,
                color = if (!isSystemInDarkTheme()) MaterialTheme.colors.onBackground
                else MaterialTheme.colors.onPrimary,
                fontSize = TextUnit(17f, TextUnitType.Sp)
            )
        }
    }
}