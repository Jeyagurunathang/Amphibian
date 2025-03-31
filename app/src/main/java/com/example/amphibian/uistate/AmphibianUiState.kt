package com.example.amphibian.uistate

import com.example.amphibian.network.AmphibianData

sealed interface AmphibianUiState {
    data class Success(val amphibianData: List<AmphibianData>): AmphibianUiState
    data object Loading : AmphibianUiState
    data object Error : AmphibianUiState
}