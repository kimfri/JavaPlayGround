package org.kimfri.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicatesTest {

    ContainsDuplicates containsDuplicates = new ContainsDuplicates();

    @Test
    void first() {
        int[] nums = new int[]{1,2,3,4};
        assertFalse(containsDuplicates.containsDuplicate(nums));
    }

    @Test
    void second() {
        int[] nums = new int[]{1,2,3,4};
        assertFalse(containsDuplicates.containsDuplicate(nums));
    }

    @Test
    void third() {
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        assertTrue(containsDuplicates.containsDuplicate(nums));
    }
}