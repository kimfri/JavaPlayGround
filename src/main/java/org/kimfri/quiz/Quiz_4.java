package org.kimfri.quiz;

import java.util.HashSet;
import java.util.Set;

/*
 * What will be printed (1 2 3) a set can only contain distinct numbers,
 * the second time 3 are added it will not be set.
 */
public class Quiz_4 {
    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(3);
        integerSet.forEach(System.err::println);
    }
}
