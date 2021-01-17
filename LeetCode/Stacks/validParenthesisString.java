import java.util.Stack;

public class validParenthesisString {

    //TC/S: O(n)
    private boolean checkValidString(String s) {
        if (s.length() == 0) {
            return true;
        }

        //Stacks to hold both star characters and open braces
        Stack<Integer> star = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        //push indexes to the stacks so we don't mismatch "(" with stars not in their reach
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == '*') {
                star.push(i);
            } else {
                //current ')' matches with an open brace in the stack
                if (!stack.isEmpty()) {
                    stack.pop();
                    //current ')' matches with a star
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        //check remaining characters in the stack and star symbols
        while (!stack.isEmpty()) {
            if (star.isEmpty()) {
                return false;
                //if the top '(' came before a star, we can use the pair
            } else if (stack.peek() < star.peek()) {
                stack.pop();
                star.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    //TC: O(n) and constant space used
    public boolean checkValidStringEz(String s) {
        int left_balanced = 0;

        /*
            search through the string and count the number of left_balanced parenthesis and stars, when a closing parenthesis is
            encountered, reduce the count of "left_balanced"
         */
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '*') {
                left_balanced++;
            } else {
                left_balanced--;
            }
            //if left_balanced ever becomes negative, that means we found a right_balanced before an opening parenthesis
            if (left_balanced < 0) {
                return false;
            }
        }


        //repeat the same steps except now count the number of closing parenthesis and stars starting from the end
        int right_balanced = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == ')' || c == '*') {
                right_balanced++;
            } else {
                right_balanced--;
            }
            //if right_balanced ever becomes negative, that means we found an left_balanced before a closing parenthesis
            if (right_balanced < 0) {
                return false;
            }
        }

        /*
            if we reach this statement, we know there hasn't been an imbalance of parenthesis e.g. ")("
            stars have also been used as a substitute to either '(' or ')'
            Only the following remains,
                1. s contains the same amount of '(' and ')'
                2. s contains more '(' than ')' but enough stars '*' to be used as substitutes
                3. s contains more ')' than '(' but enough stars '*' to be used as substitutes
        */

        return true;
    }

}
