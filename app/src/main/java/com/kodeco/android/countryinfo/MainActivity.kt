package com.kodeco.android.countryinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.kodeco.android.countryinfo.network.CountriesUIState
import com.kodeco.android.countryinfo.network.RetrofitClient
import com.kodeco.android.countryinfo.ui.components.MainScreen
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                var uiState: CountriesUIState by rememberSaveable { mutableStateOf(CountriesUIState.Loading) }
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreen(uiState)
                    LaunchedEffect(Unit) {
                        delay(3000)
                        uiState = try {
                            CountriesUIState.Loaded(RetrofitClient.service.fetchCountries())
                        } catch (exception: Exception) {
                            CountriesUIState.Error(exception)
                        }
                    }
                }
            }
        }
    }
}
