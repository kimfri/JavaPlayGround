package org.kimfri.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonPrefixTest {
    CommonPrefix commonPrefix = new CommonPrefix();

    @Test
    void longestCommonPrefixFound() {
        String[] strs = new String[]{"flower","flow","flight"};
        assertEquals("fl", commonPrefix.longestCommonPrefix(strs));
    }

    @Test
    void longestCommonPrefixNotFound() {
        final String[] strs = {"dog", "racecar", "car"};
        assertEquals("", commonPrefix.longestCommonPrefix(strs));
    }

    @Test
    void getMinLengthOfStrings() {
        assertEquals(3,
                commonPrefix.getMinLengthOfStrings(new String[]{"abc", "abcd", "abc66"}));
    }
}