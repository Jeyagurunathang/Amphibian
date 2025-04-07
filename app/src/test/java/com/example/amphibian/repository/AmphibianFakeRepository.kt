package com.example.amphibian.repository

import com.example.amphibian.fakedata.FakeAmphibianData
import com.example.amphibian.fakedata.FakeApiService
import com.example.amphibian.network.NetworkAmphibianRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AmphibianFakeRepository {
    @Test
    fun networkAmphibianRepository_getAmphibianList_verifyAmphibianData() = runTest {
        val amphibianData = NetworkAmphibianRepository(amphibianRetrofitService = FakeApiService())
        assertEquals(FakeAmphibianData.amphibianData, amphibianData.getAmphibianList())
    }
}