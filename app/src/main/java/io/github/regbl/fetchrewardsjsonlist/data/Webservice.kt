package io.github.regbl.fetchrewardsjsonlist.data

import androidx.lifecycle.LiveData
import retrofit2.http.GET
import javax.inject.Inject

interface Webservice {
    @GET("/hiring.json")
    suspend fun getItemList(): LiveData<String>
}

class WebserviceImpl @Inject constructor() : Webservice {
    @GET("/hiring.json")
    override suspend fun getItemList(): LiveData<String> {
        TODO("Not yet implemented")
    }
}