package com.ethanette.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

/**
 * # NotoSansFont
 */
internal object NotoSansFontFamily {
    val Default = FontFamily(
        Font(R.font.noto_sans_kr_thin_hestia, FontWeight.Thin),
        Font(R.font.noto_sans_kr_light_hestia, FontWeight.Light),
        Font(R.font.noto_sans_kr_regular_hestia, FontWeight.Normal),
        Font(R.font.noto_sans_kr_medium_hestia, FontWeight.Medium),
        Font(R.font.noto_sans_kr_bold_hestia, FontWeight.Bold),
        Font(R.font.noto_sans_kr_black_hestia, FontWeight.Black),
    )
}