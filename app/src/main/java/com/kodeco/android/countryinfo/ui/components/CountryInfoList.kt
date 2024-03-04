package com.kodeco.android.countryinfo.ui.components

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.kodeco.android.countryinfo.network.Country
import com.kodeco.android.countryinfo.network.CountryFlags
import com.kodeco.android.countryinfo.network.CountryName
import com.kodeco.android.countryinfo.network.CountryUIState
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme

@Composable
fun CountryInfoList(
    countries: List<Country>,
    onNavigateToDetails: () -> Unit
) {
    LazyColumn {
        items(countries.size) {
            countries.forEach { country ->
                CountryInfoRow(
                    country,
                    onNavigateToDetails
                )
            }
        }
    }
}

@Preview
@Composable
fun CountryInfoListPreview() {
    val countryName = CountryName(
        "France"
    )
    val countryFlags = CountryFlags(
        "flag"
    )
//    val country = Country(
//        countryName,
//        listOf("Paris"),
//        123L,
//        123.12,
//        countryFlags,
//        countryName.common,
//        "png"
//    )
    val mockedListOfCountries = arrayListOf<Country>()
//    mockedListOfCountries.add(country)
//    MyApplicationTheme {
//        CountryInfoList(countries = mockedListOfCountries)
//    }
}
