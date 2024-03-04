package com.kodeco.android.countryinfo.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class CountryUIState : Parcelable {

    data class Loaded(val country: Country) : CountryUIState()

    object Loading : CountryUIState()

    data class Error(val exception: Throwable) : CountryUIState()
}