package com.example.home.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.theme.resources.Res
import org.jetbrains.compose.resources.painterResource

data class Banner(val id: String, val image: String)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannersList(modifier: Modifier = Modifier) {
    val items = (1..10).map { Banner("$it", "$it") }

    val state = rememberLazyListState()
    val snappingLayout = remember(state) { SnapLayoutInfoProvider(state) }
    val flingBehavior = rememberSnapFlingBehavior(snappingLayout)

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxWithConstraints {
            LazyRow(
                modifier = Modifier.wrapContentHeight().fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                state = state,
                flingBehavior = flingBehavior,
            ) {
                itemsIndexed(items) { index, item ->
                    Layout(
                        content = {
                            Banner(item, modifier = modifier)
                        },
                        measurePolicy = { measurables, constraints ->
                            val placeable = measurables.first().measure(constraints)
                            val maxWidthInPx = maxWidth.roundToPx()
                            val itemWidth = placeable.width
                            val startSpace =
                                if (index == 0) (maxWidthInPx - itemWidth) / 2 else 0
                            val endSpace =
                                if (index == items.lastIndex) (maxWidthInPx - itemWidth) / 2 else 0
                            val width = startSpace + placeable.width + endSpace
                            layout(width, placeable.height) {
                                val x = if (index == 0) startSpace else 0
                                placeable.place(x, 0)
                            }
                        }
                    )

                }
            }
        }
        Text("1/2")
    }
}

@Composable
fun Banner(banner: Banner, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
            .width(300.dp).height(170.dp).padding(10.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(10.dp),

    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(banner.image)
                .crossfade(true)
                .build(),
            contentDescription = "banner ${banner.id}",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape)
        )
    }
}