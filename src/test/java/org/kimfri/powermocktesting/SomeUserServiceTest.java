package org.kimfri.powermocktesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class SomeUserServiceTest {

    private AutoCloseable closeable;
    @Mock
    Person personMock;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Nested
    public class someTests {

        @Test
        void kalle() {
            //arrange
            final String aName = "Kalle Kula";
            when(personMock.getName()).thenReturn(aName);
            //act
            SomeUserService someUserService = new SomeUserService(personMock);

            //assert
            assertEquals(aName, someUserService.getPersonName());
        }

        @ParameterizedTest
        @ValueSource(strings = {"Kim", "Maria", "Wille", "Theo"})
        void kula(String candidate) {
            //arrange
            when(personMock.getName()).thenReturn(candidate);
            //act
            SomeUserService someUserService = new SomeUserService(personMock);

            //assert
            assertEquals(candidate, someUserService.getPersonName());
        }
    }
}
