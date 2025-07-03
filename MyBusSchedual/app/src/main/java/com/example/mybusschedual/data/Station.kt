package com.example.mybusschedual.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "station")
data class Station(

    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val busName:String,
    val departureTime:String,
    val arrivalTime: String
)