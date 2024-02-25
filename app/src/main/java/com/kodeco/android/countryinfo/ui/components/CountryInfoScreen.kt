package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kodeco.android.countryinfo.network.Country

// TODO fill out CountryInfoScreen
@Composable
fun CountryInfoScreen(
    country: List<Country>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(country.size) { con ->

        }
    }
}

// TODO fill out the preview.
@Preview
@Composable
fun CountryInfoScreenPreview() { }
