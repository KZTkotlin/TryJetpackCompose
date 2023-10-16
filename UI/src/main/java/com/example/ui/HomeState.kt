package com.example.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class HomeState(
    private val viewModel: HomeViewModel,
) {

    val uiStateHome: UiStateHome
        @Composable get() = viewModel.uiState.collectAsStateWithLifecycle().value

    init {
    }
}

@Composable
fun rememberHomeState(
): HomeState {
    val viewModel: HomeViewModel = hiltViewModel()
    return remember {
        HomeState(
            viewModel = viewModel
        )
    }
}
