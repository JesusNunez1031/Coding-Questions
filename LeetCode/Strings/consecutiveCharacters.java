public class consecutiveCharacters {
    /*
    Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
    Return the power of the string.

    Example 1:
    Input: s = "leetcode"
    Output: 2
    Explanation: The substring "ee" is of length 2 with the character 'e' only.

    Example 2:
    Input: s = "abbcccddddeeeeedcba"
    Output: 5
    Explanation: The substring "eeeee" is of length 5 with the character 'e' only.

    Example 3:
    Input: s = "triplepillooooow"
    Output: 5

    Example 4:
    Input: s = "hooraaaaaaaaaaay"
    Output: 11

    Example 5:
    Input: s = "tourist"
    Output: 1
     */
    //TC: O(n)
    public static int maxPower(String s) {
        int i = 0, j = 0;
        int pow = 1;

        while (i < s.length() - 1) {
            //if the next character in the string is equal to the current, we try and find how long it is
            if (s.charAt(i) == s.charAt(i + 1)) {
                char c = s.charAt(i);
                int len = 0;
                j = i;
                //while the subsequent character is equal to the next character, we add to the length
                while (j < s.length() && s.charAt(j) == c) {
                    len++;
                    j++;
                }
                //compare length found with the current longest
                pow = Math.max(pow, len);
                //set i to the end of the last equal character
                i = j-1;
            }
            i++;
        }
        return pow;
    }

    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";
        System.out.println(maxPower(s));
    }
}
