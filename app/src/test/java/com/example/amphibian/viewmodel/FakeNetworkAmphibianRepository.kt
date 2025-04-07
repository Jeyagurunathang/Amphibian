package com.example.amphibian.viewmodel

import com.example.amphibian.fakedata.FakeAmphibianData
import com.example.amphibian.network.AmphibianData
import com.example.amphibian.network.AmphibianRepository

class FakeNetworkAmphibianRepository : AmphibianRepository {
    override suspend fun getAmphibianList(): List<AmphibianData> {
        return FakeAmphibianData.amphibianData
    }
}