package org.kimfri.powermocktesting;

public class SomeUserService {

    private final Person person;

    public SomeUserService(Person person) {
        this.person = person;
    }

    public String getPersonName() {
        return person.getName();
    }
}
