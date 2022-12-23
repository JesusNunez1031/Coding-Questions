package leetCode.strings;

public class reverseStringII {
    /*
    Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the
    start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater
    than or equal to k characters, then reverse the first k characters and left the other as original.

    Example:
    Input: s = "abcdefg", k = 2
    Output: "bacdfeg"
    Restrictions:
    The string consists of lower English letters only.
    Length of the given string and k will in the range [1, 10000]
     */
    //TC: O(n) where n is the length of the s and O(n) space where n is the length of s
    private static String reverseStr(String s, int k) {
        char[] str = s.toCharArray();

        //traverse the array by 2 * k characters
        for (int i = 0; i < str.length; i += 2 * k) {
            //reverse k characters in s from i if there are more than k characters left, k - 1 to account for i
            if (i + k - 1 < str.length) {
                reverse(str, i, i + k - 1);
                //if there are less than k characters left, we reverse the remaining characters
            } else {
                reverse(str, i, str.length - 1);
            }
        }
        return String.valueOf(str);
    }

    //Method to reverse a section of a char array from index "left" to index "right"
    private static void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}
