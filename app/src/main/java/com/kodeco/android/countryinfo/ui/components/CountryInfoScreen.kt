package com.kodeco.android.countryinfo.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.network.CountryUIState

@Composable
fun CountryInfoScreen(
    uiState: CountryUIState
) {
    when(uiState) {
        is CountryUIState.Loaded -> {
            CountryInfoList(uiState.countries)
        }
        CountryUIState.Loading -> Loading()
        is CountryUIState.Error -> CountryErrorScreen()
    }
}

@Preview
@Composable
fun CountryInfoScreenPreview() {
    var uiState = CountryUIState.Loading
    CountryInfoScreen(uiState)
}
