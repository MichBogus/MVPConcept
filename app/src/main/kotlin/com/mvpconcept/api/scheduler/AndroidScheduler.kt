package com.mvpconcept.api.scheduler

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.functions.Consumer

class AndroidScheduler(val subscribeOnScheduler: Scheduler, val observeOnScheduler: Scheduler, val subscriptions: SubscriptionsApi) : SchedulerApi {

    override fun <T> schedule(single: Single<T>, onNext: Consumer<T>, onFail: Consumer<Throwable>, tag: Any) {
        val disposables = subscriptions.getSubscriptions(tag)
        disposables.add(single
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(onNext, onFail))
    }

    override fun dispose(tag: Any) {
        subscriptions.dispose(tag)
    }
}