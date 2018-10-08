package com.wmg.smartjava.streams;

import com.wmg.smartjava.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionDemo {

    public static long get_count(List<Person> personList) {
        return personList.stream().collect(Collectors.counting());
    }

    public static Person get_maxLocalDate(List<Person> personList) {
        return personList.stream()
                .max(Comparator.comparing(Person::getBirthday))
                .orElseThrow(NoSuchElementException::new);
    }

    public static Optional<Person> get_minLocalDate(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.minBy(Comparator.comparing(Person::getBirthday)));
    }

    public static Double get_averageAge(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.averagingLong(Person::getAge));
    }

    public static String get_maxSalary(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Person::getSalary)), person -> person.isPresent() ? person.get().toString() : "Not applicable"));
    }

    public static Map<Boolean, List<Person>> get_partitionByAgeRange(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() > 20));
    }

    public static String get_nameList(List<Person> personList) {
        return personList.stream()
                .map(Person::getName)
                .collect(Collectors.joining("|", "[", "]"));
    }

}
