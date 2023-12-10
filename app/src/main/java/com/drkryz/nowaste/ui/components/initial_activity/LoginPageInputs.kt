package com.drkryz.nowaste.ui.components.initial_activity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPageInputs() {
    var userMail by remember { mutableStateOf(String()) }
    var userPassword by remember { mutableStateOf(String()) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        value = userMail,
        onValueChange = {
            userMail = it
        }, label = {
            Text(text = "Digite seu email")
        }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp),
        horizontalAlignment = Alignment.End
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            value = userPassword,
            onValueChange = {
                userPassword = it
            }, label = {
                Text(text = "Digite sua senha")
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Text(text = "Esqueci minha senha", Modifier.padding(end = 10.dp))

    }
}