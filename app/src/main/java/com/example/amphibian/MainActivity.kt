package com.example.amphibian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.amphibian.network.AmphibianData
import com.example.amphibian.ui.theme.AmphibianTheme
import com.example.amphibian.ui.uilayer.AmphibianApp
import com.example.amphibian.ui.uilayer.AmphibianDetailScreen
import com.example.amphibian.ui.uilayer.DetailScreenBody
import com.example.amphibian.ui.uilayer.components.AmphibianScreens
import com.example.amphibian.ui.uilayer.components.LoadingScreen
import com.example.amphibian.uistate.AmphibianUiState
import com.example.amphibian.viewmodel.AmphibianViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val amphibianViewModel: AmphibianViewModel = viewModel(factory = AmphibianViewModel.Factory)
            val amphibianUiState: AmphibianUiState = amphibianViewModel.amphibianUiState

            val navController = rememberNavController()

            AmphibianTheme(dynamicColor = false) {
                Surface {
                    NavHost(
                        navController = navController,
                        startDestination = AmphibianScreens.HOME.name
                    ) {
                        composable(
                            route = AmphibianScreens.HOME.name,
                            exitTransition = {
                                slideOutHorizontally(animationSpec = tween(500))
                            },
                            popEnterTransition = {
                                slideInHorizontally(animationSpec = tween(500))
                            }
                        ) {
                            AmphibianApp(
                                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.app_side_padding)),
                                amphibianViewModel = amphibianViewModel,
                                amphibianUiState =  amphibianUiState,
                                onAmphibianClicked = { it ->
                                    amphibianViewModel.updateCurrentAmphibianData(it)
                                    navController.navigate(AmphibianScreens.DETAILS.name) 
                                }
                            )
                        }

                        composable(
                            route = AmphibianScreens.DETAILS.name,
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                    tween(500)
                                )
                            },
                            popExitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                                    animationSpec = tween(500)
                                )
                            }
                        ) {
                            AmphibianDetailScreen(
                                amphibianData = amphibianViewModel.selectedAmphibian,
                                onBackArrowPressed = { navController.navigateUp() }
                            )
                        }
                    }

//                    AmphibianApp(modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.app_side_padding)))
                }
            }
        }
    }
}