package com.kodeco.android.countryinfo.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kodeco.android.countryinfo.network.CountryUIState

@Composable
fun CountryInfoScreen(
    uiState: CountryUIState,
    navController: NavController
) {
    when (uiState) {
        is CountryUIState.Loaded -> {
            CountryInfoList(
                uiState.countries,
                navController
            )
        }

        CountryUIState.Loading -> Loading()
        is CountryUIState.Error -> CountryErrorScreen()
    }
}

@Preview
@Composable
fun CountryInfoScreenPreview() {
    var uiState = CountryUIState.Loading
    CountryInfoScreen(uiState, rememberNavController())
}
