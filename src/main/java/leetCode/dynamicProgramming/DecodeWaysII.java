package leetCode.dynamicProgramming;

public class DecodeWaysII {
    /*
    A message containing letters from A-Z can be encoded into numbers using the following mapping:
    'A' -> "1"
    'B' -> "2"
    ...
    'Z' -> "26"
    To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the
    mapping above (there may be multiple ways). For example, "11106" can be mapped into:
        - "AAJF" with the grouping (1 1 10 6)
        - "KJF" with the grouping (11 10 6)
    Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

    In addition to the mapping above, an encoded message may contain the '*' character, which can represent any digit
    from '1' to '9' ('0' is excluded). For example, the encoded message "1*" may represent any of the encoded messages
    "11", "12", "13", "14", "15", "16", "17", "18", or "19". Decoding "1*" is equivalent to decoding any of the encoded
    messages it can represent.

    Given a string s containing digits and the '*' character, return the number of ways to decode it.

    Since the answer may be very large, return it modulo 10^9 + 7.

    Example 1:
    Input: s = "*"
    Output: 9
    Explanation: The encoded message can represent any of the encoded messages "1", "2", "3", "4", "5", "6", "7", "8", or "9".
    Each of these can be decoded to the strings "A", "B", "C", "D", "E", "F", "G", "H", and "I" respectively.
    Hence, there are a total of 9 ways to decode "*".

    Example 2:
    Input: s = "1*"
    Output: 18
    Explanation: The encoded message can represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19".
    Each of these encoded messages have 2 ways to be decoded (e.g. "11" can be decoded to "AA" or "K").
    Hence, there are a total of 9 * 2 = 18 ways to decode "1*".

    Example 3:
    Input: s = "2*"
    Output: 15
    Explanation: The encoded message can represent any of the encoded messages "21", "22", "23", "24", "25", "26", "27", "28", or "29".
    "21", "22", "23", "24", "25", and "26" have 2 ways of being decoded, but "27", "28", and "29" only have 1 way.
    Hence, there are a total of (6 * 2) + (3 * 1) = 12 + 3 = 15 ways to decode "2*".

    Constraints:
        1 <= s.length <= 10^5
        s[i] is a digit or '*'.
     */
    //TC: O(n)
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];

        //dp[0] represents the number of ways to decode the empty string, since there are no ways, its value is 1
        dp[0] = 1;

        //decode the first character in s
        dp[1] = decodeSingle(s.charAt(0));


        for (int i = 2; i <= s.length(); i++) {
            //extract a single digit using the current char
            char curr = s.charAt(i - 1);

            //extract the previous character so we now have 2 digits, prev + curr, e.g. 1 0 or 1 *
            char prev = s.charAt(i - 2);

            /*
                number of ways to decode up to ith character is the number of ways to decode all previous characters *
                however many letters the current digit(s) can decode to
             */
            dp[i] += dp[i - 1] * decodeSingle(curr); //one digit so we only add i - 1
            dp[i] += dp[i - 2] * decodeDouble(prev, curr); // two digits so we add i - 2, two digits back from ith character

            //mod dp[i] since the value may be large
            dp[i] %= (int) (1e9 + 7);
        }

        //return the number of ways to decode s
        return (int) dp[s.length()];
    }

    private int decodeSingle(char c) {
        //a wildcard symbol means the digit can be any number from 1-9
        if (c == '*') {
            return 9;
        }
        //zero is not mapped to any letter
        else if (c == '0') {
            return 0;
        }
        //a single digit can map to a single letter
        return 1;
    }

    private int decodeDouble(char first, char second) {
        switch (first) {
            case '*':
                /*
                    two wildcard chars means the number of codes can be from 11-26 excluding 10 and 20
                    since the * cant be 0
                */
                if (second == '*') {
                    return 15;
                }
                //can be any value from the set 10-16 and 20-26
                else if (second >= '0' && second <= '6') {
                    return 2;
                }
            case '1':
                //1 + * are values from 11-19
                if (second == '*') {
                    return 9;
                }
                // map to 11
                else {
                    return 1;
                }
            case '2':
                //all values from 21-26
                if (second == '*') {
                    return 6;

                }
                //map to a value from 20-26
                else if (second >= '0' && second <= '6') {
                    return 1;
                }
            default:
                // an invalid number was encountered, e.g. first = 0
                return 0;
        }
    }
}
