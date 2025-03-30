package com.example.amphibian.network

interface AmphibianRepository {
    suspend fun getAmphibianList(): List<AmphibianData>
}

class NetworkAmphibianRepository : AmphibianRepository {
    override suspend fun getAmphibianList(): List<AmphibianData> {
        return AmphibianApi.retrofitService.getData()
    }
}

