package com.drkryz.nowaste.ui.components.main_activity

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.drkryz.nowaste.HomeUI
import com.drkryz.nowaste.MainActivity
import com.drkryz.nowaste.R
import com.drkryz.nowaste.ui.components.global.DefaultButton
import com.drkryz.nowaste.ui.theme.Light_background_color
import com.drkryz.nowaste.ui.theme.NoWasteTheme

@Composable
fun AppHighlightHeader() {
    Box(
        Modifier
            .padding(top = 20.dp, start = 25.dp)
            .background(
                color = if (!isSystemInDarkTheme()) Light_background_color
                else MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(
                    topStartPercent = 40,
                    topEndPercent = 40,
                    bottomStartPercent = 0,
                    bottomEndPercent = 0
                )
            )
            // .background(MaterialTheme.colorScheme.onBackground)
            .padding(
                start = 8.dp,
                end = 8.dp
            )
    ) {
        Text(
            text = "Destaques",
            color = if (!isSystemInDarkTheme()) MaterialTheme.colorScheme.onBackground
            else MaterialTheme.colorScheme.background
        )
    }
}

@Composable
fun AppHighlights(enableBuy: Boolean, click: () -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
    ) {
        AppCardPost(enableBuy, click)
    }
}

@Composable
fun AppCardPost(enableBuy: Boolean, click: () -> Unit) {
    Column(
        Modifier
            .padding(bottom = 30.dp)
            .background(
                color = if (!isSystemInDarkTheme()) Light_background_color
                else MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)
            .fillMaxWidth()
            .clickable { click.invoke() }
    ) {
        CardMeta()
        if (enableBuy) {
            CardBody() {
                Button(
                    onClick = {},
                    modifier = Modifier.padding(top = 18.dp),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                    )
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.addtocart_rounded_24),
                            contentDescription = null
                        )
                        Text(
                            text = "ADICIONAR AO CARRINHO",
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }

            }
        } else CardBody() {}
    }
}

@Composable
fun CardMeta() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.presentation_adicione_s_receita),
            contentDescription = null,
            modifier =
            Modifier
                .clip(RoundedCornerShape(50.dp))
                .width(61.dp)
                .height(61.dp),
            contentScale = ContentScale.Crop
        )

        Column {
            Text(
                text = "User.name",
                fontSize = TextUnit(18f, TextUnitType.Sp),
                modifier = Modifier.padding(start = 10.dp),
                color = if (!isSystemInDarkTheme()) MaterialTheme.colorScheme.onBackground
                else MaterialTheme.colorScheme.background
            )

            Text(
                text = "3 minutos atrás",
                fontSize = TextUnit(13f, TextUnitType.Sp),
                modifier = Modifier.padding(start = 10.dp),
                color = if (!isSystemInDarkTheme()) MaterialTheme.colorScheme.onBackground
                else MaterialTheme.colorScheme.background
            )
        }
    }
}

@Composable
fun CardBody(content: @Composable() (ColumnScope.() -> Unit)?) {
    Column(
        Modifier
            .padding(top = 15.dp)
    ) {
        Column(
            Modifier
                .padding(start = 10.dp)
        ) {
            Text(
                text = "Bolo de chocolate com morango",
                color = if (!isSystemInDarkTheme()) MaterialTheme.colorScheme.onBackground
                else MaterialTheme.colorScheme.background
            )
            Text(
                text = "Ingredientes para o bolo:\n" +
                        "\n" +
                        "2 xícaras de farinha de trigo\n" +
                        "1 xícara de cacau em pó\n" +
                        "2 xícaras de açúcar\n" +
                        "2 colheres de chá de fermento em pó\n" +
                        "1 colher de chá de bicarbonato de sódio\n" +
                        "1 colher de chá de sal\n.....",
                color = if (!isSystemInDarkTheme()) MaterialTheme.colorScheme.onBackground
                else MaterialTheme.colorScheme.background
            )
        }

        Image(
            painter = painterResource(id = R.drawable.presentation_adicione_s_receita),
            contentDescription = null,
            Modifier
                .padding(top = 15.dp)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(10.dp)
                )
        )

        if (content !== null) {
            content.invoke(this)
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