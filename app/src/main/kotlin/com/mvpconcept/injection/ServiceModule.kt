package com.mvpconcept.injection

import com.mvpconcept.api.weather.WeatherService
import com.mvpconcept.api.weather.WeatherServiceApi
import com.mvpconcept.api.weather.WeatherServiceFeed
import com.mvpconcept.api.weather.WeatherServiceFeedApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class ServiceModule {

    @Provides
    fun provideWeatherServiceFeed(okHttpClient: OkHttpClient): WeatherServiceFeedApi =
            WeatherServiceFeed(okHttpClient)

    @Provides
    fun provideWeatherService(weatherServiceFeedApi: WeatherServiceFeedApi): WeatherServiceApi =
            WeatherService(weatherServiceFeedApi)
}