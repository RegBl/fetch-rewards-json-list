package io.github.regbl.fetchrewardsjsonlist.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import io.github.regbl.fetchrewardsjsonlist.data.Repository
import io.github.regbl.fetchrewardsjsonlist.data.RepositoryImpl
import io.github.regbl.fetchrewardsjsonlist.data.Webservice
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WebModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideWebService(retrofit: Retrofit) : Webservice {
        return retrofit.create(Webservice::class.java)
    }
}

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun repository(repositoryImpl: RepositoryImpl) : Repository
}