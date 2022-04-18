package org.kimfri.quiz;

/*
 * Will print value for a while, and after that a
 * StackOverflowException will be thrown
 */
public class Quiz_1 {
    public static void main(String[] args) {
        print(2);
    }

    private static void print(int value) {
        if (value < 1) return;

        System.err.println("value: " + value);
        print(value);
    }
}
