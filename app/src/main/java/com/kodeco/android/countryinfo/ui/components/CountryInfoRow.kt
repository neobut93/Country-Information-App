package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.kodeco.android.countryinfo.R
import com.kodeco.android.countryinfo.network.Country
import com.kodeco.android.countryinfo.network.CountryFlags
import com.kodeco.android.countryinfo.network.CountryName
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme

@Composable
fun CountryInfoRow(
    country: Country,
    //onItemClick: (Country) -> Unit,
    onNavigateToDetails: () -> Unit
) {
    val countryName = country.commonName
    val capitalCapital = country.firstCapital
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(
                start = 10.dp,
                end = 10.dp,
                top = 15.dp
            )
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(15.dp))
            .background(Color(0xFFE8EAF6))
            .clickable {
                //onItemClick(country)
                onNavigateToDetails()
            }
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.country_name, countryName),
                Modifier.padding(
                    top = 5.dp
                )
            )
        }
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.capital_name, capitalCapital),
                Modifier.padding(
                    bottom = 5.dp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryInfoRowPreview() {
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
    //MyApplicationTheme { CountryInfoRow(country, ) }
}
