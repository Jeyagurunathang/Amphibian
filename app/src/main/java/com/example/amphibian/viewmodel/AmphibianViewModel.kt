package com.example.amphibian.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibian.AmphibianApplication
import com.example.amphibian.network.AmphibianData
import com.example.amphibian.network.AmphibianRepository
import com.example.amphibian.uistate.AmphibianUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AmphibianViewModel(private val amphibianRepository: AmphibianRepository) : ViewModel() {
    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set
    var selectedAmphibian: AmphibianData by mutableStateOf(AmphibianData())

    init {
        getAmphibianData()
    }

    fun getAmphibianData() {
        viewModelScope.launch {
            amphibianUiState = try {
                AmphibianUiState.Success(amphibianData = amphibianRepository.getAmphibianList())
            } catch(e: IOException) {
                AmphibianUiState.Error
            } catch(e: HttpException) {
                AmphibianUiState.Error
            } catch(e: Exception) {
                AmphibianUiState.Error
            }
        }
    }

    fun updateCurrentAmphibianData(amphibianData: AmphibianData) {
        selectedAmphibian = amphibianData
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibianApplication)
                val amphibianRepository = application.container.amphibianRepository
                AmphibianViewModel(amphibianRepository)
            }
        }
    }
}