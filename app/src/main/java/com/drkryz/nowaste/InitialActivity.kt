package com.drkryz.nowaste

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.drkryz.nowaste.ui.components.initial_activity.LoginPage
import com.drkryz.nowaste.ui.components.initial_activity.RegisterAddresses
import com.drkryz.nowaste.ui.components.initial_activity.RegisterPage
import com.drkryz.nowaste.ui.components.initial_activity.RegisterUser
import com.drkryz.nowaste.ui.components.initial_activity.WelcomePage
import com.drkryz.nowaste.ui.theme.NoWasteTheme

class InitialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setContent {
            NoWasteTheme {
                Surface(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                        .imePadding()
                ) {
                    Presentation()
                }
            }
        }
    }
}


sealed class LoginSections(val route: String) {
    object WelcomePage : LoginSections("welcome")
    object LoginPage : LoginSections("login")
}

sealed class RegisterSections(val route: String) {
    object RegisterPage : RegisterSections("register")
    object RegisterPage_UserInfo : RegisterSections("register_UserInfo")
    object RegisterPage_UserAddress : RegisterSections("register_UserAddress")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Presentation() {
    val navController = rememberNavController();

    Scaffold { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = LoginSections.WelcomePage.route
        ) {
            composable(LoginSections.WelcomePage.route) {
                WelcomePage(navController)
            }
            composable(LoginSections.LoginPage.route) {
                LoginPage(navController)
            }
            composable(RegisterSections.RegisterPage.route) {
                RegisterPage(navController)
            }
            composable(RegisterSections.RegisterPage_UserInfo.route) {
                RegisterUser(navController)
            }
            composable(RegisterSections.RegisterPage_UserAddress.route) {
                RegisterAddresses(navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    NoWasteTheme {
        Presentation()
    }
}