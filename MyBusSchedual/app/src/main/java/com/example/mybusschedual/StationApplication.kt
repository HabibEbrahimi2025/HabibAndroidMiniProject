package com.example.mybusschedual

import android.app.Application
import com.example.mybusschedual.data.StationContainer
import com.example.mybusschedual.data.StationDataContainer

class StationApplication: Application(){
    lateinit var container: StationContainer

    override fun onCreate() {
        super.onCreate()
        container= StationDataContainer(this)
    }
}