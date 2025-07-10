package com.example.mybusschedual.ui.item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybusschedual.data.Station
import com.example.mybusschedual.data.StationRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class MainScreenViewModel(stationRepository: StationRepository) : ViewModel(){
    val showClass : StateFlow<ShowClass> = stationRepository.getAllStation().map { ShowClass(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(MainScreenViewModel.TIMEOUT_MILLIS),
            initialValue = ShowClass()

        )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class ShowClass(var allStation : List<Station> = listOf())