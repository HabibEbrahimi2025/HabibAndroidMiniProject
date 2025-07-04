package com.example.mybusschedual

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mybusschedual.ui.item.AddingScreenViewModel

object AppModelProvider {
    val Factory= viewModelFactory {

        //Adding Screen view model
        initializer {
            AddingScreenViewModel(stationApplication().container.stationRepository)
        }


    }
}

fun CreationExtras.stationApplication(): StationApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as StationApplication)