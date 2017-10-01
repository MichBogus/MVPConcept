package com.mvpconcept.injection

import com.mvpconcept.mvp.weatheractivity.WeatherPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideWeatherPresenter() =
            WeatherPresenter()
}