package io.github.regbl.fetchrewardsjsonlist.data

import retrofit2.Response
import retrofit2.http.GET

interface Webservice {
    @GET("/hiring.json")
    suspend fun getItemList(): Response<List<Item>>
}