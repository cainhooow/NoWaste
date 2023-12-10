package com.drkryz.nowaste

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.drkryz.nowaste.ui.components.initial_activity.LoginPage
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
                Surface(modifier = Modifier.background(MaterialTheme.colorScheme.background)
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
                WelcomePage(navController)
            }
            composable(RegisterSections.RegisterPage_UserInfo.route) {
                WelcomePage(navController)
            }
            composable(RegisterSections.RegisterPage_UserAddress.route) {
                WelcomePage(navController)
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