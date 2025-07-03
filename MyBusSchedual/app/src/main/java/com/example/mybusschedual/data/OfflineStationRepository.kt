package com.example.mybusschedual.data

import kotlinx.coroutines.flow.Flow

class OfflineStationRepository(private val stationDao: StationDAO): StationRepository {
    override fun getAllStation(): Flow<List<Station>> =stationDao.getAllStation()

    override fun getStation(id: Int): Flow<Station> =stationDao.getStation(id)
    override suspend fun insertStation(station: Station) = stationDao.saveStation(station)

    override suspend fun updateStation(station: Station) = stationDao.updateStation(station)

    override suspend fun deleteStation(station: Station) = stationDao.deleteStation(station)
}