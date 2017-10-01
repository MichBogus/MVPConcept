package com.mvpconcept.base

abstract class BasePresenter<T> {

    var view: T? = null

    fun attachView(view: T) {
        this.view = view
    }

    fun detachView() {
        view = null
    }
}