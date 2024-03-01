package com.kodeco.android.countryinfo.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.network.CountryUIState
import com.kodeco.android.countryinfo.utils.UtilMethods

@Composable
fun CountryInfoScreen(
    uiState: CountryUIState
) {
    when(uiState) {
        is CountryUIState.Loaded -> {
            CountryInfoList(UtilMethods.getCountryNamesAndCapitals(uiState))
        }
        CountryUIState.Loading -> Loading()
        is CountryUIState.Error -> CountryErrorScreen()
    }
}

@Preview
@Composable
fun CountryInfoScreenPreview() {
}
