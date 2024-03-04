package com.kodeco.android.countryinfo.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.kodeco.android.countryinfo.network.CountriesUIState
import com.kodeco.android.countryinfo.network.CountryUIState

@Composable
fun CountryInfoScreen(
    uiState: CountriesUIState,
    navController: NavController
    ) {
    when (uiState) {
        is CountriesUIState.Loaded -> {
            CountryInfoList(
                uiState.countries,
                navController)
        }

        CountriesUIState.Loading -> Loading()
        is CountriesUIState.Error -> CountryErrorScreen()
    }
}

@Preview
@Composable
fun CountryInfoScreenPreview() {
//    var uiState = CountriesUIState.Loading
//    CountryInfoScreen(uiState)
}
