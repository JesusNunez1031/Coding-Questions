//package leetCode;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class reconstructOriginalDigitsFromEnglishTest {
//    reconstructOriginalDigitsFromEnglish driver = new reconstructOriginalDigitsFromEnglish();
//
//    @Test
//    @DisplayName("String has one digit")
//    void OneDigit() {
//        String s = "ozre";
//        String digits = driver.originalDigits(s);
//        Assertions.assertEquals(digits, "0");
//        System.out.println(s + ": " + digits);
//    }
//
//    @Test
//    @DisplayName("String has two digits")
//    void TwoDigits() {
//        String s = "ozrenoe";
//        String digits = driver.originalDigits(s);
//        Assertions.assertEquals(digits, "01");
//        System.out.println(s + ": " + digits);
//    }
//
//    @Test
//    @DisplayName("String has three digits")
//    void ThreeDigits() {
//        String s = "otzrewnooe";
//        String digits = driver.originalDigits(s);
//        Assertions.assertEquals(digits, "012");
//        System.out.println(s + ": " + digits);
//    }
//
//    @Test
//    @DisplayName("String has four digits")
//    void FourDigits() {
//        String s = "eeotzrterwnohoe";
//        String digits = driver.originalDigits(s);
//        Assertions.assertEquals(digits, "0123");
//        System.out.println(s + ": " + digits);
//    }
//
//    @Test
//    @DisplayName("String has five digits")
//    void FiveDigits() {
//        String s = "eueortzfrtoerwnohoe";
//        String digits = driver.originalDigits(s);
//        Assertions.assertEquals(digits, "01234");
//        System.out.println(s + ": " + digits);
//    }
//}