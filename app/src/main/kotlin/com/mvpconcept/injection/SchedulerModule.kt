package com.mvpconcept.injection

import com.mvpconcept.api.scheduler.AndroidScheduler
import com.mvpconcept.api.scheduler.AndroidSubscriptions
import com.mvpconcept.api.scheduler.SchedulerApi
import com.mvpconcept.api.scheduler.SubscriptionsApi
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
class SchedulerModule {

    @Provides
    fun provideAndroidSubscriptions(): SubscriptionsApi =
            AndroidSubscriptions()

    @Provides
    fun provideAndroidScheduler(subscriptionsApi: SubscriptionsApi): SchedulerApi =
            AndroidScheduler(Schedulers.io(), AndroidSchedulers.mainThread(), subscriptionsApi)
}