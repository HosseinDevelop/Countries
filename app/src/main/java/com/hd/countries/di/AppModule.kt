package com.hd.countries.di

import com.hd.countries.common.Constants.BASE_URL
import com.hd.countries.data.remote.ApiService
import com.hd.countries.data.repository.Repository
import com.hd.countries.data.repository.RepositoryImpl
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

    @Provides
    @Singleton
    fun provideApi(): ApiService {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService): Repository {
        return RepositoryImpl(apiService)
    }


}