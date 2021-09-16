package io.github.regbl.fetchrewardsjsonlist.data

import androidx.lifecycle.LiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val webservice: Webservice
) {

    suspend fun getItemList(): LiveData<String> = webservice.getItemList()

//    val retrofit = Retrofit.Builder()
//        .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
//        .build()
//
//    val service = retrofit.create(Webservice::class.java)
//    val rawData = service.
}