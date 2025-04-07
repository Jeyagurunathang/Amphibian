package com.example.amphibian.ui.uilayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibian.R
import com.example.amphibian.network.AmphibianData
import com.example.amphibian.ui.theme.AmphibianTheme
import com.example.amphibian.ui.uilayer.components.AmphibianCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(0.dp),
    amphibians: List<AmphibianData>
) {
    LazyColumn (
        modifier = modifier
//        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_large))
    ) {
        item {
            Text(
                text = stringResource(R.string.app_name),
                modifier = modifier.fillMaxWidth().padding(top = dimensionResource(R.dimen.app_title_padding)),
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
        }
        items(
            amphibians,
            key = { amphibian -> amphibian.name }
        ) { amphibian ->
            AmphibianCard(
                amphibianData = amphibian
            )
        }
    }
}