package com.example.amphibian.ui.uilayer.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.amphibian.R

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    size: Int = R.dimen.loader_width,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    trackColor: Color = MaterialTheme.colorScheme.secondary,
    strokeCap: StrokeCap = StrokeCap.Round
) {
    Box (
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(dimensionResource(size)),
            color = color,
            trackColor = trackColor,
            strokeCap = strokeCap
        )
    }
}