package com.drkryz.nowaste.ui.components.main_activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.drkryz.nowaste.R

@Composable
fun AppCategory() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .clip(
                RoundedCornerShape(10.dp)
            )
            .background(MaterialTheme.colorScheme.background)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.presentation_adicione_s_receita2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(90.dp)
                .height(90.dp)
                .clip(
                    RoundedCornerShape(5.dp)
                )
        )
        Text(
            text = "Cat.Name",
            Modifier.padding(top = 5.dp)
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