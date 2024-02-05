package com.drkryz.nowaste.ui.components.main_activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.drkryz.nowaste.AppScreens
import com.drkryz.nowaste.R

@Composable
fun StickyHeader(navController: NavController) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(10.dp, 0.dp, 10.dp, 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // user info
        ITUserinfo()
        // app name
        ITAppName()
        // app tabs
        ITAppTabs(navController)
    }
}

@Composable
fun ITUserinfo() {
    Column {
        // app default text
        Text(
            text = "Olá",
            fontWeight = FontWeight.Light
        )
        // app user text split
        Text(
            text = "Ada Heller",
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun ITAppName() {
    Box {
        Text(
            text = "NO WASTE",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ITAppTabs(navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 4.dp)
    ) {
        // box for notification icon and notifications
        ITabsNotifications(navController)
        // box for cart icon and card items
        ITabsCart()
    }
}

@Composable
fun ITabsNotifications(navController: NavController) {
    Box(
        contentAlignment = Alignment.TopEnd,
    ) {
        IconButton(onClick = {
            navController.navigate(AppScreens.NotificationsViewPage.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
            }
        }) {
            Icon(
                painter = painterResource(id = R.drawable.outline_notification_24),
                contentDescription = null,
            )
        }
        Text(
            text = "99+",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.background,
            fontSize = TextUnit(10f, TextUnitType.Sp),
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(100.dp)
                )
                .widthIn(16.dp, 25.dp)
                .requiredHeight(16.dp)
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(1.dp)
        )
    }
}

@Composable
fun ITabsCart() {
    Box(
        contentAlignment = Alignment.TopEnd
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.outline_round_cart_24),
                contentDescription = null,
            )
        }
        Text(
            text = "5",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.background,
            fontSize = TextUnit(10f, TextUnitType.Sp),
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(100.dp)
                )
                .widthIn(16.dp, 25.dp)
                .requiredHeight(16.dp)
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(1.dp)
        )
    }
}
