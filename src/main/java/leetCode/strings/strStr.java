package leetCode.strings;

public class strStr {
    /*
    Implement leetCode.strings.strStr().
    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Clarification:
    What should we return when needle is an empty string? This is a great question to ask during an interview.
    For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's
    strstr() and Java's indexOf().

    Example 1:
    Input: haystack = "hello", needle = "ll"
    Output: 2

    Example 2:
    Input: haystack = "aaaaa", needle = "bba"
    Output: -1

    Example 3:
    Input: haystack = "", needle = ""
    Output: 0

    Constraints:
        0 <= haystack.length, needle.length <= 5 * 104
        haystack and needle consist of only lower-case English characters.
     */

    /*
        Algorithm implemented is Rabin-Karp string matching using a rolling hash function to check for the first occurrence
        of a pattern in a string of text

        Time Complexity: O(m - n) worst case O(m * n) where n is the needle and m is the haystack
     */

    //Method to convert the string to a unique hashcode value
    private static long getValue(String s) {
        long num = 0;
        int power = s.length() - 1;
        for (char n : s.toCharArray()) {
            num += (n - 'a') * Math.pow(2, power--);
        }
        return num;
    }

    private static int strStr(String haystack, String needle) {
        //check if both strings are equal
        if (haystack.equals(needle)) {
            return 0;
        }
        //if the needle is larger than haystack, its not possible to find needle in haystack
        if (needle.length() > haystack.length()) {
            return -1;
        }

        long needVal = getValue(needle);
        int i = 1;
        long power = (long) Math.pow(2, needle.length() - 1);
        long strHash = getValue(haystack.substring(0, needle.length()));

        if (needVal == strHash) {
            return 0;
        }

        while (i <= haystack.length() - needle.length()) {
            //subtract the value of the first character in the substring
            strHash -= (getValue(haystack.substring(i - 1, i)) * power);
            /*
                the new substring is now missing a value of magnitude of "power", (2^needle.length - 1), since the the start
                character takes the power of the deleted character

                Ex:
                    "hello" ==> substring = "he" | hash = ('h' - 'a') * 2 ^ 1 + ('e' - 'a') * 2 ^ 0

                when the value of "h" is removed, 'e' value needs to be changed by a magnitude of 2, since the new substring
                will be "el" | hash = ('e' - 'a') * 2 ^ 1 + ('l' - 'a') * 2 ^ 0 hence we multiply by 2

            */
            strHash *= 2;

            //finally we add the new hash value of the next character, its power will always be 0 since its the last character in the substring
            strHash += getValue(String.valueOf(haystack.charAt(i + needle.length() - 1)));

            //if the hashcode value of the needle matches the hashcode value of str, we found a match
            if (needVal == strHash) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        //String haystack = "ababcaababcaabc";
        //String needle = "ababcaabc";
        String haystack = "abbbbbaabbaabaabbbaaaaabbabbbabbbbbaababaabbaabbbbbababaababbbbaaabbbbabaabaaaabbbbabbbaabbbaabbaaabaabaaaaaaaa";
        String needle = "babaababbbbaaabbb";

        System.out.println(strStr(haystack, needle));
    }
}
