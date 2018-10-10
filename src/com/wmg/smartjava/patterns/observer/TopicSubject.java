package com.wmg.smartjava.patterns.observer;

public interface TopicSubject {

    void register(TopicObserver observer);

    void unregister(TopicObserver observer);

    Object getUpdate(TopicObserver observer);

    void notifyAllObserver();
}
