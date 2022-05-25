package com.ethanette.app.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ethanette.domain.model.SampleModel
import com.ethanette.sample.SampleViewModel
import com.ethanette.theme.ThemeType

/**
 * # SampleContract
 * sample contract
 *
 * @author hsjun85
 * @since 2022/05/26
 */

data class MainState(
    val theme: ThemeType = ThemeType.DEFAULT,
)

object MainEvent
object MainEffect

@Composable
fun mainViewModel(): MainViewModel = hiltViewModel()