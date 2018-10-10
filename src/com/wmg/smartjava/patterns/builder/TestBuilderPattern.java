package com.wmg.smartjava.patterns.builder;

public class TestBuilderPattern {

    public static void main(String[] args) {

        // Builder Pattern
        Employee employee = Employee.builder()
                .id(1)
                .name("Test Employee")
                .salary(10000.0)
                .department("Department A")
                .build();

        System.out.println(employee.toString());


    }
}
