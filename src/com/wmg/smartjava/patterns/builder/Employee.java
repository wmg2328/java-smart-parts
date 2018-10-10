package com.wmg.smartjava.patterns.builder;

/**
 * Separate the construction of a complex object from its representation. Then the same construction process
 * can be reused to generate different objects
 */
public class Employee {

    private long id;
    private String name;
    private String department;
    private double salary;
    private int age;
    private short performanceIndex;
    private int experience;

    private Employee(long id, String name, String department, double salary, int age, short performanceIndex, int experience) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.performanceIndex = performanceIndex;
        this.experience = experience;
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {

        private long id;
        private String name;
        private String department;
        private double salary;
        private int age;
        private short performanceIndex;
        private int experience;

        public EmployeeBuilder id(long id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder department(String department) {
            this.department = department;
            return this;
        }

        public EmployeeBuilder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder age(int age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder performanceIndex(short performanceIndex) {
            this.performanceIndex = performanceIndex;
            return this;
        }

        public EmployeeBuilder experience(int experience) {
            this.experience = experience;
            return this;
        }

        public Employee build() {
            return new Employee(this.id, this.name, this.department, this.salary, this.age, this.performanceIndex, this.experience);
        }
    }

    @Override
    public String toString() {
        return "EmployeeBuilder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", performanceIndex=" + performanceIndex +
                ", experience=" + experience +
                '}';
    }

}
