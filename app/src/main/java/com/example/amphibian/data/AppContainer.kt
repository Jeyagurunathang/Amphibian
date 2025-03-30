package com.example.amphibian.data

import com.example.amphibian.network.AmphibianRepository

interface AppContainer {
    val amphibianRepository: AmphibianRepository
}