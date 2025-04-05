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
import com.example.amphibian.R

@Composable
fun AmphibianApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { AmphibianTopAppBar() }
    ) { innerPadding ->
        HomeScreen(
            modifier = modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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