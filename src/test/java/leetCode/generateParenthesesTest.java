//package leetCode;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class generateParenthesesTest {
//
//    generateParentheses driver = new generateParentheses();
//
//    @Test
//    @DisplayName("Generate all possible parentheses leetCode.backtracking.combinations using n = 1")
//    void generateOne() {
//        List<String> parentheses = driver.generateParenthesis(1);
//        Assertions.assertEquals(parentheses, List.of("()"));
//        System.out.println("N = 1: " + parentheses.toString());
//    }
//
//    @Test
//    @DisplayName("Generate all possible parentheses leetCode.backtracking.combinations using n = 2")
//    void generateTwo() {
//        List<String> parentheses = driver.generateParenthesis(2);
//        Assertions.assertEquals(parentheses, List.of("(())", "()()"));
//        System.out.println("N = 2: " + parentheses.toString());
//    }
//
//    @Test
//    @DisplayName("Generate all possible parentheses leetCode.backtracking.combinations using n = 3")
//    void generateThree() {
//        List<String> parentheses = driver.generateParenthesis(3);
//        Assertions.assertEquals(parentheses, List.of("((()))", "(()())", "(())()", "()(())", "()()()"));
//        System.out.println("N = 3: " + parentheses.toString());
//    }
//
//    @Test
//    @DisplayName("Generate all possible parentheses leetCode.backtracking.combinations using n = 4")
//    void generateFour() {
//        List<String> parentheses = driver.generateParenthesis(4);
//        Assertions.assertEquals(parentheses, List.of("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())",
//                "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"));
//        System.out.println("N = 4: " + parentheses.toString());
//    }
//}