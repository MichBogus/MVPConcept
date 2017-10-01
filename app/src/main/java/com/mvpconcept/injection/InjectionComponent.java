package com.mvpconcept.injection;

import com.mvpconcept.WeatherActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {

})
public interface InjectionComponent {
    void inject(WeatherActivity activity);
}
