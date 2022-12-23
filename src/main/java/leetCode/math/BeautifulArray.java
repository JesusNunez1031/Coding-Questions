package leetCode.math;

import java.util.ArrayList;

public class BeautifulArray {
    /*
    For some fixed n, an array nums is beautiful if it is a permutation of the integers 1, 2, ..., n, such that:
        For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].

    Given n, return any beautiful array nums.  (It is guaranteed that one exists.)

    Example 1:
    Input: n = 4
    Output: [2,1,4,3]

    Example 2:
    Input: n = 5
    Output: [3,1,2,5,4]

    Note:
        1 <= n <= 1000
     */
    public int[] beautifulArray(int n) {
        ArrayList<Integer> bArr = new ArrayList<>();
        //when n == 1, only 1 is int the array
        bArr.add(1);

        /*
          [1]
          [1] x2-1; [1] x2
          [1, 2] x2-1; [1, 2] x2
          [1, 3, 2, 4] x2-1; [1, 3, 2, 4] x2
          [1, 5, 3, 7, 2, 6, 4, 8] x2-1; ........x2
         */

        while (bArr.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();

            //generate subarray of odds
            for (int num : bArr) {
                //only add values that are <= n
                if (2 * num - 1 <= n) {
                    temp.add((2 * num) - 1);
                }
            }

            //generate subarray of evens after the odds
            for (int num : bArr) {
                //only add values that are <= n
                if (2 * num <= n) {
                    temp.add(2 * num);
                }
            }
            //set the result array to the new calculated array
            bArr = temp;
        }

        //convert beautiful Array to primitive array
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = bArr.get(i);
        }
        return result;
    }
}
