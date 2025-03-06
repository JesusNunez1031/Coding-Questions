//package leetCode;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class powersOfThreeTest {
//    powersOfThree driver = new powersOfThree();
//
//    @Test
//    @DisplayName("All passed values are valid powers of 3")
//    void isPowerOfThreeTest1() {
//        assertTrue(driver.isPowerOfThree(3));
//        assertTrue(driver.isPowerOfThree(9));
//        assertTrue(driver.isPowerOfThree(27));
//        assertTrue(driver.isPowerOfThree(1));
//        assertTrue(driver.isPowerOfThree(81));
//        assertTrue(driver.isPowerOfThree(6561));
//    }
//
//    @Test
//    @DisplayName("All passed values are not powers of 3")
//    void isPowerOfThreeTest2() {
//        assertFalse(driver.isPowerOfThree(2));
//        assertFalse(driver.isPowerOfThree(56));
//        assertFalse(driver.isPowerOfThree(24));
//        assertFalse(driver.isPowerOfThree(10));
//        assertFalse(driver.isPowerOfThree(60));
//        assertFalse(driver.isPowerOfThree(1000));
//    }
//}