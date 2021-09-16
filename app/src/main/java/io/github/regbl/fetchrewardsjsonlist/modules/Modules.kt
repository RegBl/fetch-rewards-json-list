package io.github.regbl.fetchrewardsjsonlist.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.regbl.fetchrewardsjsonlist.data.Webservice
import io.github.regbl.fetchrewardsjsonlist.data.WebserviceImpl
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object WebModule {

    @Provides
    fun provideWebService(): Webservice {
        return Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
            .create(Webservice::class.java)
    }
}