package org.kimfri.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLastWordTest {
    LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    @Test
    void kalle() {
        assertEquals(5, lengthOfLastWord.lengthOfLastWord("Hello world"));
        assertEquals(4,  lengthOfLastWord.lengthOfLastWord("    fly me to the moon"));
        assertEquals(4,  lengthOfLastWord.lengthOfLastWord("    fly me to the moon     "));
    }

}