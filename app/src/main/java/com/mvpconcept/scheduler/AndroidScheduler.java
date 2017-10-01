package com.mvpconcept.scheduler;

import com.mvpconcept.api.scheduler.SchedulerApi;
import com.mvpconcept.api.scheduler.SubscriptionsApi;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

//public class AndroidScheduler implements SchedulerApi {
//
//    private final Scheduler observeOnScheduler;
//    private final Scheduler subscribeOnScheduler;
//    private final SubscriptionsApi subscriptions;
//
//    public AndroidScheduler(Scheduler subscribeOnScheduler, Scheduler observeOnScheduler, SubscriptionsApi subscriptionsApi) {
//        this.observeOnScheduler = observeOnScheduler;
//        this.subscribeOnScheduler = subscribeOnScheduler;
//        subscriptions = subscriptionsApi;
//    }
//
//    @Override
//    public <T> void schedule(Single<T> single, Consumer<T> onNext, Consumer<Throwable> onFail, Object tag) {
//        List<Disposable> disposables = subscriptions.getSubscriptions(tag);
//        disposables.add(single
//                .subscribeOn(subscribeOnScheduler)
//                .observeOn(observeOnScheduler)
//                .subscribe(onNext, onFail));
//    }
//
//    @Override
//    public void dispose(Object tag) {
//        subscriptions.dispose(tag);
//    }
//}
//