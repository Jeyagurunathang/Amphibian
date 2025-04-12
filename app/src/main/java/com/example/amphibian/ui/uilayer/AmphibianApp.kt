package com.example.amphibian.ui.uilayer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibian.R
import com.example.amphibian.network.AmphibianData
import com.example.amphibian.uistate.AmphibianUiState
import com.example.amphibian.viewmodel.AmphibianViewModel

@Composable
fun AmphibianApp(
    modifier: Modifier = Modifier,
    onAmphibianClicked: (AmphibianData) -> Unit = {},
    amphibianViewModel: AmphibianViewModel,
    amphibianUiState: AmphibianUiState
) {
    Scaffold(
//        topBar = { AmphibianTopAppBar() }
    ) { innerPadding ->
        when (amphibianUiState) {
            is AmphibianUiState.Success -> HomeScreen(
                modifier = modifier.padding(innerPadding),
                amphibians = amphibianUiState.amphibianData,
                onAmphibianCardClicked = onAmphibianClicked
            )

            is AmphibianUiState.Loading -> { Text(text = "Loading") }

            is AmphibianUiState.Error -> { Text(text = "Error") }
        }
    }
}

/* @OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineLarge
            )
        },
        modifier = modifier.padding(top = dimensionResource(R.dimen.app_title_padding))
    )
}
 */