package com.mvpconcept.api.scheduler

import android.support.annotation.VisibleForTesting
import io.reactivex.disposables.Disposable
import java.util.*

class AndroidSubscriptions : SubscriptionsApi {

    @VisibleForTesting
    var subscriptions: MutableMap<String, MutableList<Disposable>> = HashMap()

    private fun getSubscriberTag(subscription: Any) = subscription.toString()

    override fun getSubscriptions(subscription: Any): MutableList<Disposable> {
        val tag = getSubscriberTag(subscription)
        var objectSubscriptions: MutableList<Disposable>? = subscriptions[tag]
        if (objectSubscriptions == null) {
            objectSubscriptions = ArrayList()
            subscriptions.put(tag, objectSubscriptions)
        }
        return objectSubscriptions
    }

    override fun dispose(subscriber: Any): Int {
        val tag = getSubscriberTag(subscriber)

        if (subscriptions.containsKey(tag)) {
            val taggedSubscriptions = subscriptions[tag]

            taggedSubscriptions?.let {
                val numberOfSubscriptions = taggedSubscriptions.size
                taggedSubscriptions.forEach { subscription -> subscription.dispose() }
                subscriptions.remove(tag)
                return numberOfSubscriptions
            }
            return 0
        } else {
            return 0
        }
    }
}