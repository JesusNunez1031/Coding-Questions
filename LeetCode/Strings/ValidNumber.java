public class ValidNumber {
    /*
    A valid number can be split up into these components (in order):
        1. A decimal number or an integer.
        2. (Optional) An 'e' or 'E', followed by an integer.

    A decimal number can be split up into these components (in order):
        1. (Optional) A sign character (either '+' or '-').
        2. One of the following formats:
            1. At least one digit, followed by a dot '.'.
            2. At least one digit, followed by a dot '.', followed by at least one digit.
            3. A dot '.', followed by at least one digit.

    An integer can be split up into these components (in order):
        1. (Optional) A sign character (either '+' or '-').
        2. At least one digit.

    For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7",
    "+6e-1", "53.5e93", "-123.456e789"]
    while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

    Given a string s, return true if s is a valid number.

    Example 1:
    Input: s = "0"
    Output: true

    Example 2:
    Input: s = "e"
    Output: false

    Example 3:
    Input: s = "."
    Output: false

    Example 4:
    Input: s = ".1"
    Output: true

    Constraints:
        1 <= s.length <= 20
        s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
     */
    //TC/S: O(n) and O(1)
    public boolean isNumber(String s) {
        /*
            for a string s to be a valid number it,
            1. Must have at least one digit
            2. can only have one e/E, and it must come after a digit
            3. can have only one dot, it can be before or after digit but not after an e/E
            4. can have a plus and minus sign, but there cant be more than 2
            dots '.', e/E, and signs '- +' also cant be the last characters of s
            flags are initialized to keep track if these conditions have been met to validate s
        */
        boolean seenDigit = false, seenE = false, seenDot = false;
        int signCount = 0; //number of plus and minus signs seen

        //iterate through all the characters in s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // current character

            //trigger flag if a digit has been encountered
            if (Character.isDigit(ch)) {
                seenDigit = true;
            }

            //increase the count of + or - if ch is a sign
            else if (ch == '-' || ch == '+') {

                //max limit for a sign is 2, one for pos/negative value and another for e-/e+
                if (signCount == 2) {
                    return false;
                }

                //if the sign does not come after an e/E return false, if signCount == 1, this current sign must be for e/E
                if (i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
                    return false;
                }

                //if the sign is the last character in s, return false
                if (i == s.length() - 1) {
                    return false;
                }

                //increase the signCount if all conditions don't apply
                signCount++;
            }

            //Dot '.'
            else if (ch == '.') {
                //a dot cant come after an e/E and there can only be one
                if (seenE || seenDot) {
                    return false;
                }

                //a dot cant be the last character if a digit has not been seen
                if (i == s.length() - 1 && !seenDigit) {
                    return false;
                }

                seenDot = true;
            }

            //E/e
            else if (ch == 'e' || ch == 'E') {
                //only one e/E can be present, it cant be the last character, and it must come after a digit
                if (seenE || !seenDigit || i == s.length() - 1) {
                    return false;
                }
                seenE = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
