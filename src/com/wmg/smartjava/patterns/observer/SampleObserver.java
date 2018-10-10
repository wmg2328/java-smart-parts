package com.wmg.smartjava.patterns.observer;

public class SampleObserver implements TopicObserver {

    private String name;
    private TopicSubject subject;

    public SampleObserver(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String message = (String) subject.getUpdate(this);
        System.out.println(String.format("Observer %s Consumed Message: %s", this.name, message));
    }

    @Override
    public void setTopic(TopicSubject subject) {
        this.subject = subject;
    }
}
