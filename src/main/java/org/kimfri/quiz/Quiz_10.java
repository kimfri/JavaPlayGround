package org.kimfri.quiz;

/*
 * A - 5
 * B - 2
 * C - 4
** D - None  it is 6
 */
public class Quiz_10 {
    public static void main(String[] args) {
        int[][] numbers = {{1, 2, 3}, {4, 6}, {5}};
        int length = numbers.length;
        System.err.println(numbers[length - 2][1]);
    }
}
