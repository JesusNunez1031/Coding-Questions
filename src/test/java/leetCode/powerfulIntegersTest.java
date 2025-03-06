//package leetCode;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//class powerfulIntegersTest {
//    powerfulIntegers driver = new powerfulIntegers();
//
//    @Test
//    @DisplayName("Both x and y are 1")
//    void EdgeCaseOfOne() {
//        int x = 1;
//        int y = 1;
//        int bound = 10;
//        assertEquals(List.of(2), driver.powerfulIntegers(x, y, bound));
//    }
//
//    @Test
//    @DisplayName("Small x, y and bound values")
//    void SmallValues() {
//        int x = 3;
//        int y = 5;
//        int bound = 20;
//        assertEquals(List.of(2, 4, 6, 8, 10, 14), driver.powerfulIntegers(x, y, bound));
//    }
//
//    @Test
//    @DisplayName("Large x, y and bound values")
//    void LargeValues() {
//        int x = 10;
//        int y = 12;
//        int bound = 500;
//        assertEquals(List.of(112, 145, 2, 244, 101, 22, 154, 11, 13), driver.powerfulIntegers(x, y, bound));
//    }
//}