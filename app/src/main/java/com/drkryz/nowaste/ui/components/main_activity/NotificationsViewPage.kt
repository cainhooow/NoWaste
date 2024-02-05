package com.drkryz.nowaste.ui.components.main_activity

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.drkryz.nowaste.AppScreens
import com.drkryz.nowaste.R

@Composable
fun NotificationHeader(navController: NavController) {
    Row(
        Modifier
            .padding(top = 15.dp, start = 20.dp, end = 30.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp, 0.dp),
            shape = RoundedCornerShape(100.dp),
            border = BorderStroke(
                1.dp, if (!isSystemInDarkTheme()) MaterialTheme.colors.onBackground.copy(0.1f)
                else MaterialTheme.colors.onPrimary.copy(0.1f)
            ),
            onClick = {
                navController.navigate(AppScreens.HomePage.route)
            }) {
            Row {
                Icon(
                    modifier = Modifier.padding(end = 10.dp),
                    painter = painterResource(id = R.drawable.round_arrow_back_ios_24),
                    contentDescription = null,
                    tint = if (!isSystemInDarkTheme()) MaterialTheme.colors.onBackground
                    else MaterialTheme.colors.onPrimary
                )

                Text(
                    text = "Voltar",
                    color = if (!isSystemInDarkTheme()) MaterialTheme.colors.onBackground
                    else MaterialTheme.colors.onPrimary,
                    fontSize = TextUnit(17f, TextUnitType.Sp)
                )
            }
        }

        Text(
            text = "Notificações",
            color = if (!isSystemInDarkTheme()) MaterialTheme.colors.onBackground
            else MaterialTheme.colors.onPrimary,
            fontSize = TextUnit(20f, TextUnitType.Sp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotificationsViewPage(navController: NavController) {
    LazyColumn()
    {
        stickyHeader { NotificationHeader(navController) }

        items(10) {

        }
    }
}