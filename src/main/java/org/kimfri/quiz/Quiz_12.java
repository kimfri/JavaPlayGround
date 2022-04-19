package org.kimfri.quiz;

/*
** A - 9  return value from subtract is NOT used
 * B - 8
 * C - Error
 * D - None
 */
public class Quiz_12 {
    public static void main(String[] args) {
        int x = 9;
        subtractOne(x);
        System.err.println(x);
    }

    private static int subtractOne(int x) {
        return --x;
    }
}
