package com.example.home.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.products.Product
import com.example.theme.AppTheme


@Composable
fun ProductGrid(products: List<Product>, modifier: Modifier = Modifier) {
    val rows = (products.size + 2) / 3
    repeat(rows) { rowIndex ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            val start = rowIndex * 3
            val end = minOf(start + 3, products.size)
            for (i in start until end) {
                ProductItem(product = products[i], modifier)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, modifier: Modifier) {
    Card(
        modifier = modifier
            .height(100.dp)
            .widthIn(min = 100.dp, max = 110.dp)
            .clickable {

            },
        shape = RoundedCornerShape(AppTheme.shape.medium),
        backgroundColor = Color.White
    ) {
        Column(
            modifier = modifier.fillMaxSize().padding(12.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
//            Image(
//                painter = product.icon,
//                contentDescription = "Product icon",
//                modifier = modifier.size(24.dp)
//            )
            Text(
                text = product.label,
                modifier = modifier.padding(top = 4.dp),
                fontSize = 14.sp,
                lineHeight = 14.sp
            )
        }
    }
}