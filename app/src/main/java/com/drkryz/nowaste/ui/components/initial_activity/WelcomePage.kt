package com.drkryz.nowaste.ui.components.initial_activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.drkryz.nowaste.Presentation
import com.drkryz.nowaste.R
import com.drkryz.nowaste.ui.components.global.DefaultButton
import com.drkryz.nowaste.ui.theme.NoWasteTheme

@Composable
fun WelcomePage(nav: NavController) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.presentation_nowaste),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .blur(20.dp),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.surface, Color.Transparent, Color.Transparent,
                        )
                    )
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(top = 150.dp, start = 20.dp, end = 20.dp)
            ) {
                Text(
                    text = "Olá",
                    textAlign = TextAlign.Center,
                    fontSize = TextUnit(60f, TextUnitType.Sp),
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "Prepare-se para uma jornada de sabor e sustentabilidade! Bem-vindo ao nosso app que resgata alimentos e evita o desperdício.",
                    textAlign = TextAlign.Center,
                    fontSize = TextUnit(20f, TextUnitType.Sp),
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Actions(nav)
        }
    }
}

@Composable
fun Actions(nav: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Transparent, MaterialTheme.colorScheme.background
                    )
                )
            )
            .padding(start = 15.dp, end = 15.dp, bottom = 20.dp, top = 250.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultButton(
            inner_text = "LOGIN",
            onclick = {
                nav.navigate("login")
            },
            modifier = Modifier.padding(10.dp)
        )
        DefaultButton(
            inner_text = "REGISTRAR",
            onclick = {
                nav.navigate("register")
            },
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePage() {
    val nav = rememberNavController()

    NoWasteTheme {
        WelcomePage(nav = nav)
    }
}
