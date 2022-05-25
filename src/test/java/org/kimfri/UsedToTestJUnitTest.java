package org.kimfri;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class UsedToTestJUnitTest {

    private UsedToTestJUnit usedToTestJUnit;

    @BeforeEach
    void setUp() {
        usedToTestJUnit = new UsedToTestJUnit();
    }

    @Test
    void testMaxValue() {
        final List<Integer> values = Arrays.asList(9, 7, 8, 2, 6, 1, 5, 9, 8);
        final int actual = usedToTestJUnit.getLargestValue(values);
        assertEquals(8, actual);
    }

}