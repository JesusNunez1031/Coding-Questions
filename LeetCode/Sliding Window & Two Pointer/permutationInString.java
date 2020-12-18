import java.util.Arrays;

public class permutationInString {
    /*
    Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words,
    one of the first string's permutations is the substring of the second string.

    Example 1:
    Input: s1 = "ab" s2 = "eidbaooo"
    Output: True
    Explanation: s2 contains one permutation of s1 ("ba").

    Example 2:
    Input:s1= "ab" s2 = "eidboaoo"
    Output: False

    Constraints:
        The input strings only contain lower case letters.
        The length of both given strings is in range [1, 10,000].
     */
    //TC:(Alphabet Size[26] * n) where n is the length of s2
    public boolean checkInclusion(String s1, String s2) {
        //if the length of s1 is larger than s2, there is not way s2 can have a permutation of s1
        if (s1.length() > s2.length()) {
            return false;
        }

        //arrays to hold the frequency of each characters in s1 and s2
        int[] s1_freq = new int[26];
        int[] s2_freq = new int[26];

        int i = 0, j = 0;   //window, i = start j = end

        //add the frequency count of each character into s1_freq and also the the frequency count of the first s2 s1.length characters
        while (j < s1.length()) {
            s1_freq[s1.charAt(j) - 'a']++;
            s2_freq[s2.charAt(j) - 'a']++;
            j++;
        }
        j--;    //decrease the end of window j by one to be at the actual end of window since 0 indexed

        while (j < s2.length()) {
            //if both frequency arrays are equal, the current window in s2 can be a permutation of s1
            if (Arrays.equals(s1_freq, s2_freq)) {
                return true;
            }
            //check if we can move the window by one to the right
            if (++j != s2.length()) {
                //move the window right by one so we add the new character at j + 1
                s2_freq[s2.charAt(j) - 'a']++;
            }
            //remove the character count at i and increment i to slide window
            s2_freq[s2.charAt(i++) - 'a']--;
        }
        return false;
    }
}
