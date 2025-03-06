package leetCode;

import leetCode.slidingWindow_twoPointer.countBinarySubstrings;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

class countBinarySubstringsTest extends SoftAssert {
    countBinarySubstrings driver = new countBinarySubstrings();

    @Test
    void BinaryString1() {
        assertEquals(6, driver.countBinarySubstrings("00110011"));
    }

    @Test
    void BinaryString2() {
        assertEquals(4, driver.countBinarySubstrings("10101"));
    }

    @Test
    void BinaryString3() {
        assertEquals(6, driver.countBinarySubstrings("0001110110"));
    }
}