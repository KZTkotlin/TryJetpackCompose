package com.example.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class DisplayApiState(
    private val viewModel: DisplayApiViewModel,
) {

    val uiStateDisplayApi: UiStateDisplayApi
        @Composable get() = viewModel.uiState.collectAsStateWithLifecycle().value

    init {
    }
}

@Composable
fun rememberDisplayApi(
): DisplayApiState {
    val viewModel: DisplayApiViewModel = hiltViewModel()
    return remember {
        DisplayApiState(
            viewModel = viewModel
        )
    }
}
