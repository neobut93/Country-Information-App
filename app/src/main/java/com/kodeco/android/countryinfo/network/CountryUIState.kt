package com.kodeco.android.countryinfo.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class CountryUIState : Parcelable {

    data class Loaded(val countries: List<Country>) : CountryUIState()

    object Loading : CountryUIState()

    data class Error(val exception: Throwable) : CountryUIState()
}