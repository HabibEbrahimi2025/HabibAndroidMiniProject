package com.example.mybusschedual.data

import android.content.Context

interface StationContainer {
    val stationRepository: StationRepository
}

class StationDataContainer(private val context: Context): StationContainer{

    override val stationRepository: StationRepository by lazy {
        OfflineStationRepository(StationDatabase.getDatabase(context).stationDAO())
    }
}

