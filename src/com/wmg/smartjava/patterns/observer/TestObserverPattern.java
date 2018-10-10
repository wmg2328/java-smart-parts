package com.wmg.smartjava.patterns.observer;

public class TestObserverPattern {

    public static void main(String[] args) {

        //Observer Pattern
        SampleTopic topic = new SampleTopic();

        TopicObserver observer1 = new SampleObserver("Observer1");
        TopicObserver observer2 = new SampleObserver("Observer2");

        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer1); // This re registration is ignored

        observer1.setTopic(topic);
        observer2.setTopic(topic);

        observer1.update();

        topic.postMessage("This is first message");

        // Lets unregister one observer
        topic.unregister(observer1);

        topic.postMessage("This is second message");
    }
}
