package com.example.home.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.lifecycle.DefaultScreenLifecycleOwner.onDispose
import com.example.domain.banners.Banner
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannersList(items: List<Banner>, modifier: Modifier = Modifier) {

    val state = rememberLazyListState()
    val snappingLayout = remember(state) { SnapLayoutInfoProvider(state) }
    val flingBehavior = rememberSnapFlingBehavior(snappingLayout)

    var visibleItemIndex by remember {
        mutableStateOf(0)
    }

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
        Text("${visibleItemIndex}/${items.size}")
    }
}

@Composable
fun Banner(banner: Banner, modifier: Modifier = Modifier) {
    println("BANNERS ${banner.image}")
    val painterResource = asyncPainterResource(data = Url(banner.image))


    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
            .width(300.dp).height(170.dp).padding(10.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(10.dp),

    ) {
        KamelImage(
            resource = painterResource,
            contentDescription = "Profile",
            contentScale = ContentScale.Crop,
            modifier = modifier.clip(RoundedCornerShape(10.dp)),
            onLoading = { progress -> CircularProgressIndicator(progress) },
            onFailure = { exception ->
               println("${exception.message}")
            }
        )

    }
}