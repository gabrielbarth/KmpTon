package com.example.home.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.commons.theme.AppTheme
import com.example.commons.theme.resources.Res
import com.example.commons.theme.resources.arrow_right
import com.example.commons.theme.resources.toggle_visibility
import com.example.commons.theme.resources.wait_clock
import org.jetbrains.compose.resources.painterResource

@Composable
fun Balance(
    futurePayable: Double = 103.20,
    currentBalance: Double = 1320.20,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = modifier
                .height(40.dp)
                .fillMaxWidth().padding(AppTheme.space.large).clickable {

                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.wait_clock),
                contentDescription = "Icone relógio",
                modifier = modifier.padding(end = AppTheme.space.medium)
            )
            Text(
                modifier = modifier,
                fontSize = AppTheme.textSize.medium,
                text = "R\$ $futurePayable",
                fontWeight = FontWeight(700),
            )
            Text(
                modifier = modifier,
                fontSize = AppTheme.textSize.medium,
                text = " em vendas a receber"
            )
            Image(
                painter = painterResource(Res.drawable.arrow_right),
                contentDescription = "Icone relógio",
                modifier = modifier.padding(start = AppTheme.space.medium)
            )
        }
        Divider(
            modifier = modifier
                .fillMaxWidth()
        )
        Row(
            modifier = modifier
                .fillMaxWidth().padding(
                    top = 20.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 0.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth(0.5f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = modifier.padding(bottom = AppTheme.space.small),
                    text = "Dinheiro na carteira",
                    color = Color.Gray,
                    fontWeight = FontWeight(700),
                )
                Row(
                    modifier = modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = modifier,
                        text = "R\$ $currentBalance",
                        fontWeight = FontWeight(700),
                        fontSize = 28.sp
                    )
                    Image(
                        painter = painterResource(Res.drawable.toggle_visibility),
                        contentDescription = "Icone esconder saldo",
                        modifier = modifier.padding(start = AppTheme.space.medium).clickable {

                        },
                    )
                }
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = modifier.padding(AppTheme.space.medium),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.LightGray
                )
            ) {
                Text(
                    text = "Ver extrato",
                    color = Color.Black,
                    fontSize = AppTheme.textSize.medium,
                )
            }
        }

    }
}