package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CountryInfoScreen(
    countries: MutableMap<String, String>
) {
    LazyColumn {
        items(countries.size) {
            for ((key, value) in countries) {
                CountryInfoRow(countryName = key, capitalName = value)
            }
        }
    }
}

@Preview
@Composable
fun CountryInfoScreenPreview() {
    val mockData = mutableMapOf<String, String>()
    mockData.put("UK", "London")
    mockData.put("USA", "Washington DC")
    mockData.put("Spain", "Madrid")
    mockData.put("France", "Paris")
    LazyColumn {
        items(mockData.size) {
            for ((key, value) in mockData) {
                CountryInfoRow(countryName = key, capitalName = value)
            }
        }
    }
}
