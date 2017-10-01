package com.mvpconcept.api

import com.mvpconcept.api.scheduler.AndroidSubscriptions
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import java.util.*

class AndroidSubscriptionsTest {

    lateinit var systemUnderTest: AndroidSubscriptions

    @Before
    fun setUp() {
        systemUnderTest = AndroidSubscriptions()
    }

    @Test
    fun shouldReturnProperValueBeforeAddingAnySubscriptions() {
        val expectedSize = 0

        val subscriptions = systemUnderTest.getSubscriptions(this)

        Assertions.assertThat(subscriptions.size).isEqualTo(expectedSize)
    }

    @Test
    fun shouldNotDisposeAnySubscriptions() {
        val expectedSize = 0

        val disposed = systemUnderTest.dispose(this)

        Assertions.assertThat(disposed).isEqualTo(expectedSize)
    }

    @Test
    fun shouldReturnProperValueAfterAddingSubscription() {
        val expectedSize = 1

        givenSubscriptionsAreNotEmpty()

        val subscriptions = systemUnderTest.getSubscriptions(this)

        Assertions.assertThat(subscriptions.size).isEqualTo(expectedSize)
    }

    @Test
    fun shouldReturnProperValueAfterDisposingSubscription() {
        val expectedSize = 1

        givenSubscriptionsAreNotEmpty()

        systemUnderTest.getSubscriptions(this)
        val disposed = systemUnderTest.dispose(this)

        Assertions.assertThat(disposed).isEqualTo(expectedSize)
    }

    private fun givenSubscriptionsAreNotEmpty() {
        val disposableList = ArrayList<Disposable>()
        disposableList.add(Single.just("test").subscribe())
        systemUnderTest.subscriptions.put(this.toString(), disposableList)
    }
}