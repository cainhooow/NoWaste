package com.drkryz.nowaste.ui.components.main_activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.drkryz.nowaste.R

@Composable
fun AppCategory() {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .width(100.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.BottomStart
    ) {
        // Imagem
        Image(
            painter = painterResource(id = R.drawable.presentation_adicione_s_receita2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )

        // Gradiente
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(listOf(Color.Transparent, Color.Black)),
                    shape = RoundedCornerShape(5.dp)
                )
        )

        // Texto
        Text(
            text = "Cat.Name",
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.BottomStart),
            color = Color.White // Cor do texto
        )
    }
}

@Composable
fun AppCategories() {
    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 28.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(4) {
            AppCategory()
        }
    }
}