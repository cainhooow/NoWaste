package com.drkryz.nowaste.ui.components.initial_activity

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.drkryz.nowaste.MainActivity
import com.drkryz.nowaste.R
import com.drkryz.nowaste.ui.components.global.DefaultButton

@Composable
fun LoginPageActions() {
    val initialActivityCtx = LocalContext.current as Activity;

    DefaultButton(
        inner_text = "PROXIMO",
        modifier = Modifier.fillMaxWidth(),
        onclick = {
            initialActivityCtx.finish()
            initialActivityCtx.startActivity(Intent(initialActivityCtx, MainActivity::class.java))
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
