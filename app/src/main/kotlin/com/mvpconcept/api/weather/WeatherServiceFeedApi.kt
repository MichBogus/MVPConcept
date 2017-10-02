package com.mvpconcept.api.weather

import io.reactivex.Single
import retrofit2.Response

interface WeatherServiceFeedApi {

    fun getWeatherByCityName(cityName: String): Single<Any>
}