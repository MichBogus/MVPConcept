package com.mvpconcept.api.weather

import io.reactivex.Single

interface WeatherServiceFeedApi {

    fun getWeatherByCityName(cityName: String): Single<Any>
}