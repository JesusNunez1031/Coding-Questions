import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (p == '(' || p == '{' || p == '[') {
                stack.push(p);
            } else if ((p == ')' || p == '}' || p == ']') && stack.isEmpty()) {
                return false;
            } else {
                if (!stack.isEmpty()) {

                    if (p == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (p == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (p == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(){][)"));
    }
}
