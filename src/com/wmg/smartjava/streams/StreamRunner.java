package com.wmg.smartjava.streams;

import com.wmg.smartjava.data.MockBuilder;
import com.wmg.smartjava.model.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StreamRunner {
    public static void main(String[] args) {

        List<Person> mockList = MockBuilder.getMockList(10);
        mockList.forEach(System.out::println);

        long listCount = CollectionDemo.get_count(mockList);
        System.out.println("Test data list count " + listCount);

        Double averageAge = CollectionDemo.get_averageAge(mockList);
        System.out.println("Average Age " + averageAge);

        String maxSalary = CollectionDemo.get_maxSalary(mockList);
        System.out.println("Max salary " + maxSalary);

        Person youngestPerson = CollectionDemo.get_maxLocalDate(mockList);
        System.out.println("Youngest Person " + youngestPerson);

        Optional<Person> oldestPerson = CollectionDemo.get_minLocalDate(mockList);
        System.out.println("Oldest Person " + (oldestPerson.isPresent() ? oldestPerson.get() : "Not applicable"));

        Map<Boolean, List<Person>> partitionByAgeRangeList = CollectionDemo.get_partitionByAgeRange(mockList);
        partitionByAgeRangeList.forEach((aBoolean, personList) -> System.out.println(aBoolean + " -> " + personList));

        String personNameList = CollectionDemo.get_nameList(mockList);
        System.out.println("Person name list " + personNameList);
    }
}
