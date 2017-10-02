package com.mvpconcept.mvp.weatheractivity

import com.mvpconcept.api.scheduler.SchedulerApi
import com.mvpconcept.api.weather.WeatherServiceApi
import com.mvpconcept.api.weather.model.WeatherForLocation
import com.mvpconcept.base.BasePresenter
import io.reactivex.functions.Consumer

open class WeatherPresenter(val scheduler: SchedulerApi,
                            val weatherServiceApi: WeatherServiceApi) : BasePresenter<WeatherView>() {

    fun downloadTemperatureForCity(cityName: String) {
        if (cityName.length < 4)
            return

        scheduler.schedule(weatherServiceApi.getWeatherByCityName(cityName),
                Consumer { handleOnSuccess(it) },
                Consumer { handleOnError() },
                this)
    }

    private fun handleOnSuccess(weatherForLocation: WeatherForLocation) {
        view?.showTemperatureForLocation(weatherForLocation.name, weatherForLocation.mainWeather.temperature.toString())
    }

    private fun handleOnError() {
        view?.showError("Sorry there is no data for that location")
    }

}