package com.kodeco.android.countryinfo

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.kodeco.android.countryinfo.network.CountriesApi
import com.kodeco.android.countryinfo.network.Country
import com.kodeco.android.countryinfo.network.RetrofitInstance
import com.kodeco.android.countryinfo.ui.components.CountryInfoScreen
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.parcelize.Parcelize
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class MainActivity : ComponentActivity() {

    //add moshi parser
    //retrieve data to display in sealed class
    private val retrofit = Retrofit.Builder()
        .baseUrl(RetrofitInstance.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create().asLenient())
        .build()

    private val service: CountriesApi = retrofit.create(CountriesApi::class.java)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                var uiState: CountryUIState by rememberSaveable { mutableStateOf(CountryUIState.Loading) }

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val stateStr = when(val countryUIState = uiState) {
                        is CountryUIState.Loaded -> "Loaded with ${countryUIState.countries.size} countries"
                        CountryUIState.Loading -> "Loading..."
                        is CountryUIState.Error -> "Error occured: ${countryUIState.exception}"
                    }

                    Text(text = stateStr)

                    LaunchedEffect(Unit) {
                        delay(5000)
                        uiState = try {
                            CountryUIState.Loaded(service.fetchCountries())
                        } catch (exception: Exception) {
                            CountryUIState.Error(exception)
                        }
                    }
                }
            }
        }
    }
}

@Parcelize
sealed class CountryUIState: Parcelable {

    data class Loaded(val countries: List<Country>): CountryUIState()

    object Loading: CountryUIState()

    data class Error(val exception: Throwable): CountryUIState()
}
