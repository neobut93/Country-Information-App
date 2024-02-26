package com.kodeco.android.countryinfo.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    val countriesAndCapitals: MutableMap<String, String> = mutableMapOf()

    const val BASE_URL = "https://restcountries.com/v3.1/"

    val api: CountriesApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()
            .create(CountriesApi::class.java)
    }

    fun getCountriesData() {
        val retrofitData = api.fetchCountries()
        retrofitData.enqueue(object : Callback<List<Country>?> {
            override fun onResponse(
                call: Call<List<Country>?>,
                response: Response<List<Country>?>
            ) {
                val responseBody = response.body()
                if (responseBody != null) {
                    for(element in responseBody) {
                        countriesAndCapitals[element.commonName] = element.capital?.get(0) ?: "Capital is not defined"
                    }
                }
            }
            override fun onFailure(call: Call<List<Country>?>, t: Throwable) {
                Log.e("Error", "List of ounties are not present")
            }
        })
    }
}