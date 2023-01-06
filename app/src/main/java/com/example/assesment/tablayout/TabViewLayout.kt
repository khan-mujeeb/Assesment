package com.example.assesment.tablayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import com.example.assesment.MainActivity
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabViewLayout() {
    val pagerState = rememberPagerState()
    val currentPage = pagerState.currentPage
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = currentPage,
            backgroundColor = Color.White,

        ) {
            tabList.forEachIndexed{
                    index, tabData ->
                Tab(selected = currentPage==index, onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                    modifier = Modifier.padding(20.dp)

                ) {
                    Text(
                        text = tabList[index].name,
                        color = Color.Black
                    )
                }
            }
        }
        
        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { index->
            when(index) {
                0-> {
                    setLazyLayout()
                }

                1-> {
                    Text(text = tabList[index].descp)
                }

                2-> {
                    Text(text = tabList[index].descp)
                }
            }
        }
    }
}


data class TabData(
    val name: String,
    val descp: String
)

val tabList = listOf(
    TabData(
        "charcha",
        "charcha desco"
    ),
    TabData(
        "bazaar",
        "bazaar descp"
    ),
    TabData(
        "profile",
        "profile descp"
    )

)

@Composable
fun setLazyLayout() {
    LazyColumn(content = {
        items(MainActivity.user) { items ->
            Column(

            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(items!!.image),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(75.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text = items!!.firstName,
                                modifier = Modifier.padding(5.dp)
                            )
                        }

                    }

                }
                Divider()
            }

        }
    })
}
