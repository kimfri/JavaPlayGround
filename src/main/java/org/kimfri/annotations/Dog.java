package org.kimfri.annotations;

public class Dog implements Animal {
    @Override
    public void printSound() {
        System.err.println("Dog says woof");
    }
}
