package net.sigusr.throwing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThrowingTest {

    @Test
    void throwingTest_0() {
        int fortyTwo;
        try {
            fortyTwo = Integer.parseInt("37");
            fortyTwo += 5;
        }
        catch (NumberFormatException e) {
            fortyTwo = 42;
        }
        assertEquals(42, fortyTwo);
    }

    @Test
    void throwingTest_1() {
        int fortyTwo;
        try {
            fortyTwo = Integer.parseInt("Mhee");
            fortyTwo += 5;
        }
        catch (NumberFormatException e) {
            fortyTwo = 42;
        }
        assertEquals(42, fortyTwo);
    }

    @Test
    void throwingTest_2() {
        int fortyTwo = Integer.parseInt("Mhee");
        try {
            fortyTwo += 5;
        }
        catch (NumberFormatException e) {
            fortyTwo = 43;
        }
        assertEquals(43, fortyTwo);
    }
}