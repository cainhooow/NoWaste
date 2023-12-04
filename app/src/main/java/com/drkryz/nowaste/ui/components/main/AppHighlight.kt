package com.drkryz.nowaste.ui.components.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.drkryz.nowaste.HomeUI
import com.drkryz.nowaste.R
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
fun AppHighlights() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
    ) {
        AppCardPost()
    }
}


@Composable
fun AppCardPost() {
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
    ) {
        CardMeta()
        CardBody()
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
fun CardBody() {
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
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoWasteTheme {
        HomeUI()
    }
}