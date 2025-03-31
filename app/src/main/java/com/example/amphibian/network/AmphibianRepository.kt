package com.example.amphibian.network

interface AmphibianRepository {
    suspend fun getAmphibianList(): List<AmphibianData>
}

class NetworkAmphibianRepository(
    private val amphibianRetrofitService: AmphibianApiService
) : AmphibianRepository {
    override suspend fun getAmphibianList(): List<AmphibianData> {
        return amphibianRetrofitService.getData()
    }
}