package com.ethanette.app.main

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ethanette.app.navigation.MainNavHost
import com.ethanette.framework.viewmodel.use
import com.ethanette.theme.EthanetteTheme

/**
 * Main screen
 * main screen
 *
 * @param viewModel [MainViewModel]
 */
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val (state, _, _) = use(viewModel)

    EthanetteTheme(
        theme = state.theme.type,
        darkTheme = isSystemInDarkTheme()
    ) {
        MainNavHost()
    }
}

@Preview("light theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun MainScreenPreview() {
    EthanetteTheme {
        MainScreen()
    }
}