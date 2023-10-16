package com.example.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.ui.HomeRoute


const val HomeNavigation = "Home"

fun NavGraphBuilder.homeScreen(
    navigateDisplayApi: () -> Unit
) {
    composable(
        route = HomeNavigation,
    ) {
        HomeRoute(
            navigateDisplayApi = navigateDisplayApi
        )
    }
}
