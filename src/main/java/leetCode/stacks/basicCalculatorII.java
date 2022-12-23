package leetCode.stacks;

import java.util.Stack;

public class basicCalculatorII {
    /*
    Implement a basic calculator to evaluate a simple expression string.
    The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

    Example 1:
    Input: "3+2*2"
    Output: 7

    Example 2:
    Input: " 3/2 "
    Output: 1

    Example 3:
    Input: " 3+5 / 2 "
    Output: 5

    Note:
        You may assume that the given expression is always valid.
        Do not use the eval built-in library function.
     */

    //O(n) time and space method using a stack
    private static int calculate(String s) {
        //check for a valid string
        if (s == null || s.length() == 0) {
            return 0;
        }

        //stack to store values to be evaluated
        Stack<Integer> stack = new Stack<>();

        /*
            variable to hold the operation encountered, default is '+' since the
            first number encountered must be added to stack
        */
        char operation = '+';

        //the current number encountered
        int current_number = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            /*
                if the current character is a digit, add it to the current_number. We assume there are numbers composed
                of multiple digits in s
            */
            if (Character.isDigit(c)) {
                current_number = current_number * 10 + c - '0';
            }

            /*
                if the current character is not a number, we check if its not a space, if its not, it must be a sign,
                therefore we need to evaluate the expression. If we are at the last character in s, we also need to
                evaluate based on the last seen operation
            */
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (operation) {
                    /*
                        if the operation is '+', adding the number to stack will simulate a positive value, if there is
                        no multiplication or division, in the end when all values in the stack are added, this will
                        simulate addition, otherwise if the operation is '-', we add the negative current_number,
                        later in the evaluation when we add all values in the stack, this will simulate subtraction
                    */
                    case '+':
                        stack.add(current_number);
                        break;
                    case '-':
                        stack.add(-current_number);
                        break;
                        /*
                            since multiplication and division have higher precedence than addition and subtraction,
                            we evaluate these expressions in place and add the result to the stack
                        */
                    case '*':
                        stack.add(stack.pop() * current_number);
                        break;
                    case '/':
                        stack.add(stack.pop() / current_number);
                        break;
                }
                //we reset the current_number to 0 and update the old operation to the new
                current_number = 0;
                operation = c;
            }
        }
        /*
            once all the signs have been applied, the remaining values in the stack are the
            results of the evaluations, adding them all up will provide the final result
        */
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }

        return sum;
    }

    //O(n) time and constant space
    private static int calculateEz(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        //the current number being evaluated
        int current_number = 0;

        //the most recent operation seen
        char operation = '+';

        /*
            To perform this algorithm using constant space, we can do so using two new variables "sum" and "last_sum"
            "sum" will hold the total sum of the expression evaluated, and "last_sum" will store the evaluation until we
            encounter a '+' or a '-', at which point we add to the sum the current last_sum and we set last_sum back to
            what the current_number is
         */
        int sum = 0;
        int last_sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //if the current character is a digit, add it to the current_number variable, a number in the string is not exclusively 1 digit
            if (Character.isDigit(c)) {
                current_number = current_number * 10 + c - '0';
            }

            /*
                if the current character is not a digit and is not a space, we execute the operation depending on what
                the current sign is unless, the current character is the last character in s, we need to perform the
                operation since it is the last value to be evaluated
             */
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (operation == '+') {
                    sum += last_sum;
                    last_sum = current_number;
                } else if (operation == '-') {
                    sum += last_sum;
                    last_sum = -current_number;
                } else if (operation == '*') {
                    last_sum *= current_number;
                } else if (operation == '/') {
                    last_sum /= current_number;
                }
                //update the operation to the new operation and reset the current_number
                operation = c;
                current_number = 0;
            }
        }
        //add the remaining "last_sum" values to the sum
        sum += last_sum;

        return sum;
    }

    public static void main(String[] args) {
        String expression = "32*5+2*2";
        System.out.println(calculateEz(expression));
    }
}
