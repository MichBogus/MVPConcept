package com.mvpconcept.application

import android.support.multidex.MultiDexApplication
import com.mvpconcept.injection.DaggerInjectionComponent
import com.mvpconcept.injection.InjectionComponent

class MVPConceptApplication : MultiDexApplication() {

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