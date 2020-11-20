import java.util.Stack;

public class decodeString {
    public static String decodeString(String s) {
        //number stack to hold the number of times a string repeats
        Stack<Integer> number_stack = new Stack<>();

        //String stack to hold the strings already decoded
        Stack<StringBuilder> string_stack = new Stack<>();

        StringBuilder decoded_string = new StringBuilder();
        int k_repetitions = 0;

        for (char c : s.toCharArray()) {
            /*
                there can only be 4 types of characters encountered
                a number k, letters, closing and opening brackets
            */

            //if the current char c is a digit we add it to k_repetitions
            if (Character.isDigit(c)) {
                k_repetitions = k_repetitions * 10 + c - '0';   //ascii value of 0 is 48
            }
            /*
                when a [ is encountered, we know a new string to decode is coming so we add the current
                decoded_string to the string_stack to hold and clear the decoded_string. By now we also have
                the number of times the new string will repeat so we store that as well and reset its value to 0
            */
            else if (c == '[') {
                string_stack.push(decoded_string);
                decoded_string = new StringBuilder();

                number_stack.push(k_repetitions);
                k_repetitions = 0;
            }
            /*
                when we reach ], we know the new decoded string has been formed so we save it to a temp variable,
                extract the previously decoded strings from the string_stack and the number of times the current
                string will repeat from the number_stack, and we append the new string k_repetitions times to the
                decoded_string
            */
            else if (c == ']') {
                StringBuilder temp = decoded_string;
                decoded_string = string_stack.pop();
                int repetitions = number_stack.pop();

                while (repetitions-- > 0) {
                    decoded_string.append(temp);
                }
            }
            //if the c is a letter, we just append it to the decoded_string
            else {
                decoded_string.append(c);
            }
        }
        /*
            the decoded string wont be in the stack since after the last decode, we only add it to the
            string_stack when a new decode is encountered, therefore after the last decode, the entire
            decoded string s will be in decoded_string
        */
        return decoded_string.toString();
    }

    public static void main(String[] args) {
        String code = "3[a]2[bc]21[bo]";
        System.out.println(decodeString(code));
    }
}
