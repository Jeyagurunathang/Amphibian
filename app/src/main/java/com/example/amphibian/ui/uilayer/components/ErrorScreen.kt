package com.example.amphibian.ui.uilayer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibian.R
import com.example.amphibian.ui.theme.AmphibianTheme

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.fillMaxSize().padding(horizontal = dimensionResource(R.dimen.app_side_padding)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.no_wifi),
            contentDescription = stringResource(R.string.no_signal),
            modifier = Modifier.size(dimensionResource(R.dimen.error_icon)),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSecondary)
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.error_screen_dividing_space)))

        Text(
            text = stringResource(R.string.no_internet_heading),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.error_screen_dividing_space)))

        Text(
            text = stringResource(R.string.no_internet_description),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            textAlign = TextAlign.Center
        )
    }
}
