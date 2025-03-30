package com.example.amphibian.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibian.network.NetworkAmphibianRepository
import com.example.amphibian.uistate.AmphibianUiState
import kotlinx.coroutines.launch

class AmphibianViewModel : ViewModel() {
    var amphibianUiState by mutableStateOf(AmphibianUiState(""))
        private set

    init {
        getAmphibianData()
    }

    private fun getAmphibianData() {
        viewModelScope.launch {
            val result = NetworkAmphibianRepository()
            amphibianUiState = AmphibianUiState("${ result.getAmphibianList().size } amphibians are retrieved")
        }
    }
}