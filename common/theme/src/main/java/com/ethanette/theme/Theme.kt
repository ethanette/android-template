package com.ethanette.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf


/**
 * # EthanetteTheme
 * ethanette theme
 *
 * @param darkTheme theme
 * @param content composable content
 */
@Composable
fun EthanetteTheme(
    theme: String = ThemeType.DEFAULT.type,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val themeType = ThemeType.getByValue(theme)

    ProvideEthanetteTheme(
        ThemeProvider.getColorsEx(themeType, darkTheme),
        ThemeProvider.getTypographyEx(themeType)
    ) {
        MaterialTheme(
            colors = ThemeProvider.getColors(themeType, darkTheme),
            typography = ThemeProvider.getTypography(themeType),
            content = content
        )
    }
}

@Composable
private fun ProvideEthanetteTheme(
    colors: ColorsEx,
    typography: TypographyEx,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(
        LocalColorsEx provides colorPalette,
        LocalTypographyEx provides typography,
        content = content
    )
}

private val LocalColorsEx = staticCompositionLocalOf<ColorsEx> {
    error("No colors provided")
}

private val LocalTypographyEx = staticCompositionLocalOf<TypographyEx> {
    error("No typography provided")
}

enum class ThemeType(val type: String) {
    DEFAULT("default");

    companion object {
        fun getByValue(theme: String) =
            enumValues<ThemeType>().firstOrNull { it.type == theme } ?: DEFAULT
    }
}

object ThemeProvider {

    private val defaultTheme = Theme(
        colors = ThemeColor(MaterialLightColors, MaterialDarkColors),
        typography = MaterialTypography,
        colorsEx = ThemeColor(MaterialLightColorsEx, MaterialDarkColorsEx),
        typographyEx = MaterialTypographyEx
    )

    private val themes = mapOf(
        ThemeType.DEFAULT to defaultTheme,
    )

    fun getColors(type: ThemeType, darkTheme: Boolean): Colors =
        themes[type]?.colors?.colors(darkTheme) ?: defaultTheme.colors.colors(
            darkTheme
        )

    fun getColorsEx(type: ThemeType, darkTheme: Boolean): ColorsEx =
        themes[type]?.colorsEx?.colors(darkTheme) ?: defaultTheme.colorsEx.colors(darkTheme)

    fun getTypography(type: ThemeType): Typography =
        themes[type]?.typography ?: defaultTheme.typography

    fun getTypographyEx(type: ThemeType): TypographyEx =
        themes[type]?.typographyEx ?: defaultTheme.typographyEx

}

private data class ThemeColor<T>(val light: T, val dark: T)

private fun <T> ThemeColor<T>.colors(darkTheme: Boolean): T {
    return if (darkTheme) dark else light
}

private data class Theme(
    val colors: ThemeColor<Colors>,
    val colorsEx: ThemeColor<ColorsEx>,
    val typography: Typography,
    val typographyEx: TypographyEx
)