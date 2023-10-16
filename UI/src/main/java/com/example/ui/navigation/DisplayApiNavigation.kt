package com.example.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.ui.DisplayApiRoute


const val DisplayApiNavigation = "DisplayApi"

fun NavGraphBuilder.displayApiScreen(
) {
    composable(
        route = DisplayApiNavigation,
    ) {
        DisplayApiRoute()
    }
}
