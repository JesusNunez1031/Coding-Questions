package leetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class minimumOperationsToMakeArrayEqualTest {
    minimumOperationsToMakeArrayEqual driver = new minimumOperationsToMakeArrayEqual();

    @Test
    @DisplayName("Even length")
    void EvenLength() {
        assertEquals(4, driver.minOperations(4));
    }

    @Test
    @DisplayName("Odd length")
    void OddLength() {
        assertEquals(20, driver.minOperations(9));
    }
}