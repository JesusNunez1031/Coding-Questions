package leetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class countBinarySubstringsTest {
    countBinarySubstrings driver = new countBinarySubstrings();

    @Test
    @DisplayName("Binary String 1")
    void BinaryString1() {
        assertEquals(6, driver.countBinarySubstrings("00110011"));
    }

    @Test
    @DisplayName("Binary String 2")
    void BinaryString2() {
        assertEquals(4, driver.countBinarySubstrings("10101"));
    }

    @Test
    @DisplayName("Binary String 3")
    void BinaryString3() {
        assertEquals(6, driver.countBinarySubstrings("0001110110"));
    }
}