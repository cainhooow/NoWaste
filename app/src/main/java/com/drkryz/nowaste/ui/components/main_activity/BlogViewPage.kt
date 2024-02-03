package com.drkryz.nowaste.ui.components.main_activity

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.dynamicanimation.animation.FlingAnimation
import com.drkryz.nowaste.R

@Composable
fun BlogViewPage() {
    val scrollableState = rememberScrollState();
    var lastScrollPosition by remember { mutableStateOf(0) }
    var topMetaVisible by remember {
        mutableStateOf(true)
    };

    Column {
        AnimatedVisibility(visible = topMetaVisible) {
            Box(
                Modifier
                    .imePadding()
                    .height(250.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.presentation_nowaste),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }

            Column(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                MaterialTheme.colorScheme.surface, Color.Transparent, Color.Transparent,
                            )
                        )
                    ),
                verticalArrangement = Arrangement.SpaceBetween
            ) {}
        }

        if (scrollableState.isScrollInProgress) {
            if (scrollableState.value > 10) {
                topMetaVisible = false;
            } else if (scrollableState.value < 10) {
                topMetaVisible = true;
            }
        }

        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(scrollableState)
                .padding(start = 15.dp, end = 15.dp, top = if (topMetaVisible) { 10.dp } else { 45.dp }, bottom = 65.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .apply {
                        if (!topMetaVisible) {
                            padding(top = 20.dp)
                        }
                    }
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                MaterialTheme.colorScheme.surface,
                                Color.Transparent,
                            )
                        )
                    ),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                        .background(
                            MaterialTheme.colorScheme.onSurface.copy(0.2f),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .border(
                            border = BorderStroke(
                                1.dp,
                                MaterialTheme.colorScheme.onBackground.copy(0.5f)
                            ), shape = RoundedCornerShape(5.dp)
                        )
                        .padding(start = 8.dp, top = 5.dp, bottom = 5.dp, end = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.presentation_adicione_s_receita),
                        contentDescription = null,
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .width(51.dp)
                            .height(51.dp),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "User.name",
                            fontSize = TextUnit(18f, TextUnitType.Sp),
                            modifier = Modifier.padding(start = 10.dp),
                            color = if (!isSystemInDarkTheme()) MaterialTheme.colorScheme.onBackground
                            else MaterialTheme.colorScheme.onSurface
                        )

                        Text(
                            text = "3 minutos atrás",
                            fontSize = TextUnit(13f, TextUnitType.Sp),
                            modifier = Modifier.padding(start = 10.dp),
                            color = if (!isSystemInDarkTheme()) MaterialTheme.colorScheme.onBackground
                            else MaterialTheme.colorScheme.onSurface.copy(0.4f)
                        )
                    }
                }

            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                text = "Banana doce com chocolate",
                fontSize = TextUnit(25f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(top = 30.dp), text = "Where does it come from?\n" +
                        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                        "\n" +
                        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham. Where does it come from?\n" +
                        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                        "\n" +
                        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham. Where does it come from?\n" +
                        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                        "\n" +
                        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham."
            )
        }


    }
};