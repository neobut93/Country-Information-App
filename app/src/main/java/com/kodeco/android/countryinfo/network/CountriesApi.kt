package com.kodeco.android.countryinfo.network

import retrofit2.Call
import retrofit2.http.GET


interface CountriesApi {

    @GET("all")
    fun fetchCountries(): Call<List<Country>>
}