package com.example.amphibian.viewmodel

import com.example.amphibian.fakedata.FakeAmphibianData
import com.example.amphibian.rules.TestDispatcherRule
import com.example.amphibian.uistate.AmphibianUiState
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class FakeAmphibianViewModel {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun amphibianViewModel_getAmphibianData_verifyUiState() = runTest {
        val fakeViewModel = AmphibianViewModel(amphibianRepository = FakeNetworkAmphibianRepository())
        val fakeAmphibianData = fakeViewModel.getAmphibianData()
        assertEquals(AmphibianUiState.Success(FakeAmphibianData.amphibianData), fakeViewModel.amphibianUiState)
    }
}