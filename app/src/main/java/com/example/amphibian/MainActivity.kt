package com.example.amphibian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibian.ui.theme.AmphibianTheme
import com.example.amphibian.ui.uilayer.AmphibianApp
import com.example.amphibian.uistate.AmphibianUiState
import com.example.amphibian.viewmodel.AmphibianViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AmphibianTheme(dynamicColor = false) {
                Surface {
                    AmphibianApp(modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.app_side_padding)))
                }
            }
        }
    }
}