package com.mvpconcept.api.weather

import io.reactivex.Single

class WeatherService(val weatherServiceFeedApi: WeatherServiceFeedApi): WeatherServiceApi {

    override fun getWeatherByCityName(cityName: String): Single<Any> =
            weatherServiceFeedApi.getWeatherByCityName(cityName)
}