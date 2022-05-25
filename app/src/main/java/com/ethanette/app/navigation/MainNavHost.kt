package com.ethanette.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ethanette.sample.SampleListScreen

/**
 * # android-template
 * # main nav host
 * @author hsjun85
 * @since 2022/05/26
 */

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = Destinations.SAMPLE
) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Destinations.SAMPLE
        ) {
            SampleListScreen()
        }
    }
}