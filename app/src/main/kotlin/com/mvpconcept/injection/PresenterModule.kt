package com.mvpconcept.injection

import com.mvpconcept.api.scheduler.SchedulerApi
import com.mvpconcept.api.weather.WeatherServiceApi
import com.mvpconcept.mvp.weatheractivity.WeatherPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideWeatherPresenter(schedulerApi: SchedulerApi, weatherServiceApi: WeatherServiceApi) =
            WeatherPresenter(schedulerApi, weatherServiceApi)
}