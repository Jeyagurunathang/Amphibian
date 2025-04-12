package com.example.amphibian.ui.uilayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.amphibian.R
import com.example.amphibian.ui.theme.AmphibianTheme
import com.example.amphibian.ui.uilayer.components.LoadingScreen

@Composable
fun DetailScreenBody(
    modifier: Modifier = Modifier,
    amphibianName: String,
    amphibianImage: String,
    amphibianDescription: String
) {
    Column (
        modifier = Modifier.fillMaxWidth().padding(horizontal = dimensionResource(R.dimen.app_side_padding)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(amphibianImage)
                .crossfade(true)
                .build(),
            contentDescription = amphibianName,
            modifier = Modifier.fillMaxWidth().clip(shape = MaterialTheme.shapes.medium)
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.detail_vertical)))

        Text(
            text = amphibianDescription,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenBodyPreview(modifier: Modifier = Modifier) {
    AmphibianTheme(dynamicColor = false) {
        DetailScreenBody(
            amphibianName = "Great Basin Spadefoot",
            amphibianImage = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png",
            amphibianDescription = "This is toad"
        )
    }
}