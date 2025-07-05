package com.example.mybusschedual.ui.item

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybusschedual.data.Station
import com.example.mybusschedual.data.StationRepository
import kotlinx.coroutines.launch


class AddingScreenViewModel(val stationRepository: StationRepository): ViewModel(){
    var busAllState by mutableStateOf(BusState())

    fun updateAllState(busDetails: BusDetails){
        if(checkValidate(busDetails)){
            busAllState= BusState(allState = busDetails, checkValid = true)
            val stationData:Station = changeToStation(busAllState.allState)

            viewModelScope.launch {
                try {
                    stationRepository.insertStation(stationData)
                }catch (e: Exception){
                    Log.i("MyData","Some error happened")
                }

            }
        }
    }

    fun checkValidate(busDetails: BusDetails): Boolean{
        if(busDetails.busStationName.isNotBlank() and busDetails.busDeparture.isNotBlank()
            and busDetails.basArrival.isNotBlank()){
            return true
        }
        return false
    }

    fun displayData(){
        var data= " ${busAllState.allState.busId}  "
        Log.i("MyData", data)
        Log.i("MyData", "${busAllState.allState.busStationName } ")
    }

    fun changeToStation(busDetails: BusDetails): Station{
        val station: Station= Station(
            id=busDetails.busId,
            busName = busDetails.busStationName,
            departureTime = busDetails.busDeparture,
            arrivalTime = busDetails.basArrival
        )
        return station
    }
}


data class BusState(
    var allState: BusDetails= BusDetails(),
    var checkValid: Boolean=false
)
data class BusDetails(
    var busId:Int=0,
    var busStationName:String="",
    var busDeparture:String="",
    var basArrival:String=""
)