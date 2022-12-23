package leetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class longestPalindromeTest {
    longestPalindrome driver = new longestPalindrome();

    @Test
    @DisplayName("All characters of even frequency")
    void EvenFrequency() {
        String s = "acabbcabcacb";
        int length = driver.longestPalindrome(s);
        Assertions.assertEquals(12, length);
        System.out.printf("a palindrome of length %d can be made from %s", length, s);
    }

    @Test
    @DisplayName("String with odd character frequencies")
    void OddFrequency() {
        String s = "aaennuevndoda";
        int length = driver.longestPalindrome(s);
        Assertions.assertEquals(9, length);
        System.out.printf("a palindrome of length %d can be made from %s", length, s);
    }

    @Test
    @DisplayName("String with all equal characters")
    void AllSame() {
        String s = "ddddddd";
        int length = driver.longestPalindrome(s);
        Assertions.assertEquals(7, length);
        System.out.printf("a palindrome of length %d can be made from %s", length, s);
    }
}