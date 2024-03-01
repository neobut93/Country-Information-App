package com.kodeco.android.countryinfo.utils

import com.kodeco.android.countryinfo.network.CountryUIState

object UtilMethods {

    fun getCountryNamesAndCapitals(countryUIState: CountryUIState.Loaded): MutableMap<String, String> {
        val mapOfCountryNamesAndCapitals: MutableMap<String, String> = mutableMapOf()
        for (element in 0..<countryUIState.countries.size) {
            mapOfCountryNamesAndCapitals[countryUIState.countries[element].commonName] =
                countryUIState.countries[element].capital.toString()
                    .replace("[", "").replace("]", "")
        }
        return mapOfCountryNamesAndCapitals
    }
}