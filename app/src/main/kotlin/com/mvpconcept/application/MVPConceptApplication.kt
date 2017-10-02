package com.mvpconcept.application

import android.app.Application
import com.mvpconcept.injection.DaggerInjectionComponent
import com.mvpconcept.injection.InjectionComponent

class MVPConceptApplication : Application() {

    lateinit var injector: InjectionComponent

    override fun onCreate() {
        super.onCreate()

        buildInjector()
    }

    private fun buildInjector() {
        injector = DaggerInjectionComponent
                .builder()

                .build()
    }
}