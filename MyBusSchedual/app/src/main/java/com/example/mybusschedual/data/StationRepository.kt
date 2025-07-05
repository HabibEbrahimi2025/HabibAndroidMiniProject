package com.example.mybusschedual.data

import kotlinx.coroutines.flow.Flow

interface StationRepository{

   fun getAllStation(): Flow<List<Station>>

   fun getStation(id:Int): Flow<Station>

    suspend fun insertStation(station: Station)

    suspend fun updateStation(station: Station)

    suspend fun deleteStation(station: Station)

}

//
//package com.example.mybusschedual.data
//
//import kotlinx.coroutines.flow.Flow
//
//class StationRepository(private val stationDao: StationDAO){
//     fun getAllStation(): Flow<List<Station>> =stationDao.getAllStation()
//
//     fun getStation(id: Int): Flow<Station> =stationDao.getStation(id)
//     suspend fun insertStation(station: Station) = stationDao.saveStation(station)
//
//     suspend fun updateStation(station: Station) = stationDao.updateStation(station)
//
//     suspend fun deleteStation(station: Station) = stationDao.deleteStation(station)
//}