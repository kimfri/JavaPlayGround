package org.kimfri.lombockStuff;

import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LombokMainTest {

    private LombokMain lombokMain;

    @Nested
    public class giveMeBackStringInUppercase {

        @BeforeEach
        public void setUp() {
            lombokMain = new LombokMain();
        }

        @Test
        void givenNullData_thenThrowException() {
            String someString = null;
            final String partOfString = "theData is marked";
            NullPointerException thrownException = assertThrows(NullPointerException.class, () -> {
                lombokMain.giveMeBackStringInUppercase(someString);
            });
            assertTrue(thrownException.getMessage().contains(partOfString));
        }

        @Test
        void givenData_thenReturnUppercaseString() {
            String someString = "Hello World";
            String uppercaseMsg = lombokMain.giveMeBackStringInUppercase(someString);
            assertEquals(someString.toUpperCase(), uppercaseMsg);
        }
    }

    @Nested
    public class BuilderThings {
        @Test
        void givenUser_whenUseGetter_thenReturnName() {
            final String name = "Kim";
            User user = User.builder()
                    .name(name)
                    .email("kim.fritzon@gmail.com")
                    .build();

            System.out.println(user);
            assertEquals(name, user.getName());
        }
    }
}