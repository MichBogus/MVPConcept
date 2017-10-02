package com.mvpconcept.api.weather

import com.mvpconcept.api.weather.model.WeatherForLocation
import io.reactivex.Single

interface WeatherServiceApi {

    fun getWeatherByCityName(cityName: String): Single<WeatherForLocation>
}