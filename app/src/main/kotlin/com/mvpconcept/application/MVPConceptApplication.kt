package com.mvpconcept.application

import android.support.multidex.MultiDexApplication
import com.mvpconcept.injection.*

class MVPConceptApplication : MultiDexApplication() {

    lateinit var injector: InjectionComponent

    override fun onCreate() {
        super.onCreate()

        buildInjector()
    }

    private fun buildInjector() {
        injector = DaggerInjectionComponent
                .builder()
                .networkModule(NetworkModule())
                .presenterModule(PresenterModule())
                .schedulerModule(SchedulerModule())
                .serviceModule(ServiceModule())
                .build()
    }
}