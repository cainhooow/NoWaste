package com.drkryz.nowaste

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                Surface(modifier = Modifier.fillMaxSize()) {
                    WelcomeUI()
                }
            }
        }
    }
}

@Composable
fun Presentation() {
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
            modifier = Modifier.fillMaxSize()
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

            Actions()
        }
    }
}

@Composable
fun Actions() {
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
            .padding(start = 15.dp, end = 15.dp, bottom = 20.dp, top = 250.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape =  RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text(text = "LOGIN", color = MaterialTheme.colorScheme.onPrimary)
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape =  RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)

        ) {
            Text(text = "REGISTRAR",  color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}

@Composable
fun WelcomeUI() {
    Presentation()
}

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    NoWasteTheme {
        WelcomeUI()
    }
}