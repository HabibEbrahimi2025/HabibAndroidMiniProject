package com.example.amphibians.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.data.AmphibiansContainer
import com.example.amphibians.model.AmphibianPhoto
import kotlinx.coroutines.launch
import java.io.IOException

class AmphibiansViewModel: ViewModel(){
    var modelState: AmphibUiState by mutableStateOf(AmphibUiState.Loading)
    lateinit var ampbCotainer: AmphibiansContainer

    init {
        getAmphibianPhotosRep()
    }

    fun getAmphibianPhotosRep(){
            ampbCotainer= AmphibiansContainer()

            viewModelScope.launch {
                try {
                    modelState = AmphibUiState.Success(
                        ampbCotainer.amphibiansRepositoryInContainer.getRepositoryAmphibians()
                    )
                }catch (e: IOException){
                    modelState= AmphibUiState.Error
                }
            }
    }
}

sealed interface AmphibUiState{
    data class Success(val photo: List<AmphibianPhoto>): AmphibUiState
    object Error: AmphibUiState
    object Loading: AmphibUiState
}
