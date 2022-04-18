package org.kimfri.quiz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Create a method that returns all integers in a list that
 * are greater than a specified number.
 */
public class Quiz_3 {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 7, 2, 9, 13, 3, 6, 5);
        final int value = 7;
        final List<Integer> valuesPlusThreeGreaterThanValue
                = getNumbersGreaterThanValue(numbers, value);
        valuesPlusThreeGreaterThanValue.stream().forEach(System.err::println);
    }

    static List<Integer> getNumbersGreaterThanValue(final List<Integer> numbers, final int value) {
        return numbers.stream()
                .filter(it -> it > value)
                .collect(Collectors.toList());
    }
}
