package com.example.amphibian.ui.uilayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.amphibian.R
import com.example.amphibian.network.AmphibianData

@Composable
fun AmphibianDetailScreen(
    modifier: Modifier = Modifier,
    amphibianData: AmphibianData = AmphibianData(
        name = "Great Basin Spadefoot",
        type = "Toad",
        description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
        imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
    ),
    onBackArrowPressed: () -> Unit
) {
    Scaffold { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(top = dimensionResource(R.dimen.app_title_padding)),
//                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DetailScreenHeader(
                amphibianName = amphibianData.name,
                onBackArrowPressed = onBackArrowPressed
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))

            DetailScreenBody(
                amphibianName = amphibianData.name,
                amphibianDescription = amphibianData.description,
                amphibianImage = amphibianData.imgSrc
            )
        }
    }
}