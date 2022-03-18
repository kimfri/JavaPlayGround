package org.kimfri;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StreamStuffTest {

    @Test
    void listStreamFilter() {
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        final List<Integer> evenInts = integers.stream()
                .filter(this::isIntEven)
                .collect(Collectors.toList());
        final List<Integer> oddInts = integers.stream()
                .filter(it -> !isIntEven(it))
                .collect(Collectors.toList());
        evenInts.forEach(System.err::println);
        oddInts.forEach(System.err::println);
        final long amountOfOddInts = oddInts.stream().count();
        System.err.println(amountOfOddInts);
        final Integer evenSum = evenInts.stream().mapToInt(Integer::intValue).sum();
        System.err.println(evenSum);
    }

    boolean isIntEven(int value) {
        return value % 2 == 0;
    }
}