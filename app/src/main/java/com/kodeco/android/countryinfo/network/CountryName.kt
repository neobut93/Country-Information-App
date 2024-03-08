package com.kodeco.android.countryinfo.network

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class CountryName(
    @field:Json(name = "common")
    val common: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class CountryFlags(
    @field:Json(name = "png")
    val png: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Country(
    @field:Json(name = "name")
    val name: CountryName,
    @field:Json(name = "capital")
    val capital: List<String>?,
    @field:Json(name = "population")
    val population: Long,
    @field:Json(name = "area")
    val area: Double,
    @field:Json(name = "flags")
    val flags: CountryFlags,
    @field:Json(name = "commonName")
    val commonName: String = name.common,
    @field:Json(name = "flagsPng")
    val flagsPng: String = flags.png,
) : Parcelable {
    @IgnoredOnParcel
    val firstCapital = capital?.first() ?: "no capital defined"
}

