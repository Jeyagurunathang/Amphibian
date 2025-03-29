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
    val amphibianViewModel: AmphibianViewModel = viewModel()

    Column (
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = amphibianViewModel.amphibianUiState.amphibianData,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AmphibianTheme {
        Greeting("Android")
    }
}