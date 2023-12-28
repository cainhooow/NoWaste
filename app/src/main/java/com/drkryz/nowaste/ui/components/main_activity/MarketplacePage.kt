package com.drkryz.nowaste.ui.components.main_activity

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MarketplacePage() {
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
        //
        // item {
        //    BannersNews()
        //
        // }
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
            AppHighlights(true)
        }
    }
}