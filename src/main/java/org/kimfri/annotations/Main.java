package org.kimfri.annotations;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.doit();
    }

    private void doit() {
        Animal dog = new Dog();
        Animal bird = new Bird();
        dog.printSound();
        bird.printSound();
        isAnimalImportant(dog);
        isAnimalImportant(bird);
    }

    private void isAnimalImportant(Animal animal) {
        if(animal.getClass().isAnnotationPresent(CanFly.class)) {
            System.err.println("The animal that can fly says: ");
            animal.printSound();
        }
    }
}
