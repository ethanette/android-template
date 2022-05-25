package com.ethanette.theme

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color


/**
 * # MaterialLightColors
 * material light palette
 */
internal val MaterialLightColors = lightColors(
    primaryVariant = ColorValues.primaryVariantLight,
    primary = ColorValues.primaryLight,
    secondary = ColorValues.secondaryLight,
    secondaryVariant = ColorValues.secondaryVariantLight,
    error = ColorValues.errorLight
)

/**
 * # MaterialDarkColors
 * material dark palette
 */
internal val MaterialDarkColors = darkColors(
    primary = ColorValues.primaryDark,
    primaryVariant = ColorValues.primaryVariantDark,
    secondary = ColorValues.secondaryDark,
    secondaryVariant = ColorValues.secondaryVariantDark,
    error = ColorValues.errorDark,
)

/**
 * # MaterialLightColorsEx
 * extension material light palette
 */
internal val MaterialLightColorsEx = ColorsEx(
    surfaceOverlay = ColorValues.surfaceOverlayLight,
    warning = ColorValues.warningLight,
    isDark = false
)

/**
 * # MaterialDarkColorsEx
 * extension material dark light palette
 */
internal val MaterialDarkColorsEx = ColorsEx(
    surfaceOverlay = ColorValues.surfaceOverlayDark,
    warning = ColorValues.warningDark,
    isDark = true
)


/**
 * # ColorValues
 * color values
 */
object ColorValues {
    val white = Color.White
    val black = Color.Black
    val transparent = Color.Transparent

    val primaryLight = Color(0xFF6200EE)
    val primaryVariantLight = Color(0xFF3700B3)
    val secondaryLight = Color(0xFF03DAC6)
    val secondaryVariantLight = Color(0xFF018786)
    val errorLight = Color(0xFFB00020)

    val primaryDark = Color(0xFFBB86FC)
    val primaryVariantDark = Color(0xFF3700B3)
    val secondaryDark = Color(0xFF03DAC6)
    val secondaryVariantDark = Color(0xFF03DAC6)
    val errorDark = Color(0xFFCF6679)

    val surfaceOverlayLight = Color(0x14212121)
    val warningLight = Color(0xFFFF5722)

    val surfaceOverlayDark = Color(0x1FFFFFFF)
    val warningDark = Color(0xFFFF9574)
}


/**
 * # ColorPalette
 * custom color palette
 */
@Stable
class ColorsEx(
    surfaceOverlay: Color,
    warning: Color,
    isDark: Boolean
) {
    var surfaceOverlay by mutableStateOf(surfaceOverlay)
        private set
    var warning by mutableStateOf(warning)
        private set
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: ColorsEx) {
        surfaceOverlay = other.surfaceOverlay
        warning = other.warning
        isDark = other.isDark
    }

    fun copy(): ColorsEx = ColorsEx(
        surfaceOverlay = surfaceOverlay,
        warning = warning,
        isDark = isDark,
    )
}

val Colors.secondaryVariantSurface: Color get() = if (isLight) secondaryVariant else surface

fun Color.alpha(alpha: Float) = this.copy(alpha = alpha)