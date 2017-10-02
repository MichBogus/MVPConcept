package com.mvpconcept.mvp

import com.mvpconcept.api.scheduler.SchedulerApi
import com.mvpconcept.api.weather.WeatherServiceApi
import com.mvpconcept.api.weather.model.Coordinations
import com.mvpconcept.api.weather.model.MainWeather
import com.mvpconcept.api.weather.model.WeatherForLocation
import com.mvpconcept.mvp.weatheractivity.WeatherPresenter
import com.mvpconcept.mvp.weatheractivity.WeatherView
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import io.reactivex.functions.Consumer
import org.junit.Before
import org.junit.Test

class WeatherPresenterTest {

    lateinit var systemUnderTest: WeatherPresenter
    val mockOfScheduler = mock<SchedulerApi>()
    val mockOfWeatherServiceApi = mock<WeatherServiceApi>()
    val mockOfView = mock<WeatherView>()

    @Before
    fun setUp() {
        systemUnderTest = spy(WeatherPresenter(mockOfScheduler, mockOfWeatherServiceApi))

        systemUnderTest.attachView(mockOfView)
    }

    @Test
    fun shouldDoNothingWhenLocationNameIsShort() {
        val locationName = "12"

        systemUnderTest.downloadTemperatureForCity(locationName)

        verifyNoMoreInteractions(mockOfScheduler)
        verifyNoMoreInteractions(mockOfWeatherServiceApi)
        verifyNoMoreInteractions(mockOfView)
    }

    @Test
    fun shouldShowLocationTemperatureProperly() {
//        val locationName = "12333"
//
//        whenever(mockOfWeatherServiceApi.getWeatherByCityName(locationName)).thenReturn(Single.just(weatherForLocation()))
//
//        systemUnderTest.downloadTemperatureForCity(locationName)
//
//        verify(mockOfView).showTemperatureForLocation("Toronto", "20.0")
    }

    private fun weatherForLocation() =
            WeatherForLocation(Coordinations(),
                    emptyList(),
                    "test",
                    MainWeather(20.0, 20.0),
                    100,
                    1,
                    200,
                    "Toronto")
}