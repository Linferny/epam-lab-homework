package t01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
public class SimpleOperationTest {
    @Test
    @DisplayName("Mul works correct")
    @Disabled
    void testMul() {
        try {
            assertEquals(0.0, SimpleOperation.mul(2.0, 0.0));
            assertEquals(-3.0, SimpleOperation.mul(-1.0, 3.0));
            assertEquals(4.0, SimpleOperation.mul(2.0, 2.0));
        } catch (SimpleOperationException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Mul throws correct")
    void testMulException() {
        assertThrows(SimpleOperationException.class, () -> SimpleOperation.mul(Double.MAX_VALUE, -1.0));
    }
}
