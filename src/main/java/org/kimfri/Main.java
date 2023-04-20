package org.kimfri;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.err.println("Hello Docker world!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
