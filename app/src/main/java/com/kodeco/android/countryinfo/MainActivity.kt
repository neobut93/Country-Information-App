package com.kodeco.android.countryinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kodeco.android.countryinfo.network.CountriesUIState
import com.kodeco.android.countryinfo.network.RetrofitClient
import com.kodeco.android.countryinfo.ui.components.CountryDetailsScreen
import com.kodeco.android.countryinfo.ui.components.CountryInfoScreen
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                var uiState: CountriesUIState by rememberSaveable { mutableStateOf(CountriesUIState.Loading) }
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreen(uiState)
                    LaunchedEffect(Unit) {
                        delay(3000)
                        uiState = try {
                            CountriesUIState.Loaded(RetrofitClient.service.fetchCountries())
                        } catch (exception: Exception) {
                            CountriesUIState.Error(exception)
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun MainScreen(uiState: CountriesUIState) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "countryInfoScreen") {
        composable("countryInfoScreen") {
            CountryInfoScreen(uiState = uiState, navController = navController)
        }
        composable("countryDetailsScreen?country={countryName}&capital={capital}&population={population}&area={area}&flag={flag}",
            arguments = listOf(
                navArgument(name = "countryName") {
                type = NavType.StringType
            },
                navArgument(name = "capital") {
                    type = NavType.StringType
                },
                navArgument(name = "population") {
                    type = NavType.LongType
                },
                navArgument(name = "area") {
                    type = NavType.IntType
                },
                navArgument(name = "flag") {
                    type = NavType.StringType
                }
            )

            ) { CountryDetailsScreen(
                countryName = it.arguments?.getString("countryName"),
            capital = it.arguments?.getString("capital"),
            population = it.arguments?.getLong("population"),
            area = it.arguments?.getInt("area"),
            flag = it.arguments?.getString("flag"),
                onNavigateBack = { navController.navigateUp()}
        ) }
    }
}
