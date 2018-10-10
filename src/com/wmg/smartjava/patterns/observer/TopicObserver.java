package com.wmg.smartjava.patterns.observer;

public interface TopicObserver {

    void update();

    void setTopic(TopicSubject subject);
}
