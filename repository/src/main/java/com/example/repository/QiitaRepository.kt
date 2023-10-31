package com.example.repository

import com.example.api.QiitaApi
import com.example.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class QiitaRepository @Inject constructor(
    private val qiitaApi: QiitaApi
) {

    // TODO : UseCaseでAPI呼び出す
    suspend fun getArticle(): List<Article>? {
        var qiitaData: List<Article>? = null
        withContext(Dispatchers.IO) {
            runCatching {
                qiitaData = qiitaApi.articleItems().body()

            }.onFailure {
                Timber.d("API取得こけるログ：$it")
            }
        }
        return qiitaData
    }
}
