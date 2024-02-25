package com.kodeco.android.countryinfo.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    val countries =  arrayListOf<String>()
    val capitals = arrayListOf<String>()

    val BASE_URL = "https://restcountries.com/v3.1/"

    val api: CountriesApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()
            .create(CountriesApi::class.java)
    }

    fun getCountriesData() {
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