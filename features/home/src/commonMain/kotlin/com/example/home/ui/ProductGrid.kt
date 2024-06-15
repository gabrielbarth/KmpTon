package com.example.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.theme.AppTheme

@Composable
fun ProductGrid(items: List<Color>, modifier: Modifier = Modifier) {
    val rows = (items.size + 2) / 3
    repeat(rows) { rowIndex ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(AppTheme.space.large)
        ) {
            val start = rowIndex * 3
            val end = minOf(start + 3, items.size)
            for (i in start until end) {
                ProductItem(color = items[i])
            }
        }
    }
}

@Composable
fun ProductItem(color: Color) {
    Surface(
        modifier = Modifier.size(100.dp),
        shape = RoundedCornerShape(8.dp),
        color = color
    ) {
        // TODO
    }
}