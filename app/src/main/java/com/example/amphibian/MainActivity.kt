package com.example.amphibian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibian.ui.theme.AmphibianTheme
import com.example.amphibian.uistate.AmphibianUiState
import com.example.amphibian.viewmodel.AmphibianViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val amphibianViewModel: AmphibianViewModel = viewModel(factory = AmphibianViewModel.Factory)
            AmphibianTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val amphibianViewModel: AmphibianViewModel = viewModel(factory = AmphibianViewModel.Factory)
    val amphibianUiState = amphibianViewModel.amphibianUiState

    Column (
        modifier = modifier.fillMaxSize()
    ) {
        when (amphibianUiState) {
            is AmphibianUiState.Success -> {
                Text(
                    text = "${amphibianUiState.amphibianData[0].name} of type ${amphibianUiState.amphibianData[0].type}",
                    modifier = modifier
                )
            }
            is AmphibianUiState.Error -> {
                Text(
                    text = "Error",
                    modifier = modifier
                )
            }
            is AmphibianUiState.Loading -> {
                Text(
                    text = "Loading",
                    modifier = modifier
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AmphibianTheme {
        Greeting("Android")
    }
}