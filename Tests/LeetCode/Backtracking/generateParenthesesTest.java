import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class generateParenthesesTest {

    generateParentheses driver = new generateParentheses();

    @org.junit.jupiter.api.Test
    @DisplayName("Generate all possible parentheses combinations using n = 1")
    void generateOne() {
        List<String> parentheses = driver.generateParenthesis(1);
        assertEquals(parentheses, List.of("()"));
        System.out.println("N = 1: " + parentheses.toString());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Generate all possible parentheses combinations using n = 2")
    void generateTwo() {
        List<String> parentheses = driver.generateParenthesis(2);
        assertEquals(parentheses, List.of("(())", "()()"));
        System.out.println("N = 2: " + parentheses.toString());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Generate all possible parentheses combinations using n = 3")
    void generateThree() {
        List<String> parentheses = driver.generateParenthesis(3);
        assertEquals(parentheses, List.of("((()))", "(()())", "(())()", "()(())", "()()()"));
        System.out.println("N = 3: " + parentheses.toString());
    }

    @Test
    @DisplayName("Generate all possible parentheses combinations using n = 4")
    void generateFour() {
        List<String> parentheses = driver.generateParenthesis(4);
        assertEquals(parentheses, List.of("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())",
                "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"));
        System.out.println("N = 4: " + parentheses.toString());
    }
}