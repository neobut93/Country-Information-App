package com.kodeco.android.countryinfo.network

import retrofit2.Response
import retrofit2.http.GET


interface CountriesApi {

    @GET("all")
    suspend fun fetchCountries(): Response<List<Country>>
}