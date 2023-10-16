package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.DisplayApiUseCase
import com.example.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisplayApiViewModel @Inject constructor(
    private val displayApiUseCase: DisplayApiUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiStateDisplayApi> =
        MutableStateFlow(UiStateDisplayApi.default)
    val uiState: StateFlow<UiStateDisplayApi> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getQiitaArticleList()
        }
    }

    private suspend fun getQiitaArticleList() {
        val article = displayApiUseCase()
        _uiState.update {
            it.copy(
                article = article
            )
        }
    }
}

data class UiStateDisplayApi(
    val article: List<Article>? = null
) {
    companion object {
        val default = UiStateDisplayApi()
    }
}
