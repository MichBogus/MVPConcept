package com.mvpconcept.api.weather

import com.mvpconcept.api.weather.model.WeatherForLocation
import io.reactivex.Single
import retrofit2.Response

class WeatherService(val weatherServiceFeedApi: WeatherServiceFeedApi): WeatherServiceApi {

    override fun getWeatherByCityName(cityName: String): Single<WeatherForLocation> =
            weatherServiceFeedApi.getWeatherByCityName(cityName)
}