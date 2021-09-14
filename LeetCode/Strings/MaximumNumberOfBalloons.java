public class MaximumNumberOfBalloons {
    /*
    Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

    You can use each character in text at most once. Return the maximum number of instances that can be formed.

    Example 1:
    Input: text = "nlaebolko"
    Output: 1

    Example 2:
    Input: text = "loonbalxballpoon"
    Output: 2

    Example 3:
    Input: text = "leetcode"
    Output: 0

    Constraints:
        1 <= text.length <= 10^4
        text consists of lower case English letters only.
     */
    //TC: O(n) where n is the length of text
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        // get the frequency of each character in text
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        // Normalize o and l which need 2 letters
        freq['l' - 'a'] /= 2;
        freq['o' - 'a'] /= 2;

        String str = "balloon";
        int maxBalloons = Integer.MAX_VALUE;

        /*
            The number of times we can generate "balloon" is bounded by the smallest frequency of each letter included
            in the word, i.e. 'b', 'a', 'l', 'o', 'n'
         */
        for (char c : str.toCharArray()) {
            maxBalloons = Math.min(maxBalloons, freq[c - 'a']);
        }
        return maxBalloons;
    }
}
