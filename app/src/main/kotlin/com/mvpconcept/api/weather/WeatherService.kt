package com.mvpconcept.api.weather

import io.reactivex.Single
import retrofit2.Response

class WeatherService(val weatherServiceFeedApi: WeatherServiceFeedApi): WeatherServiceApi {

    override fun getWeatherByCityName(cityName: String): Single<Any> =
            weatherServiceFeedApi.getWeatherByCityName(cityName)
}