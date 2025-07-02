package com.example.mybusschedual.ui.item

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AddingScreenViewModel: ViewModel(){
    var busAllState by mutableStateOf(BusState())

    fun updateAllState(busDetails: BusDetails){
        busAllState= BusState(allState = busDetails, checkValid = true)
    }

    fun displayData(){
        var data= " ${busAllState.allState.busId}  "
        Log.i("MyData", data)
        Log.i("MyData", "${busAllState.allState.busStationName } ")
    }
}


data class BusState(
    var allState: BusDetails= BusDetails(),
    var checkValid: Boolean=true
)
data class BusDetails(
    var busId:Int=0,
    var busStationName:String="",
    var busDeparture:String="",
    var basArrival:String=""
)