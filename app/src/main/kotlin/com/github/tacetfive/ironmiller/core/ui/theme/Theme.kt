package com.github.tacetfive.ironmiller.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color.Companion.White

private val DarkColorScheme = darkColorScheme(
    // Primary
    primary = Green300,
    onPrimary = Green700,
    primaryContainer = Green600,
    onPrimaryContainer = Green100,

    // Secondary
    secondary = Grey300,
    onSecondary = Grey800,
    secondaryContainer = Grey600,
    onSecondaryContainer = Grey150,

    // Tertiary
    tertiary = Salat300,
    onTertiary = Salat800,
    tertiaryContainer = Salat700,
    onTertiaryContainer = Salat100,

    // Error
    error = Red200,
    onError = Red800,
    errorContainer = Red600,
    onErrorContainer = Red100,

    // Background
    background = Grey975,
    onBackground = Grey200,

    // Surface
    surface = Grey900,
    onSurface = Grey200,
    surfaceVariant = Grey650,
    onSurfaceVariant = Grey400,

    // Surface Container
    surfaceContainer = Grey750,
    surfaceContainerHigh = Grey825,
    surfaceContainerHighest = Grey850,
    surfaceContainerLow = Grey875,
    surfaceContainerLowest = Grey950,

    // Outline
    outline = Grey450,
    outlineVariant = Grey650
)

private val LightColorScheme = lightColorScheme(
    // Primary
    primary = Green400,
    onPrimary = White,
    primaryContainer = Green100,
    onPrimaryContainer = Green800,

    // Secondary
    secondary = Grey700,
    onSecondary = White,
    secondaryContainer = Grey150,
    onSecondaryContainer = Grey925,

    // Tertiary
    tertiary = Salat500,
    onTertiary = Black,
    tertiaryContainer = Salat100,
    onTertiaryContainer = Green900,

    // Error
    error = Red500,
    onError = White,
    errorContainer = Red100,
    onErrorContainer = Red900,

    // Background
    background = Grey50,
    onBackground = Grey925,

    // Surface
    surface = White,
    onSurface = Grey925,
    surfaceVariant = Grey150,
    onSurfaceVariant = Grey700,

    // Surface Container
    surfaceContainer = Grey125,
    surfaceContainerHigh = Grey175,
    surfaceContainerHighest = Grey250,
    surfaceContainerLow = Grey100,
    surfaceContainerLowest = Grey75,

    // Outline
    outline = Grey500,
    outlineVariant = Grey400
)

@Composable
fun IronMillerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

object IronMillerTheme {
    val colorScheme: ColorScheme
        @Composable @ReadOnlyComposable get() = MaterialTheme.colorScheme

    val shape: Shapes
        @Composable @ReadOnlyComposable get() = MaterialTheme.shapes

    val typography: Typography
        @Composable @ReadOnlyComposable get() = MaterialTheme.typography

    val dimens: Dimens
        @Composable @ReadOnlyComposable get() = LocalDimens.current
}

