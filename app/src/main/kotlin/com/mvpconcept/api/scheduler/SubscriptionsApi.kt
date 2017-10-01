package com.mvpconcept.api.scheduler

import io.reactivex.disposables.Disposable

interface SubscriptionsApi {

    fun getSubscriptions(subscription: Any): MutableList<Disposable>
    fun dispose(subscriber: Any): Int
}