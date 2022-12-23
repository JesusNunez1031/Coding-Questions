package leetCode.slidingWindow_twoPointer;

public class countBinarySubstrings {
    /*
    Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and
    all the 0's and all the 1's in these substrings are grouped consecutively.

    Substrings that occur multiple times are counted the number of times they occur.

    Example 1:
    Input: "00110011"
    Output: 6
    Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
    Notice that some of these substrings repeat and are counted the number of times they occur.
    Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.

    Example 2:
    Input: "10101"
    Output: 4
    Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.

    Note:
        s.length will be between 1 and 50,000.
        s will only consist of "0" or "1" characters.
     */
    //TC: O(n)
    public int countBinarySubstrings(String s) {
        //count of binary substrings
        int substrings = 0;

        //index variable
        int i = 1;

        /*
            prev holds the count of either '1' or '0', depending on where ith value does not equal i - 1
            curr holds the count of the first character, either '1' or '0', its also set to 1 since we start from the
            second character
         */
        int prev = 0, curr = 1;

        while (i < s.length()) {
            /*
                when we switch from a group of 0's to 1's or vice versa, we add to the total count of substrings the value
                of the smallest count, since in order to make a valid binary string substring, they must have equal number
                of consecutive 1's and 0's, hence if we've seen 5 1's and 4 0's, there are only 4 valid substrings
             */
            if (s.charAt(i) != s.charAt(i - 1)) {
                substrings += Math.min(curr, prev);

                /*
                    set the count of prev to the current count since we are switching groups and reset curr to 1 since we
                    are at the start of a new group
                 */
                prev = curr;
                curr = 1;
            } else {
                //if we are still in the same group, add 1 to the current group
                curr++;
            }
            i++;
        }
        //return the remaining valid substrings
        return substrings + Math.min(curr, prev);
    }
}
