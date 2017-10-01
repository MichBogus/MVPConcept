package com.mvpconcept.api.scheduler

import io.reactivex.Single
import io.reactivex.functions.Consumer

interface SchedulerApi {

    fun <T> schedule(single: Single<T>, onNext: Consumer<T>, onFail: Consumer<Throwable>, tag: Any)
    fun dispose(tag: Any)
}