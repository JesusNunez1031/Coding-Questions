package codeWars.stacks;

import java.util.Stack;

public class isValid {
    /*
    Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.
    This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}.
    All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.

    What is considered Valid?
    A string of braces is considered valid if all braces are matched with the correct brace.

    Examples
    "(){}[]"   =>  True
    "([{}])"   =>  True
    "(}"       =>  False
    "[(])"     =>  False
    "[({})](]" =>  False
     */
    public boolean isValid(String braces) {
        System.out.println(braces);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < braces.length(); i++) {
            char c = braces.charAt(i);

            if ((c == ')' || c == ']' || c == '}') && stack.isEmpty()) {
                return false;
            } else if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    //Replace all instances of '{}' '()' and '[]' if any with the empty string, if there remains one, return false
    public boolean isValidEz(String braces) {
        String b = braces;
        System.out.println(braces);
        for (int i = 0; i < braces.length() / 2; i++) {
            b = b.replaceAll("\\(\\)", "");
            b = b.replaceAll("\\[\\]", "");
            b = b.replaceAll("\\{\\}", "");
            if (b.length() == 0)
                return true;
        }
        return false;
    }

//    @Test
//    public void testValid() {
//        assertTrue(isValid.this.isValid("()"));
//    }
//
//    @Test
//    public void testInvalid() {
//        assertFalse(isValid.this.isValid("[(])"));
//    }

}
