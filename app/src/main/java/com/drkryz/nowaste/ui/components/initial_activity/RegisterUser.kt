@file:OptIn(ExperimentalMaterial3Api::class)

package com.drkryz.nowaste.ui.components.initial_activity

import android.app.Activity
import android.service.autofill.DateTransformation
import android.util.AttributeSet
import android.view.View
import android.view.autofill.AutofillId
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.drkryz.nowaste.R
import com.drkryz.nowaste.RegisterSections
import com.drkryz.nowaste.ui.components.global.DefaultButton

@Composable
fun RegisterUser(nav: NavController) {
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
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        shape = RoundedCornerShape(topStart = 25f, topEnd = 25f),
                        color = MaterialTheme.colorScheme.background
                    )
                    .padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 50.dp)
            ) {
                Column {

                    Text(
                        text = "Precisamos saber um pouco sobre você....",
                        fontSize = TextUnit(25f, TextUnitType.Sp),
                        modifier = Modifier.padding(10.dp)
                    )

                    Text(
                        text = "Seu nome será utilizado para que pessoas o busquem e se conectem com facilidade",
                        fontSize = TextUnit(15f, TextUnitType.Sp),
                        modifier = Modifier.padding(10.dp)
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp, top = 8.dp),
                        value = userMail,
                        onValueChange = {
                            userMail = it
                        },
                        label = {
                            Text(text = "Digite seu nome")
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
                            Text(text = "Digite seu segundo nome")
                        },
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
                            Text(text = "Data de nascimento")
                        },
                    )
                }

                Column {
                    DefaultButton(
                        inner_text = "PROXIMO",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        onclick = {
                            nav.navigate(RegisterSections.RegisterPage_UserAddress.route)
                        }
                    )
                }
            }
        }
    }
}