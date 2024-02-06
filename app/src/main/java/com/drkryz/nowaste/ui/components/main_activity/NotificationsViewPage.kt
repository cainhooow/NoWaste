package com.drkryz.nowaste.ui.components.main_activity

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
            .fillMaxWidth()
            .background(androidx.compose.material3.MaterialTheme.colorScheme.surface)
            .padding(10.dp, 0.dp, 10.dp, 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
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
            modifier = Modifier
                .weight(1f)
                .padding(start = 30.dp),
            color = if (!isSystemInDarkTheme()) MaterialTheme.colors.onBackground
            else MaterialTheme.colors.onPrimary,
            fontSize = TextUnit(20f, TextUnitType.Sp)
        )
    }
}

@Composable
fun Notification() {
    Column(
        Modifier
            .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 5.dp)
            .background(
                color = androidx.compose.material3.MaterialTheme.colorScheme.inverseOnSurface.copy(
                    0.2f
                ), shape = RoundedCornerShape(10.dp)
            )
            .border(
                BorderStroke(
                    1.dp,
                    androidx.compose.material3.MaterialTheme.colorScheme.onSurface.copy(0.1f)
                ), shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                /* TODO */
            }
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.presentation_nowaste),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(100.dp)
                    )
                    .width(51.dp)
                    .height(51.dp)
            )

            Column(
                Modifier.padding(start = 10.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "User.name",
                        color = if (!isSystemInDarkTheme()) MaterialTheme.colors.onBackground
                        else MaterialTheme.colors.onPrimary,
                        fontSize = TextUnit(18f, TextUnitType.Sp),
                    )

                    Text(
                        text = "2 minutos atrás",
                        color = if (!isSystemInDarkTheme()) MaterialTheme.colors.onBackground
                        else MaterialTheme.colors.onPrimary.copy(0.4f),
                        fontSize = TextUnit(13.4f, TextUnitType.Sp)
                    )
                }

                Text(
                    text = "User.user comentou na sua publicação",
                    color = if (!isSystemInDarkTheme()) MaterialTheme.colors.onBackground
                    else MaterialTheme.colors.onPrimary.copy(0.4f),
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotificationsViewPage(navController: NavController) {
    LazyColumn()
    {
        stickyHeader { NotificationHeader(navController) }
        items(10) {
            Notification()
        }
    }
}