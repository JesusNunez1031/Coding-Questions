import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class combinationSumIVTest {
    combinationSumIV driver = new combinationSumIV();

    @Test
    @DisplayName("Test 1")
    void Test1() {
        assertEquals(7, driver.combinationSum4(new int[]{1, 2, 3}, 4));
    }

    @Test
    @DisplayName("Test 2")
    void Test2() {
        assertEquals(0, driver.combinationSum4(new int[]{9}, 4));
    }

    @Test
    @DisplayName("Test 3")
    void Test3() {
        assertEquals(15, driver.combinationSum4(new int[]{1, 2, 3, 4}, 5));
    }
}