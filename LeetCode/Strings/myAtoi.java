public class myAtoi {
    /*
        Implement atoi which converts a string to an integer.
        The function first discards as many whitespace characters as necessary until the first non-whitespace character
        is found. Then, starting from this character takes an optional initial plus or minus sign followed by as many
        numerical digits as possible, and interprets them as a numerical value.

        The string can contain additional characters after those that form the integral number, which are ignored and
        have no effect on the behavior of this function.

        If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
        exists because either str is empty or it contains only whitespace characters, no conversion is performed.

        If no valid conversion could be performed, a zero value is returned.

        Note:
        Only the space character ' ' is considered a whitespace character.
        Assume we are dealing with an environment that could only store integers within the 32-bit signed integer
        range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

        Example 1:
        Input: str = "42"
        Output: 42

        Example 2:
        Input: str = "   -42"
        Output: -42
        Explanation: The first non-whitespace character is '-', which is the minus sign. Then take as many numerical digits as possible, which gets 42.

        Example 3:
        Input: str = "4193 with words"
        Output: 4193
        Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

        Example 4:
        Input: str = "words and 987"
        Output: 0
        Explanation: The first non-whitespace character is 'w', which is not a numerical digit or a +/- sign. Therefore no valid conversion could be performed.

        Example 5:
        Input: str = "-91283472332"
        Output: -2147483648
        Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer. Thefore INT_MIN (−231) is returned.

        Constraints:
            0 <= s.length <= 200
            s consists of English letters (lower-case and upper-case), digits, ' ', '+', '-' and '.'.
     */

    //Method calculating value
    public static int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        //skip leading zeros in the string
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        StringBuilder sb = new StringBuilder();
        char sign = ' ';

        while (i < s.length()) {
            //record the first sign found
            if (sign == ' ' && (s.charAt(i) == '+' || s.charAt(i) == '-') && sb.length() == 0) {
                sign = s.charAt(i);
            } else if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                break;
            }
            i++;
        }

        //if the string had no valid integers or if sb contains only the sign return 0
        if (sb.length() == 0 || (sb.length() == 1 && sb.charAt(0) == sign)) {
            return 0;
        }

        i = 0;
        long ans = 0;
        while (i < sb.length()) {
            ans = (ans * 10) + (sb.charAt(i) - '0');    //-'0' to convert a char to a digit
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
                return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }

        //return the number based on the sign
        return sign == '-' ? (int) ans * -1 : (int) ans;
    }

    //Method using Java parse
    public static int myAtoiEz(String s) {
        if (s.length() == 0) {
            return 0;
        }

        //skip leading zeros in the string
//        s = s.trim();
//        s = s.replaceAll("\\s", "");      -> slow methods of removing zeros
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        StringBuilder sb = new StringBuilder();
        char sign = ' ';

        while (i < s.length()) {
            //record the first sign found
            if (sign == ' ' && (s.charAt(i) == '+' || s.charAt(i) == '-') && sb.length() == 0) {
                sign = s.charAt(i);
            } else if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                break;
            }
            i++;
        }

        //if the string had no valid integers or if sb contains only the sign return 0
        if (sb.length() == 0 || (sb.length() == 1 && sb.charAt(0) == sign)) {
            return 0;
        }
        int num;

        //attempt to convert the string to an int, if we cant retur the Max or min depending on what the sign is
        try {
            num = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            if (sign == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        //return the number based on the sign
        return sign == '-' ? num * -1 : num;
    }


    public static void main(String[] args) {
        String s = "-91283472332";

        System.out.println(myAtoiEz(s));
    }
}
