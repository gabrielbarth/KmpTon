package com.example.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.theme.AppTheme
import com.example.theme.resources.Res
import com.example.theme.resources.calculadora_taxas
import com.example.theme.resources.depositar
import com.example.theme.resources.link_pagamento
import com.example.theme.resources.meu_cartao
import com.example.theme.resources.minha_loja
import com.example.theme.resources.minhas_vendas
import com.example.theme.resources.pagar_contas
import com.example.theme.resources.pix
import com.example.theme.resources.recarga_celular
import com.example.theme.resources.rex
import com.example.theme.resources.seguros
import com.example.theme.resources.shopping_ton
import com.example.theme.resources.tapton
import com.example.theme.resources.transferir_dinheiro
import com.example.theme.resources.vender_agora
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

data class Product(val id: String, val label: String, val icon: DrawableResource)

val productsMock = listOf(
    Product("1", "Vender Agora", Res.drawable.vender_agora),
    Product("2", "Minhas Vendas", Res.drawable.minhas_vendas),
    Product("3", "Recarga de celular", Res.drawable.recarga_celular),
    Product("4", "Pix", Res.drawable.pix),
    Product("5", "Transferir Dinheiro", Res.drawable.transferir_dinheiro),
    Product("6", "Calculadora de Taxas", Res.drawable.calculadora_taxas),
    Product("7", "Links de pagamento", Res.drawable.link_pagamento),
    Product("8", "Meu Cartão", Res.drawable.meu_cartao),
    Product("9", "Minha Loja", Res.drawable.minha_loja),
    Product("10", "Pagar Contas", Res.drawable.pagar_contas),
    Product("11", "Depositar", Res.drawable.depositar),
    Product("12", "Renda Extra", Res.drawable.rex),
    Product("13", "Shopping Ton", Res.drawable.shopping_ton),
    Product("14", "Seguros", Res.drawable.seguros),
    Product("15", "TapTon", Res.drawable.tapton)
)
@Composable
fun ProductGrid(items: List<Product> = productsMock, modifier: Modifier = Modifier) {
    val rows = (items.size + 2) / 3
    repeat(rows) { rowIndex ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            val start = rowIndex * 3
            val end = minOf(start + 3, items.size)
            for (i in start until end) {
                ProductItem(product = items[i], modifier)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, modifier: Modifier) {
    Card(
        modifier = modifier.height(100.dp).widthIn(min = 100.dp, max = 110.dp),
        shape = RoundedCornerShape(AppTheme.shape.medium),
        backgroundColor = Color.White
    ) {
        Column(
            modifier = modifier.fillMaxSize().padding(12.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(product.icon),
                contentDescription = "Product icon",
                modifier = modifier.size(24.dp)
            )
            Text(
                text = product.label,
                modifier = modifier.padding(top = 4.dp),
                fontSize = 14.sp,
                lineHeight = 14.sp
            )
        }
    }
}