package com.example.amphibian.ui.uilayer.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibian.R
import com.example.amphibian.network.AmphibianData
import com.example.amphibian.ui.theme.AmphibianTheme

@Composable
fun AmphibianCard(
    modifier: Modifier = Modifier,
    amphibianData: AmphibianData,
    onClicked: (AmphibianData) -> Unit
) {
    Card (
        modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_large)).clickable { onClicked(amphibianData) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Box (
            modifier = modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibianData.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = amphibianData.name,
                modifier = modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            AmphibianTypeSpecifier(amphibianType = amphibianData.type)
        }
        Text(
            text = amphibianData.name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = dimensionResource(R.dimen.title_vertical)
                ),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AmphibianCardPreview(modifier: Modifier = Modifier) {
    AmphibianTheme {
        AmphibianCard(amphibianData = AmphibianData(
                name = "Great Basin Spadefoot",
                type = "Toad",
                description = "This is toad",
                imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
            ),
            onClicked = {}
        )
    }
}