package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.network.Country

@Composable
fun CountryInfoList(
    countries: List<Country>
) {
    LazyColumn {
        items(countries.size) {
            countries.forEach { country ->
                CountryInfoRow(country)
            }
        }
    }
}

@Preview
@Composable
fun CountryInfoListPreview() {
    val mockData = mutableMapOf<String, String>()
    mockData.put("UK", "London")
    mockData.put("USA", "Washington DC")
    mockData.put("Spain", "Madrid")
    mockData.put("France", "Paris")
//    LazyColumn {
//        items(mockData.size) {
//            for ((key, value) in mockData) {
//                CountryInfoRow(countryName = key, capitalName = value)
//            }
//        }
//    }
}
