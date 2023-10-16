package com.example.tryjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.ui.navigation.DisplayApiNavigation
import com.example.ui.navigation.HomeNavigation
import com.example.ui.navigation.displayApiScreen
import com.example.ui.navigation.homeScreen


@Composable
fun HostNavigation(
    navHostController: NavHostController
) {
    val startDestination: String = HomeNavigation
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        homeScreen(
            navigateDisplayApi = {
                navHostController.navigate(DisplayApiNavigation)
            }
        )
        displayApiScreen()
    }
}
