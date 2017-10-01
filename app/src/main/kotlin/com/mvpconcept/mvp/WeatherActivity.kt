package com.mvpconcept.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mvpconcept.application.MVPConceptApplication
import com.mvpconcept.mvp.weatheractivity.WeatherPresenter
import com.mvpconcept.mvp.weatheractivity.WeatherView
import javax.inject.Inject

class WeatherActivity : AppCompatActivity(), WeatherView {

    @Inject lateinit var presenter: WeatherPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MVPConceptApplication).injector.inject(this)
    }
}