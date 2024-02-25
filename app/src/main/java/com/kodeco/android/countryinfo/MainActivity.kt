package com.kodeco.android.countryinfo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.kodeco.android.countryinfo.network.RetrofitInstance
import com.kodeco.android.countryinfo.network.Country
import com.kodeco.android.countryinfo.network.CountryName
import com.kodeco.android.countryinfo.ui.components.CountryInfoScreen
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

const val TAG = "Main Activity"

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            val response = try {
                RetrofitInstance.api.fetchCountries()
            } catch (_: IOException) {
                Log.e(TAG, "IOException, you don't have internet connection")
                return@launch
            } catch (_: HttpException) {
                Log.e(TAG, "HttpException, unexpected response")
                return@launch
            }
            if(response.isSuccessful && response.body() != null) {
                Log.d("GGG", response.body().toString())
            }
        }




        setContent {
            MyApplicationTheme {
                // TODO complete the composable content and provide
                //  models for Country, CountryName, and CountryFlags.
                CountryInfoScreen()
            }
        }
    }
}
