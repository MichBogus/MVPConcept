package com.mvpconcept.api.scheduler

import com.mvpconcept.api.subscribee
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.functions.Consumer

class AndroidScheduler(val subscribeOnScheduler: Scheduler, val observeOnScheduler: Scheduler, val subscriptions: SubscriptionsApi) : SchedulerApi {

    override fun <T> schedule(single: Single<T>, onNext: Consumer<T>, onFail: Consumer<Throwable>, tag: Any) {
        val disposables = subscriptions.getSubscriptions(tag)
        disposables.add(single
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribee(onNext, onFail))

        single .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .doOnSuccess {
                    val check = 2
                }
                .doOnError {
                    val check = 1
                }
                .subscribe()
    }

    override fun dispose(tag: Any) {
        subscriptions.dispose(tag)
    }
}