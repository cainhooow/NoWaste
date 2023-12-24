package com.drkryz.nowaste.ui.components.initial_activity

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.drkryz.nowaste.MainActivity
import com.drkryz.nowaste.R
import com.drkryz.nowaste.RegisterSections
import com.drkryz.nowaste.ui.components.global.DefaultButton

@ExperimentalMaterial3Api
@Composable
fun RegisterPage(nav: NavController) {
    var userMail by remember { mutableStateOf(String()) }
    var userPassword by remember { mutableStateOf(String()) }
    val initialActivityCtx = LocalContext.current as Activity;

    Box(
        Modifier
            .fillMaxSize()
            .imePadding()
    ) {
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
                            MaterialTheme.colorScheme.surface,
                            Color.Transparent,
                            MaterialTheme.colorScheme.background,
                        )
                    )
                ),
            verticalArrangement = Arrangement.Bottom
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(
                        shape = RoundedCornerShape(topStart = 25f, topEnd = 25f),
                        color = MaterialTheme.colorScheme.background
                    )
                    .padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 50.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    value = userMail,
                    onValueChange = {
                        userMail = it
                    },
                    label = {
                        Text(text = "Digite seu email")
                    }
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    value = userMail,
                    onValueChange = {
                        userMail = it
                    },
                    label = {
                        Text(text = "Digite sua senha")
                    },
                    visualTransformation = PasswordVisualTransformation()
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    value = userMail,
                    onValueChange = {
                        userMail = it
                    },
                    label = {
                        Text(text = "Repita a senha")
                    },
                    visualTransformation = PasswordVisualTransformation()
                )


                DefaultButton(
                    inner_text = "PROXIMO",
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 10.dp),
                    onclick = {
                        nav.navigate(RegisterSections.RegisterPage_UserInfo.route)
                    }
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp, bottom = 30.dp),
                    textAlign = TextAlign.Center,
                    text = "OUTRAS FORMAS"
                )

                DefaultButton(
                    inner_text = "GOOGLE",
                    modifier = Modifier.fillMaxWidth(),
                    onclick = {}
                )

                DefaultButton(
                    inner_text = "FACEBOOK",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    onclick = {}
                )
            }
        }
    }
}