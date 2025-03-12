package com.example.onlinecourses.di

import com.example.onlinecourses.data.network.RetrofitInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class DataProvider {
    @Provides
    fun provideRetrofit(): RetrofitInterface {
        return Retrofit.Builder().baseUrl("https://tebntueahbbwxcizqnfi.supabase.co/rest/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetrofitInterface::class.java)
    }
}