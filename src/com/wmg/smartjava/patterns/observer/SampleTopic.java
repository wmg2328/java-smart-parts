package com.wmg.smartjava.patterns.observer;

import java.util.HashSet;

public class SampleTopic implements TopicSubject {

    public final Object LOCK = new Object();
    private HashSet<TopicObserver> observers = new HashSet<>();
    private String message;

    @Override
    public void register(TopicObserver observer) {
        if (observer == null) {
            throw new NullPointerException("No observer found");
        }

        synchronized (LOCK) {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(TopicObserver observer) {
        synchronized (LOCK) {
            observers.remove(observer);
        }
    }

    @Override
    public Object getUpdate(TopicObserver observer) {
        return this.message;
    }

    @Override
    public void notifyAllObserver() {
        observers.iterator().forEachRemaining(TopicObserver::update);
    }

    public void postMessage(String message) {
        this.message = message;
        notifyAllObserver();
    }
}
