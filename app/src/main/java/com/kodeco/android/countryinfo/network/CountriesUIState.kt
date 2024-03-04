package com.kodeco.android.countryinfo.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class CountriesUIState : Parcelable {

    data class Loaded(val countries: List<Country>) : CountriesUIState()

    object Loading : CountriesUIState()

    data class Error(val exception: Throwable) : CountriesUIState()
}