package com.mvpconcept.api.weather

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRetrofitApi {

    @GET("weather")
    fun getWeatherByCityName(@Query("q") cityName: String, @Query("APPID") appId: String = "61977114ffddad9c2ba991c3f74c7965"): Single<Any>
}