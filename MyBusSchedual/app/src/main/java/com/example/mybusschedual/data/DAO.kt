package com.example.mybusschedual.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface StationDAO {

    @Insert
    suspend fun saveStation(station: Station)



    @Delete
    suspend fun deleteStation(station: Station)

    @Update
    suspend fun updateStation(station: Station)

    @Query("SELECT * from station")
    fun getAllStation(): Flow<List<Station>>

    @Query("SELECT * from station WHERE id = :id")
    fun getStation(id:Int): Flow<Station>

}