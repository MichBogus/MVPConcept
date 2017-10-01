package com.mvpconcept.api

import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import io.reactivex.exceptions.CompositeException
import io.reactivex.exceptions.Exceptions
import io.reactivex.functions.Consumer
import io.reactivex.internal.disposables.DisposableHelper
import io.reactivex.internal.functions.ObjectHelper
import io.reactivex.plugins.RxJavaPlugins
import java.util.concurrent.atomic.AtomicReference

fun <T> Single<T>.subscribee(onSuccess: Consumer<T>, onError: Consumer<Throwable>): Disposable {
    ObjectHelper.requireNonNull<Consumer<in T>>(onSuccess, "onSuccess is null")
    ObjectHelper.requireNonNull(onError, "onError is null")
    val s = DebugableConsumerSingleObserver(onSuccess, onError)
    this.subscribe(s as SingleObserver<T>)
    return s
}

class DebugableConsumerSingleObserver<T>(internal val onSuccess: Consumer<in T>,
                                         internal val onError: Consumer<in Throwable>) : AtomicReference<Disposable>(), SingleObserver<T>, Disposable {

    override fun onError(e: Throwable) {
        try {
            this.onError.accept(e)
        } catch (var3: Throwable) {
            Exceptions.throwIfFatal(var3)
            RxJavaPlugins.onError(CompositeException(e, var3))
        }

    }

    override fun onSubscribe(d: Disposable) {
        DisposableHelper.setOnce(this, d)
    }

    override fun onSuccess(value: T) {
        try {
            this.onSuccess.accept(value)
        } catch (var3: Throwable) {
            Exceptions.throwIfFatal(var3)
            RxJavaPlugins.onError(var3)
        }

    }

    override fun dispose() {
        DisposableHelper.dispose(this)
    }

    override fun isDisposed(): Boolean {
        return this.get() === DisposableHelper.DISPOSED
    }
}