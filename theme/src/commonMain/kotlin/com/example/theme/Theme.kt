package com.example.theme

import androidx.compose.runtime.Composable

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class CustomSpace(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 32.dp,
)
data class CustomTextSize(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 32.dp,
)
data class CustomTypography(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 32.dp,
)
data class CustomColor(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 32.dp,
)
data class CustomShape(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 32.dp,
)

data class CustomShadow(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 32.dp,
)

object AppTheme {
    val space: CustomSpace
        @Composable
        get() = LocalSpace.current
    val textSize: CustomTextSize
        @Composable
        get() = LocalTextSize.current
    val typography: CustomTypography
        @Composable
        get() = LocalTypography.current
    val color: CustomColor
        @Composable
        get() = LocalColor.current
    val shape: CustomShape
        @Composable
        get() = LocalShape.current
    val shadow: CustomShadow
        @Composable
        get() = LocalShadow.current
}

val LocalSpace = staticCompositionLocalOf { CustomSpace() }
val LocalTextSize = staticCompositionLocalOf { CustomTextSize() }
val LocalTypography = staticCompositionLocalOf { CustomTypography() }
val LocalColor = staticCompositionLocalOf { CustomColor() }
val LocalShape = staticCompositionLocalOf { CustomShape() }
val LocalShadow = staticCompositionLocalOf { CustomShadow() }


@Composable
fun AppTheme(
    space: CustomSpace = AppTheme.space,
    textSize: CustomTextSize = AppTheme.textSize,
    typography: CustomTypography = AppTheme.typography,
    color: CustomColor = AppTheme.color,
    shape: CustomShape = AppTheme.shape,
    shadow: CustomShadow = AppTheme.shadow,
    content: @Composable () -> Unit
){
    CompositionLocalProvider(
        LocalSpace provides space,
        LocalTextSize provides textSize,
        LocalTypography provides typography,
        LocalColor provides color,
        LocalShape provides shape,
        LocalShadow provides shadow
    ){
        content()
    }
}