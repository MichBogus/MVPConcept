package com.mvpconcept.mvp.weatheractivity

interface WeatherView {

    fun showTemperatureForLocation(location: String, temperature: String)
    fun showError(error: String)
}