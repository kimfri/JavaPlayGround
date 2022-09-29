package org.kimfri.docker;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.err.println("Hello world!!");

        for (int i = 0; i < 10; i++) {
            System.err.println("Hello: " + i);
            Thread.sleep(500);
        }
    }
}
