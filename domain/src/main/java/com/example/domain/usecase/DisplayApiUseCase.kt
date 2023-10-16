package com.example.domain.usecase

import com.example.model.Article
import com.example.repository.QiitaRepository
import timber.log.Timber
import javax.inject.Inject

class DisplayApiUseCase @Inject constructor(
    private val qiitaRepository: QiitaRepository
) {
    suspend operator fun invoke(): List<Article>? {
        var articleList: List<Article>? = null
        runCatching {
            articleList = qiitaRepository.getArticle()
        }.onFailure {
            Timber.d("$it")
        }
        return articleList
    }

//    suspend fun fetch() {
//        // TODO：APIフェッチ処理
//    }
}
