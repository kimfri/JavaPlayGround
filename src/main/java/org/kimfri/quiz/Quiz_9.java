package org.kimfri.quiz;

/**
** A - 97
 * B - 100
 * C - Error
 * D - None
 */
public class Quiz_9 {
    public static void main(String[] args) {
        System.err.println(Quiz_9.rA(80));
    }
    public static int rA(int x) {
        if (x < 100) x = rA(x + 10);
        return (x - 1);
    }
}
