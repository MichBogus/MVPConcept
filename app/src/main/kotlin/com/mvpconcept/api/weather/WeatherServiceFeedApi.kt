package com.mvpconcept.api.weather

import com.mvpconcept.api.weather.model.WeatherForLocation
import io.reactivex.Single
import retrofit2.Response

interface WeatherServiceFeedApi {

    fun getWeatherByCityName(cityName: String): Single<WeatherForLocation>
}