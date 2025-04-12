package com.example.amphibian.ui.uilayer

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibian.R
import com.example.amphibian.ui.theme.AmphibianTheme

@Composable
fun DetailScreenHeader(
    modifier: Modifier = Modifier,
    amphibianName: String = "Great Basin Spadefoot",
    onBackArrowPressed: () -> Unit
) {
    Row (
        modifier = Modifier.fillMaxWidth().padding(horizontal = dimensionResource(R.dimen.app_side_padding)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBackArrowPressed
        ) {
            Icon(
                painter = painterResource(R.drawable.back_arrow),
                contentDescription = "Back Arrow",
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.size(dimensionResource(R.dimen.back_arrow))
            )
        }

        Text(
            text = amphibianName,
            style = MaterialTheme.typography.bodySmall,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DetailScreenHeaderPreview() {
//    AmphibianTheme(dynamicColor = false) {
//        DetailScreenHeader()
//    }
//}