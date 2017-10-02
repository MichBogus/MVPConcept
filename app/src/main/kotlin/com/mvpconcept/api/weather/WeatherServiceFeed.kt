package com.mvpconcept.api.weather

import com.mvpconcept.api.base.BaseService
import io.reactivex.Single
import okhttp3.OkHttpClient

class WeatherServiceFeed(okHttpClient: OkHttpClient) : BaseService<WeatherRetrofitApi>(okHttpClient), WeatherServiceFeedApi {

    override fun getWeatherByCityName(cityName: String): Single<Any> =
            restAdapter().getWeatherByCityName(cityName)

    override fun getGenericParameter(): Class<WeatherRetrofitApi> =
            WeatherRetrofitApi::class.java
}