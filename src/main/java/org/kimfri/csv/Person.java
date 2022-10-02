package org.kimfri.csv;

import java.util.Optional;

public class Person {
    private String firstName;
    private String lastName;
    private String age;

    public Person() {
    }

    public Person(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String firstName, String lastName, Optional<String> age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age.orElse("N/A");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
