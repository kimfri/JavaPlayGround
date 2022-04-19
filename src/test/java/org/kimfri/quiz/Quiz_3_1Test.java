package org.kimfri.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Quiz_3_1Test {

    private Quiz_3_1 quiz = new Quiz_3_1();

    @Test
    void example1() {
        final int[] nums = new int[]{2, 7, 11, 15};
        final int target = 9;

        final int[] indices = quiz.doit(nums, target);
        //output [0, 1]

        int[] expected = new int[] {0, 1};
        assertEquals(expected[0], indices[0]);
        assertEquals(expected[1], indices[1]);
    }

    @Test
    void example2() {
        final int[] nums = new int[]{3, 2, 4};
        final int target = 6;

        final int[] indices = quiz.doit(nums, target);

        int[] expected = new int[] {1, 2};
        assertEquals(expected[0], indices[0]);
        assertEquals(expected[1], indices[1]);
    }

    @Test
    void example3() {
        final int[] nums = new int[]{3, 3};
        final int target = 6;

        final int[] indices = quiz.doit(nums, target);

        int[] expected = new int[] {0, 1};
        assertEquals(expected[0], indices[0]);
        assertEquals(expected[1], indices[1]);
    }
}
