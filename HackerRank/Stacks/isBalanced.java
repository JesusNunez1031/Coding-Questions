import java.util.Stack;

public class isBalanced {
    static String isBalanced(String s) {
        //{[()]}

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char br = s.charAt(i);

            if (br == '{' || br == '[' || br == '(') {
                stack.push(br);
            } else if ((br == '}' || br == ']' || br == ')') && stack.isEmpty()) {
                return "NO";
            } else {
                if (!stack.isEmpty()) {
                    if (br == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (br == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (br == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return "NO";
                    }
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

}
