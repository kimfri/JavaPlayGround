package org.kimfri.annotations;

@CanFly
public class Bird implements Animal {
    @Override
    public void printSound() {
        System.err.println("Bird says piiip");
    }
}
