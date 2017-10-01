package com.mvpconcept.api.weather

import io.reactivex.Single
import retrofit2.http.Query

interface WeatherServiceApi {

    fun getWeatherByCityName(cityName: String): Single<Any>
}