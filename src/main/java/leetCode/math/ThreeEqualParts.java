package leetCode.math;

public class ThreeEqualParts {
    /*
    You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such
    that all of these parts represent the same binary value.

    If it is possible, return any [i, j] with i + 1 < j, such that:
        - arr[0], arr[1], ..., arr[i] is the first part,
        - arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
        - arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
        - All three parts have equal binary values.
    If it is not possible, return [-1, -1].

    Note that the entire part is used when considering what binary value it represents. For example, [1,1,0] represents
    6 in decimal, not 3. Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.

    Example 1:
    Input: arr = [1,0,1,0,1]
    Output: [0,3]

    Example 2:
    Input: arr = [1,1,0,1,1]
    Output: [-1,-1]

    Example 3:
    Input: arr = [1,1,0,0,1]
    Output: [0,2]

    Constraints:
        3 <= arr.length <= 3 * 10^4
        arr[i] is 0 or 1
     */

    //TC: O(n)
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int onesCount = 0; // number of 1's in arr

        //count the number of ones
        for (int num : arr) {
            onesCount += num;
        }

        //return the entire array as a division if no ones are present
        if (onesCount == 0) {
            return new int[]{0, n - 1};
        }

        //if the number of 1's is not divisible by 3, then 3 equal divisions are not possible
        if (onesCount % 3 != 0) {
            return new int[]{-1, -1};
        }

        //pointers to the start of the first second and last, division
        int start = 0, mid = 0, end = 0;

        //number of ones per division
        int avgOnesCount = onesCount / 3;

        //reset the count of ones so we can keep track of the number of ones seen so far and determine the start of each divisions
        onesCount = 0;

        /*
            Look for the first occurrence of '1' for each division of the array.
		    Ex: arr = [0, 1, 1, 0, | 0, 0, 1, 1, 0, | 1, 1, 0]

		    Since the count of ones is 6 and 6 / 3 = 2, after every +2 index we are standing on the next division. 0 +, 2 +, 4 + ...
		Therefore:
            First occurrence of '1' for the first chunk is on the index of 1
            First occurrence of '1' for the second chunk is on the index of 6
            First occurrence of '1' for the third chunk is on the index of 9
        */
        for (int i = 0; i < n; i++) {
            //skip all zeros
            if (arr[i] != 0) {
                //mark the start of the first division
                if (onesCount == 0) {
                    start = i;
                }

                /*
                    when the number of ones seen so far == the number of 1's per division, we know we are at the start of
                    the middle division since the previous division has "avgOnesCount" already
                 */
                if (onesCount == avgOnesCount) {
                    mid = i;
                }

                /*
                    similar to finding the middle, the to find the last division we know we are at the start of the last
                    division if the number of ones seen so far is 2 * "avgOnesCount", *2 to account for previous 2 divisions
                 */
                if (onesCount == 2 * avgOnesCount) {
                    end = i;
                }

                onesCount++;
            }
        }

        /*
            all pointers are at the first occurrence of the one in the respective division, all that is left to do is
            move all three pointers simultaneously while all their values match, i.e. while the binary value represented
            in the division is the same across all the divisions, [all the bits match]
        */
        while (end < n && arr[start] == arr[mid] && arr[mid] == arr[end]) {
            start++;
            mid++;
            end++;
        }

        /*
            if we reach end then the binary values in each division matched so return (start-1, mid), the array where
            all bits are equal
         */
        if (end == n) {
            return new int[]{start - 1, mid};
        }

        //no equal divisions possible
        return new int[]{-1, -1};
    }
}
