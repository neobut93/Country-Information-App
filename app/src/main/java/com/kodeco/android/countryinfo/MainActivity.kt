package com.kodeco.android.countryinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kodeco.android.countryinfo.network.CountriesApi
import com.kodeco.android.countryinfo.network.Country
import com.kodeco.android.countryinfo.network.RetrofitInstance
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val TAG = "Main Activity"

class MainActivity : ComponentActivity() {

    val countries =  arrayListOf<String>()
    val capitals = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMyData()

    //todo proper UI with all components and data from API




        setContent {
            MyApplicationTheme {
                // TODO complete the composable content and provide
                //  models for Country, CountryName, and CountryFlags.
                //CountryInfoScreen()
                LazyColumn {
                    items(countries.size) {
                        Text(text = countries[it],
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(15.dp)
                            )
//                        Text(text = capitals[it],
//                            fontSize = 30.sp,
//                            modifier = Modifier
//                                .padding(vertical = 15.dp)
//                        )
                    }
                }
            }
        }
    }

    private fun getMyData() {
        var dual: MutableMap<String, String> = mutableMapOf()
        var countryName = ArrayList<String>()
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(RetrofitInstance.BASE_URL)
            .build()
            .create(CountriesApi::class.java)

        val retrofitData = retrofitBuilder.fetchCountries()

        retrofitData.enqueue(object : Callback<List<Country>?> {
            override fun onResponse(
                call: Call<List<Country>?>,
                response: Response<List<Country>?>
            ) {
                val responseBody = response.body()
                if (responseBody != null) {
                    for(element in responseBody) {
                        //element.capital?.get(0)?.let { dual.put(element.name.common, it) }
                        countries.add(element.commonName)
                        capitals.add(element.capital?.get(0) ?: "capital is not defined")
                    }
                }
            }

            override fun onFailure(call: Call<List<Country>?>, t: Throwable) {

            }
        })
    }
}
