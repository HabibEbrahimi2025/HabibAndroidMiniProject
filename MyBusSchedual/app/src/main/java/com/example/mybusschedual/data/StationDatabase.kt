package com.example.mybusschedual.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Station::class], version = 1, exportSchema = false)
abstract class StationDatabase: RoomDatabase() {

    abstract fun stationDAO(): StationDAO

    companion object{
        @Volatile
        private var instance: StationDatabase?=null
        fun getDatabase(context: Context): StationDatabase{
            return  instance?:synchronized(this) {
                Room.databaseBuilder(
                    context,
                    StationDatabase::class.java,
                    "station_databse").build()
                    .also { instance=it }
            }
        }
    }
}