package com.github.tacetfive.ironmiller.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Dimens(
    val spacingXxs2: Dp = 2.dp,
    val spacingXxs: Dp = 4.dp,
    val spacingXs: Dp = 8.dp,
    val spacingS: Dp = 12.dp,
    val spacingM: Dp = 16.dp,
    val spacingL: Dp = 24.dp
)

val LocalDimens = staticCompositionLocalOf { Dimens() }