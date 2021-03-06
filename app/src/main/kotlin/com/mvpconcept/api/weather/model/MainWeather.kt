package com.mvpconcept.api.weather.model

import com.google.gson.annotations.SerializedName

data class MainWeather(@SerializedName("temp") val temperature: Double,
        @SerializedName("pressure") val pressure: Double)