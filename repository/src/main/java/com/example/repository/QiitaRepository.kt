package com.example.repository

import com.example.api.QiitaApi
import com.example.model.Article
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import javax.inject.Inject

class QiitaRepository @Inject constructor() {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val service: QiitaApi =
        Retrofit.Builder()
            .baseUrl("https://qiita.com/api/v2/")
//            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(QiitaApi::class.java)

    // TODO : UseCaseでAPI呼び出す
    suspend fun getArticle(): List<Article>? {
        var qiitaData: List<Article>? = null
        withContext(Dispatchers.IO) {
            runCatching {
//                val response = service.articleItems("Kotlin").execute()
                val response = service.articleItems().execute()
                if (response.isSuccessful) {
                    qiitaData = response.body()!!
                } else {
                    Timber.d("Get Error")
                }
            }.onFailure {
                Timber.d("API取得こけるログ：$it")
            }
        }
        return qiitaData
    }
}
