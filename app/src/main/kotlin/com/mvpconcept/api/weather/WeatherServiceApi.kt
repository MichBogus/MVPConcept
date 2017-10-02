package com.mvpconcept.api.weather

import io.reactivex.Single

interface WeatherServiceApi {

    fun getWeatherByCityName(cityName: String): Single<Any>
}