package io.github.regbl.fetchrewardsjsonlist.data

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Inject

interface Webservice {
    @GET("/hiring.json")
    suspend fun getItemList(): Response<List<Item>>
}