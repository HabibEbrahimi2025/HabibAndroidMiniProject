package com.example.amphibians.data

import com.example.amphibians.model.AmphibianPhoto
import com.example.amphibians.network.ApiService

class AmphibiansRepository(val apiServiceLink: ApiService){
    suspend fun getRepositoryAmphibians(): List<AmphibianPhoto> {
        return apiServiceLink.getAmphibians()
    }

}