package com.example.androidengrtest.common.data.di

import com.example.androidengrtest.common.data.api.ApiConstants
import com.example.androidengrtest.common.data.api.GitHubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideGitHubApi(builder: Retrofit.Builder): GitHubApi {
        return builder
            .build()
            .create(GitHubApi::class.java)
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(ApiConstants.BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        return OkHttpClient.Builder().addInterceptor(interceptor.apply {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        }).build()
    }
}