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
import com.kodeco.android.countryinfo.network.CountryUIState
import com.kodeco.android.countryinfo.network.RetrofitClient
import com.kodeco.android.countryinfo.ui.components.CountryInfoScreen
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                var uiState: CountryUIState by rememberSaveable { mutableStateOf(CountryUIState.Loading) }
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CountryInfoScreen(uiState)
                    LaunchedEffect(Unit) {
                        delay(3000)
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
