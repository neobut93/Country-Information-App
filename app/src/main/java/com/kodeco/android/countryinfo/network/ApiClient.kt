package com.kodeco.android.countryinfo.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {

    const val BASE_URL = "https://restcountries.com/v3.1/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create().asLenient())
        .build()

}

object RetrofitClient {
    val service: CountriesApi = ApiClient.retrofit.create(CountriesApi::class.java)
}