package com.example.mybusschedual.data

import kotlinx.coroutines.flow.Flow

interface StationRepository{

   fun getAllStation(): Flow<List<Station>>

   fun getStation(id:Int): Flow<Station>

    suspend fun insertStation(station: Station)

    suspend fun updateStation(station: Station)

    suspend fun deleteStation(station: Station)

}