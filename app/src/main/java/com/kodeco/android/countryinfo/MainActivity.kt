package com.kodeco.android.countryinfo

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.kodeco.android.countryinfo.network.CountriesApi
import com.kodeco.android.countryinfo.network.Country
import com.kodeco.android.countryinfo.network.ApiClient
import com.kodeco.android.countryinfo.network.CountryUIState
import com.kodeco.android.countryinfo.network.RetrofitClient
import com.kodeco.android.countryinfo.ui.components.CountryErrorScreen
import com.kodeco.android.countryinfo.ui.components.CountryInfoScreen
import com.kodeco.android.countryinfo.ui.components.Loading
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.parcelize.Parcelize
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {

    //add moshi parser
    //retrieve data to display in sealed class

    val countriesAndCapitals: MutableMap<String, String> = mutableMapOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                var uiState: CountryUIState by rememberSaveable { mutableStateOf(CountryUIState.Loading) }

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    @Composable
                    fun displayState() {
                        val countriesAndCapitals: MutableMap<String, String> = mutableMapOf()
                        when(val countryUIState = uiState) {
                            is CountryUIState.Loaded -> {
                                for (element in 0..<countryUIState.countries.size) {
                                    countriesAndCapitals[countryUIState.countries[element].commonName] =
                                        countryUIState.countries[element].capital.toString()
                                            .replace("[", "").replace("]", "")
                                }
                                CountryInfoScreen(countriesAndCapitals)
                            }
                            CountryUIState.Loading -> Loading()
                            is CountryUIState.Error -> CountryErrorScreen()
                        }
                    }

                    displayState()

                    LaunchedEffect(Unit) {
                        delay(5000)
                        uiState = try {
                            CountryUIState.Loaded(RetrofitClient.service.fetchCountries())
                        } catch (exception: Exception) {
                            CountryUIState.Error(exception)
                        }
                    }
                }
            }
        }
    }
}
