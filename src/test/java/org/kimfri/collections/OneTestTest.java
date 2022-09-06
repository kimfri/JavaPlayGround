package org.kimfri.collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OneTestTest {
    private AutoCloseable autoCloseable;

    private OneTest oneTest;
    private final int amount = 5_000;

    @BeforeEach
    void setupMocks() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        oneTest = new OneTest();
    }

    @AfterEach
    void releaseMocks() throws Exception {
        autoCloseable.close();
    }

    @Test
    void onlyNewValues() {
        List<String> numbers = new ArrayList<>();
//        numbers.add("4000");

        Long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            assertTrue( oneTest.isNeedlePresentInList(numbers, "" + i));
        }
        Long stop = System.currentTimeMillis();
        System.err.println("onlyNewValues took: " + (stop - start) + "ms");
        assertEquals(amount, numbers.size());
    }

    @Test
    void onlyNewValues2() {
        List<String> numbers = new ArrayList<>();
//        numbers.add("4000");
        Long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            assertTrue( oneTest.isNeedlePresentInList2(numbers, "" + i));
        }
        Long stop = System.currentTimeMillis();
        System.err.println("onlyNewValues2 took: " + (stop - start) + "ms");
        assertEquals(amount, numbers.size());
    }

    @Test
    void onlyNewValues3() {
        List<String> numbers = new ArrayList<>();

//        numbers.add("4000");
        Long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            assertTrue( oneTest.isNeedlePresentInList3(numbers, "" + i));
        }
        Long stop = System.currentTimeMillis();
        System.err.println("onlyNewValues3 took: " + (stop - start) + "ms");
        assertEquals(amount, numbers.size());
    }
}
