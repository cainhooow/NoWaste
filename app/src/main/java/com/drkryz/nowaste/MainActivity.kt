package com.drkryz.nowaste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drkryz.nowaste.ui.theme.NoWasteTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoWasteTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    HomeUI()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeUI() {
    // column list
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        // app header
        stickyHeader {
            StickyHeader()
        }
        // app searchable button "open new activity search"
        item {
            SearchBar()
        }
        // app banners news highlights
        item {
            BannersUpdate()
        }
        // app categories
        item {
            AppCategories()
        }
        // app highlight header style
        item {
            AppHighlightHeader()
        }
        // app user highlights
        items(5) {
            AppHighlights()
        }
    }
}

@Composable
fun StickyHeader() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(10.dp, 0.dp, 10.dp, 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ) {
        // user info
        Column {
            // app default text
            Text(
                text = "Olá",
                fontWeight = FontWeight.Light
            )
            // app user text split
            Text(
                text = "Ada Heller",
                fontWeight = FontWeight.Bold
            )
        }
        // app name
        Text(text = "NO WASTE",
            Modifier.width(100.dp)
            )
        // box for cart icon and card items
        Box {
            Icon(
                painter = painterResource(id = R.drawable.cart_24),
                contentDescription = null
            )
        }
    }
}

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
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(5.dp)
                )
                .background(MaterialTheme.colorScheme.background)
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.procurar),
                contentDescription = null,
                Modifier
                    .width(48.dp)
                    .height(28.dp)
                    .padding(end = 28.dp)

            )
            Text(text = "Carnes congeladas")
        }
    }
}

@Composable
fun BannersUpdate() {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.presentation_adicione_s_receita),
            contentDescription = null,
            Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(10.dp)
                )
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
fun AppHighlightHeader() {
    Box(
        Modifier
            .padding(top = 20.dp, start = 25.dp)
            .clip(
                RoundedCornerShape(
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
        Text(text = "Destaques")
    }
}

@Composable
fun AppHighlights() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp)
    ) {
        AppHighlight()
    }
}

@Composable
fun AppHighlight() {
    Column(
        Modifier
            .padding(top = 15.dp, bottom = 15.dp)
            .fillMaxWidth()
    ) {
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

            Text(
                text = "User.name",
                Modifier.padding(start = 10.dp)
                )
        }

        Column(
            Modifier
                .padding(top = 15.dp)
        ) {
            Text(text = "Bolo de chocolate com morango")
            Text(text = "Ingredientes para o bolo:\n" +
                    "\n" +
                    "2 xícaras de farinha de trigo\n" +
                    "1 xícara de cacau em pó\n" +
                    "2 xícaras de açúcar\n" +
                    "2 colheres de chá de fermento em pó\n" +
                    "1 colher de chá de bicarbonato de sódio\n" +
                    "1 colher de chá de sal\n.....")

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
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoWasteTheme {
        HomeUI()
    }
}