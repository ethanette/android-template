package com.ethanette.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


/**
 * # MaterialTypography
 * material typography
 */
internal val MaterialTypography = Typography(
    defaultFontFamily = FontFamily.Default
)

/**
 * # MaterialTypographyEx
 * extension typography (Noto Sans KR)
 */
internal val MaterialTypographyEx = TypographyEx(
    defaultFontFamily = NotoSansFontFamily.Default
)


@Immutable
class TypographyEx internal constructor(
    val subtitle3: TextStyle,
    val body3: TextStyle,
) {
    constructor(
        defaultFontFamily: FontFamily = FontFamily.Default,
        subtitle3: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            letterSpacing = 0.1.sp
        ),
        body3: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            letterSpacing = 0.25.sp
        )
    ) : this(
        subtitle3 = subtitle3.withDefaultFontFamily(defaultFontFamily),
        body3 = body3.withDefaultFontFamily(defaultFontFamily)
    )

    fun copy(
        subtitle3: TextStyle = this.subtitle3,
        body3: TextStyle = this.body3
    ): TypographyEx = TypographyEx(
        subtitle3 = subtitle3,
        body3 = body3
    )
}

private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}