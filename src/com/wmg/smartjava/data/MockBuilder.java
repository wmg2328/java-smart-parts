package com.wmg.smartjava.data;

import com.github.javafaker.Faker;
import com.wmg.smartjava.model.Person;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockBuilder {

    public static List<Person> getMockList(int size) {

        Faker faker = new Faker();
        LocalDate now = LocalDate.now();

        return IntStream.range(1, size + 1)
                .mapToObj(value -> {

                    LocalDate bDay = faker.date().birthday(18, 55).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                    Person person = new Person();
                    person.setId(value);
                    person.setName(faker.name().name());
                    person.setBirthday(bDay);
                    person.setAge(ChronoUnit.YEARS.between(bDay, now));
                    person.setDepartment(faker.company().profession());
                    person.setSalary(faker.number().numberBetween(10000, 1000000));
                    return person;
                })
                .collect(Collectors.toList());

    }

}
