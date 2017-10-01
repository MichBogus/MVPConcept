package com.mvpconcept.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mvpconcept.R
import com.mvpconcept.application.MVPConceptApplication
import com.mvpconcept.mvp.utils.SimpleTextWatcher
import com.mvpconcept.mvp.weatheractivity.WeatherPresenter
import com.mvpconcept.mvp.weatheractivity.WeatherView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class WeatherActivity : AppCompatActivity(), WeatherView {

    @Inject lateinit var presenter: WeatherPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MVPConceptApplication).injector.inject(this)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    private fun setListeners() {
        edit_text_city_name.addTextChangedListener(SimpleTextWatcher { presenter.downloadTemperatureForCity(it) })
    }
}