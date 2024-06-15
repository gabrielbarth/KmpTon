package com.example.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.theme.AppTheme
import com.example.theme.resources.Res
import com.example.theme.resources.menu_hamburger
import org.jetbrains.compose.resources.painterResource


@Composable
fun Header(userFullName: String = "Nome Sobrenome", modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth().height(68.dp),
    ) {
        Row (
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(Res.drawable.menu_hamburger),
                contentDescription = "Menu",
                modifier = modifier.size(AppTheme.shape.extraLarge).padding(start = AppTheme.space.large)
            )
        }
        Row (
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = userFullName,
                style = MaterialTheme.typography.h6,
            )
        }
    }
}