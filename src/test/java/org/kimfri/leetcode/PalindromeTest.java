package org.kimfri.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    void isPalindrome() {
        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.isPalindrome(121));
        assertFalse(palindrome.isPalindrome(-121));
        assertTrue(palindrome.isPalindrome(3312133));
        assertTrue(palindrome.isPalindrome(33));
    }
}