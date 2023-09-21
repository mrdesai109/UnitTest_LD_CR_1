package com.rushi.unittest_ld_cr_1.data.di

import com.rushi.unittest_ld_cr_1.data.network.PostsAPI
import com.rushi.unittest_ld_cr_1.data.repository.MainRepositoryImpl
import com.rushi.unittest_ld_cr_1.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    @Singleton
    @Provides
    fun providePostsAPI(retrofit: Retrofit) : PostsAPI = retrofit.create(PostsAPI::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(api : PostsAPI) : MainRepository {
        return MainRepositoryImpl(api = api)
    }

}