package leetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class longestValidParenthesesTest {
    longestValidParentheses driver = new longestValidParentheses();

    @Test
    @DisplayName("Perfect String s")
    void PerfectString() {
        String s = "((()))((()))";
        assertEquals(12, driver.longestValidParentheses(s));
        System.out.printf("%s has a valid parentheses substring of length %d", s, 12);
    }

    @Test
    @DisplayName("Imbalance of open in string s")
    void ImbalanceOpen() {
        String s = "(()(()((()()(";
        assertEquals(4, driver.longestValidParentheses(s));
        System.out.printf("%s has a valid parentheses substring of length %d", s, 4);
    }

    @Test
    @DisplayName("Imbalance of close in string s")
    void ImbalanceClose() {
        String s = "())))(())))())(())))";
        assertEquals(4, driver.longestValidParentheses(s));
        System.out.printf("%s has a valid parentheses substring of length %d", s, 4);
    }
}