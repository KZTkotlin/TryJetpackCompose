package com.example.ui

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiStateHome> =
        MutableStateFlow(UiStateHome.default)
    val uiState: StateFlow<UiStateHome> = _uiState.asStateFlow()

    fun fetch() {}
}

data class UiStateHome(
    val getApi: Any? = null
) {
    companion object {
        val default = UiStateHome()
    }
}
