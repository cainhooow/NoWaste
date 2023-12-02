package com.drkryz.nowaste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.drkryz.nowaste.ui.components.main.AppCategories
import com.drkryz.nowaste.ui.components.main.AppHighlightHeader
import com.drkryz.nowaste.ui.components.main.AppHighlights
import com.drkryz.nowaste.ui.components.main.BannersNews
import com.drkryz.nowaste.ui.components.main.SearchBar
import com.drkryz.nowaste.ui.theme.NoWasteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoWasteTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    HomeUI()
                }
            }
        }
    }
}

sealed class AppScreens(val route: String, @DrawableRes val resourceId: Int) {
    object HomePage: AppScreens("home", R.drawable.round_home_24)
    object ShopPage: AppScreens("shop", R.drawable.round_shopbag_24)
    object BooksMark: AppScreens("bookmarks", R.drawable.round_bookmark_24)
    object Account: AppScreens("account", R.drawable.outline_account_circle_24)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeUI() {

    val navController = rememberNavController();

    val items = listOf(
        AppScreens.HomePage,
        AppScreens.ShopPage,
        AppScreens.BooksMark,
        AppScreens.Account
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colorScheme.background
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                                  navController.navigate(screen.route) {
                                      popUpTo(navController.graph.findStartDestination().id) {
                                          saveState = true
                                      }

                                      launchSingleTop = true
                                      restoreState = true
                                  }
                        },
                        icon = { Icon(painter = painterResource(id = screen.resourceId), contentDescription = null)
                        },
                        enabled = true,
                        selectedContentColor = MaterialTheme.colorScheme.primary,
                        unselectedContentColor = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(modifier = Modifier.padding(
            top = 0.dp,
            bottom = innerPadding.calculateBottomPadding()
        ), navController = navController, startDestination = "home") {
            composable(AppScreens.HomePage.route) {
                HomeScreen()
            }
            composable(AppScreens.ShopPage.route) {
                HomeScreen()
            }
            composable(AppScreens.BooksMark.route) {
                HomeScreen()
            }
            composable(AppScreens.Account.route) {
                HomeScreen()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    // column list
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        // app header
        stickyHeader {
            StickyHeader()
        }
        // app searchable button "open new activity search"
        item {
            SearchBar()
        }
        // app banners news highlights
        item {
            BannersNews()
        }
        // app categories
        item {
            AppCategories()
        }
        // app highlight header style
        item {
            AppHighlightHeader()
        }
        // app user highlights
        items(5) {
            AppHighlights()
        }
    }
}

@Composable
fun StickyHeader() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(10.dp, 0.dp, 10.dp, 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ) {
        // user info
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
        // app name
        Box {
            Text(
                text = "NO WASTE",
                textAlign = TextAlign.Center
            )
        }

        // box for cart icon and card items
        Box {
            Icon(
                painter = painterResource(id = R.drawable.cart_24),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoWasteTheme {
        HomeUI()
    }
}