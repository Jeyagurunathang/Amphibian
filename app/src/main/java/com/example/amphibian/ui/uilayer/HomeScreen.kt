package com.example.amphibian.ui.uilayer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.amphibian.network.AmphibianData
import com.example.amphibian.ui.uilayer.components.AmphibianCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(0.dp),
    amphibian: AmphibianData = AmphibianData(
        name = "Great Basin Spadefoot",
        type = "Toad",
        description = "This is toad",
        imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
    )
) {
    AmphibianCard(
        amphibianData = amphibian,
        modifier = modifier
    )
}