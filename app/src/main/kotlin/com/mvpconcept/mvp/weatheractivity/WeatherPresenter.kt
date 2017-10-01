package com.mvpconcept.mvp.weatheractivity

import com.mvpconcept.api.scheduler.SchedulerApi
import com.mvpconcept.api.weather.WeatherServiceApi
import com.mvpconcept.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class WeatherPresenter(val scheduler: SchedulerApi,
                       val weatherServiceApi: WeatherServiceApi) : BasePresenter<WeatherView>() {

    fun downloadTemperatureForCity(cityName: String) {
        if (cityName.length < 4)
            return

        scheduler.schedule(weatherServiceApi.getWeatherByCityName(cityName),
                Consumer {
                    val checkIt = it
                },
                Consumer {
                    val checkIt = it
                },
                this)

        weatherServiceApi.getWeatherByCityName(cityName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    val checkIt = it
                }, {
                    val checkIt = it
                })
    }

}