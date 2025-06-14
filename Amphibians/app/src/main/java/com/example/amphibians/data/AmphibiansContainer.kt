package com.example.amphibians.data

import com.example.amphibians.network.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import kotlin.getValue

class AmphibiansContainer{
    private val baseUrl="https://android-kotlin-fun-mars-server.appspot.com/"
    private val contentType = "application/json".toMediaType()
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()


    private val retrofitAmphibians by lazy{
        retrofit.create(ApiService::class.java)
    }

    val amphibiansRepositoryInContainer: AmphibiansRepository by lazy {
        AmphibiansRepository(retrofitAmphibians)
    }
}