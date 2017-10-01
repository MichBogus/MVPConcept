package com.mvpconcept.api.weather

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRetrofitApi {

    @GET("weather")
    fun getWeatherByCityName(@Query("q") cityName: String): Single<Any>
}