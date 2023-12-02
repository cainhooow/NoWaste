package com.drkryz.nowaste.ui.components.main

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.drkryz.nowaste.R
import com.drkryz.nowaste.ui.theme.Searchbar_Light_color

@Composable
fun SearchBar() {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .background(
                    color = if (!isSystemInDarkTheme()) Searchbar_Light_color else MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.procurar),
                contentDescription = null,
                Modifier
                    .width(48.dp)
                    .height(28.dp)
                    .padding(end = 28.dp),
                tint =  if (!isSystemInDarkTheme()) MaterialTheme.colorScheme.onBackground
                else MaterialTheme.colorScheme.background
            )
            Text(
                text = "Carnes congeladas",
                color = if (!isSystemInDarkTheme()) MaterialTheme.colorScheme.onBackground
                else MaterialTheme.colorScheme.background
            )
        }
    }
}
