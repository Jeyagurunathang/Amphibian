package com.example.amphibian.data

import com.example.amphibian.network.AmphibianApiService
import com.example.amphibian.network.AmphibianRepository
import com.example.amphibian.network.NetworkAmphibianRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val amphibianRepository: AmphibianRepository
}

class DefaultApplicationContainer : AppContainer {
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: AmphibianApiService by lazy { retrofit.create(AmphibianApiService::class.java) }

    override val amphibianRepository by lazy {
        NetworkAmphibianRepository(retrofitService)
    }
}