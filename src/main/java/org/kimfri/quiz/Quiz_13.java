package org.kimfri.quiz;

/*
 * A - aaaa
** B - a    for-loopen terminerar med ";"
 * C - Error
 * D - None
 */
public class Quiz_13 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++);
            System.err.println("a");
    }
}
