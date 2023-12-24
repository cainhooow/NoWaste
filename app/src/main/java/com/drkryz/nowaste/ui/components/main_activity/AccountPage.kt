package com.drkryz.nowaste.ui.components.main_activity

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.drkryz.nowaste.HomeUI
import com.drkryz.nowaste.R
import com.drkryz.nowaste.ui.theme.NoWasteTheme

@Composable
fun AccountPage() {
    val configs = listOf(
        "MEUS DADOS",
        "CONFIGURAÇÕES DA CONTA",
        "CONFIGURAÇÕES DE PRIVACIDADE",
        "CONFIGURAÇÕES DE NOTIFICAÇÕES"
    )

    Column(
        Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.presentation_adicione_s_receita),
                contentDescription = null,
                modifier =
                Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .width(150.dp)
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Ada Heller",
                fontSize = TextUnit(30f, TextUnitType.Sp),
                modifier = Modifier.padding(top = 20.dp)
            )
        }


        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 10.dp, end = 10.dp)
        ) {
            itemsIndexed(configs) { index, item ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(5.dp))
                        .clickable {
                        }
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = item, fontSize = TextUnit(12.5f, TextUnitType.Sp))
                    Icon(painter = painterResource(id = R.drawable.arrow_forward_ios_24), contentDescription = null)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountsPagePreview() {
    NoWasteTheme {
        HomeUI()
    }
}