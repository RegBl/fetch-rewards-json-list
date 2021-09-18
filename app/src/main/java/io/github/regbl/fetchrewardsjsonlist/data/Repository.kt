package io.github.regbl.fetchrewardsjsonlist.data

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface Repository {
    suspend fun getItemList(): Response<List<Item>>
}

class RepositoryImpl @Inject constructor(private val webservice: Webservice): Repository {
    override suspend fun getItemList(): Response<List<Item>> = webservice.getItemList()
}