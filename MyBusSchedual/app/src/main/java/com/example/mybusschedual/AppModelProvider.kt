package com.example.mybusschedual

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mybusschedual.ui.item.AddingScreenViewModel

object AppModelProvider {
    val Factory= viewModelFactory {

        //Adding Screen view model
        initializer {
            AddingScreenViewModel()
        }


    }
}