package com.example.domain.usecase

import javax.inject.Inject

class HomeUseCase @Inject constructor() {
    suspend operator fun invoke() {
        // TODO：なんかリポジトリ処理があれば使う
    }

    suspend fun fetch() {
        // TODO：APIフェッチ処理
    }
}
