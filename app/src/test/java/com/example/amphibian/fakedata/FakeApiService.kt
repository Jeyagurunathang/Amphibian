package com.example.amphibian.fakedata

import com.example.amphibian.network.AmphibianApiService
import com.example.amphibian.network.AmphibianData

class FakeApiService : AmphibianApiService {
    override suspend fun getData(): List<AmphibianData> {
        return FakeAmphibianData.amphibianData
    }
}