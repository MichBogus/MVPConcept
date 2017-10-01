package com.mvpconcept.injection;

import com.mvpconcept.mvp.WeatherActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        NetworkModule.class,
        PresenterModule.class,
        SchedulerModule.class,
        ServiceModule.class
})
public interface InjectionComponent {
    void inject(WeatherActivity activity);
}
