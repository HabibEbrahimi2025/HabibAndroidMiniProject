package com.example.amphibians.network

import com.example.amphibians.model.AmphibianPhoto
import retrofit2.http.GET

interface ApiService {
    @GET("amphibians")
    suspend fun getAmphibians():List<AmphibianPhoto>
}