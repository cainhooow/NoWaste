package com.drkryz.nowaste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.drkryz.nowaste.ui.components.main.AppHighlightHeader
import com.drkryz.nowaste.ui.components.main.AppHighlights
import com.drkryz.nowaste.ui.theme.Searchbar_Light_color
import com.drkryz.nowaste.ui.theme.NoWasteTheme
import com.drkryz.nowaste.ui.theme.Searchbar_dark_color
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

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
                fontWeight = FontWeight.Bold,
            )
        }
        // app name
        Box {
            Text(
                text = "NO WASTE",
                textAlign = TextAlign.Center
            )
        }

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

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannersUpdate() {

    val pagerState = rememberPagerState(initialPage = 0);
    val imageSlider = listOf(
        painterResource(id = R.drawable.presentation_adicione_s_receita),
        painterResource(id = R.drawable.presentation_adicione_s_receita2)
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage) % (pagerState.pageCount)
            )
        }
    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = imageSlider.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            Image(
                painter = imageSlider[page],
                contentDescription = "presentation_image",
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
            )
        }

        HorizontalPagerIndicator(
                pagerState = pagerState,
                activeColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(top = 15.dp)
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoWasteTheme {
        HomeUI()
    }
}