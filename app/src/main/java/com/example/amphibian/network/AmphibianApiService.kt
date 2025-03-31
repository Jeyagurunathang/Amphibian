package com.example.amphibian.network

import retrofit2.http.GET

interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getData(): List<AmphibianData>
}