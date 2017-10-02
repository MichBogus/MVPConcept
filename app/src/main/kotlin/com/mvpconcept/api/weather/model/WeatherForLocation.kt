package com.mvpconcept.api.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherForLocation(@SerializedName("coord") val coordinations: Coordinations,
                              @SerializedName("weather") val weather: List<Weather>,
                              @SerializedName("base") val base: String,
                              @SerializedName("main") val mainWeather: MainWeather,
                              @SerializedName("visibility") val visibility: Long,
                              @SerializedName("id") val id: Long,
                              @SerializedName("cod") val code: Int,
                              @SerializedName("name") val name: String)