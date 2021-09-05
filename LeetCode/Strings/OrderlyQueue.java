import java.util.Arrays;

public class OrderlyQueue {
    /*
    You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the
    end of the string..

    Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

    Example 1:
    Input: s = "cba", k = 1
    Output: "acb"
    Explanation:
    In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
    In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".

    Example 2:
    Input: s = "baaca", k = 3
    Output: "aaabc"
    Explanation:
    In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
    In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".


    Constraints:
        1 <= k <= s.length <= 1000
        s consist of lowercase English letters.
     */
    public String orderlyQueue(String s, int k) {
        // no possible reorder moves
        if (k == 0) {
            return s;
        }

        String result = s;
        if (k == 1) {
            /*
                only one character can be considered for the length of s, hence we send the current ith character to the
                end at every iteration and update the result if the new reordered string is lower in lexicographical order
                than the current result string.
             */
            for (int i = 1; i < s.length(); i++) {
                /*
                    take the last part of s up to i and then add the first part to the end to simulate moving the first
                    character from the front to the end
                 */
                String reorderedStr = s.substring(i) + s.substring(0, i);

                if (result.compareTo(reorderedStr) > 0) {
                    result = reorderedStr;
                }
            }
        } else {
            /*
                when k > 1, we can choose to reorder a character from a set of k strings at each iteration, since we
                want the smallest lexicographical string from s, we would always choose the character with the lowest
                lexicographic order to send to end of the current sting. If these steps are repeated, in the end we
                would always end with a sorted string created from the characters in s, hence to avoid manually doing the
                steps, we sort s and return the string generated.
             */
            char[] strArray = s.toCharArray();
            Arrays.sort(strArray);
            return new String(strArray);
        }
        return result;
    }
}
