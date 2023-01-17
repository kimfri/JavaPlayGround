package org.kimfri.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddDigitsTest {

    @Test
    void first() {
        AddDigits addDigits = new AddDigits();
        assertEquals(2, addDigits.addDigits(38));
        assertEquals(0, addDigits.addDigits(0));
    }
}