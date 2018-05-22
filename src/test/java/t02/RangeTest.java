package t02;

import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {
    Range r1;
    Range r2;

    @AfterEach
    void clearFields() {
        r1 = r2 = null;
    }

    @Test
    @DisplayName("Before range")
    void testIsBefore() {
        r1 = new Range(1, 3);
        r2 = new Range(4, 5);
        assertTrue(r1.isBefore(r2));
        assertFalse(r2.isBefore(r1));
        r2 = new Range(2, 4);
        assertFalse(r1.isBefore(r2));
    }

    @Test
    @DisplayName("After range")
    void testIsAfter() {
        r1 = new Range(1, 3);
        r2 = new Range(4, 5);
        assertFalse(r1.isAfter(r2));
        assertTrue(r2.isAfter(r1));
        r2 = new Range(2, 4);
        assertFalse(r1.isAfter(r2));
    }

    @Test
    @DisplayName("Concurrent range")
    void testIsConcurrent() {
        r1 = new Range(1, 3);
        r2 = new Range(2, 4);
        assertTrue(r1.isConcurrent(r2));
        r2 = new Range(4, 5);
        assertFalse(r1.isConcurrent(r2));
        assertFalse(r2.isConcurrent(r1));
    }

    @Test
    @DisplayName("Get lower bounds")
    void testGetLowerBound() {
        r1 = new Range(1, 3);
        assertEquals(1, r1.getLowerBound());
    }

    @Test
    @DisplayName("Get upper bounds")
    void testGetUpperBound() {
        r1 = new Range(1, 3);
        assertEquals(3, r1.getUpperBound());
    }

    @Test
    @DisplayName("Contains")
    void testContains() {
        r1 = new Range(1, 10);
        assertFalse(r1.contains(-3));
        assertTrue(r1.contains(4));
    }

    @Test
    @DisplayName("To List convert")
    void testAsList() {
        val list = Arrays.asList(1L, 2L, 3L, 4L);
        r1 = new Range(1, 4);
        assertEquals(list, r1.asList());
    }

    @Test
    @DisplayName("Iterator")
    void testIterator() {
        r1 = new Range(1, 4);
        val itr = r1.asIterator();
        Long counter = 1L;
        Long cur = 0L;
        while (itr.hasNext()) {
            cur = itr.next();
            assertEquals(counter, cur);
            counter++;
        }
        assertTrue(4L == cur);
        assertThrows(NoSuchElementException.class, itr::next);
    }
}
