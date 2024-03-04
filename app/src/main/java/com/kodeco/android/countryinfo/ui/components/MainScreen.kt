package com.kodeco.android.countryinfo.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kodeco.android.countryinfo.network.CountriesUIState

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

        ) {
            CountryDetailsScreen(
                countryName = it.arguments?.getString("countryName"),
                capital = it.arguments?.getString("capital"),
                population = it.arguments?.getLong("population"),
                area = it.arguments?.getInt("area"),
                flag = it.arguments?.getString("flag"),
                onNavigateBack = { navController.navigateUp() }
            )
        }
    }
}