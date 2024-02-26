package com.kodeco.android.countryinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kodeco.android.countryinfo.network.RetrofitInstance
import com.kodeco.android.countryinfo.ui.components.CountryInfoScreen
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RetrofitInstance.getCountriesData()
        // note: UI takes several minutes to load, I think it's because of the way I am supplying LazyColumn by data
        setContent {
            MyApplicationTheme {
                CountryInfoScreen(RetrofitInstance.countriesAndCapitals)
            }
        }
    }
}
