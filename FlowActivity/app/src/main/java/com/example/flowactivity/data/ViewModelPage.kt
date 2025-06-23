package com.example.flowactivity.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class ViewModelPage: ViewModel() {

    val myflow: Flow<Int> = flow {
        for( i in 0..9){
            emit(i)
            delay(2000)
        }
    }

    fun doubleIt(value:Int)=flow {
        emit(value)
        delay(1000)
        emit(value*2)
    }

//    val newFlow=myflow.map{
//        "Current value: $it"
//    }




//    val newFlow=myflow.transform {
//        emit("Value is: $it")
//        delay(1000)
//        emit("Double value become: ${it*2}")
//    }

//
//    val flowof1=flowOf(1,2,3,4).onEach {
//        delay(2000)
//    }
//    val allValue=listOf<String>("Ali", "Hamid", "Haider", "Hadi","Nabi", "Wali", "Jani")
//    val asFlow1=allValue.asFlow().onEach {
//        delay(1500)
//    }

}