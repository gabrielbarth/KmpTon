package com.example.home.ui.components

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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.commons.theme.AppTheme
import org.jetbrains.compose.resources.painterResource

import org.jetbrains.compose.resources.DrawableResource
import com.example.commons.theme.resources.Res
import com.example.commons.theme.resources.*
import com.example.domain.products.Product

val productsMock = listOf(
    Product(
        id = "transactionFlow",
        name = "Vender Agora",
        icon = Res.drawable.vender_agora,
        order = 1
    ),
    Product(
        id = "salesHistory",
        name = "Minhas Vendas",
        icon = Res.drawable.minhas_vendas,
        order = 2
    ),
    Product(
        id = "mobileRecharge",
        name = "Recarga de celular",
        icon = Res.drawable.recarga_celular,
        order = 3
    ),
    Product(
        id = "bankingPix",
        name = "Pix",
        icon = Res.drawable.pix,
        order = 4
    ),
    Product(
        id = "transfer",
        name = "Transferir dinheiro",
        icon = Res.drawable.transferir_dinheiro,
        order = 5
    ),
    Product(
        id = "calculator",
        name = "Calculadora de Taxas",
        icon = Res.drawable.calculadora_taxas,
        order = 6
    ),
    Product(
        id = "paymentLinks",
        name = "Links de Pagamento",
        icon = Res.drawable.link_pagamento,
        order = 7
    ),
    Product(
        id = "myCards",
        name = "Meu Cartão",
        icon = Res.drawable.meu_cartao,
        order = 8
    ),
    Product(
        id = "productCatalog",
        name = "Minha Loja",
        icon = Res.drawable.minha_loja,
        order = 9
    ),
    Product(
        id = "payBills",
        name = "Pagar Contas",
        icon = Res.drawable.pagar_contas,
        order = 10
    ),
    Product(
        id = "bankingDeposit",
        name = "Depósito Bancário",
        icon = Res.drawable.pix,
        order = 11
    ),
    Product(
        id = "mgm",
        name = "Renda Extra",
        icon = Res.drawable.rex,
        order = 12
    ),
    Product(
        id = "shopton",
        name = "Shopping Ton",
        icon = Res.drawable.shopping_ton,
        order = 13
    ),
    Product(
        id = "insurance",
        name = "Seguros",
        icon = Res.drawable.seguros,
        order = 14
    )
)


fun getProductName(productId: String): String? {
    return productsMock.find { it.id == productId }?.name
}
fun getProductIcon(productId: String): DrawableResource? {
    return productsMock.find { it.id == productId }?.icon
}
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
                val productName = getProductName(products[i].id)
                if(productName == null){
                    continue
                }
                ProductItem(product = products[i], modifier)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, modifier: Modifier) {
    val productName = remember { getProductName(product.id) }
    val productIcon = remember { getProductIcon(product.id) }
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
            Image(
                painter = painterResource(productIcon!!),
                contentDescription = productName,
                modifier = modifier.size(24.dp)
            )
            Text(
                text = productName!!,
                modifier = modifier.padding(top = 4.dp),
                fontSize = 14.sp,
                lineHeight = 14.sp
            )
        }
    }
}