import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    /*
    You are given an integer array nums and you have to return a new counts array. The counts array has the property
    where counts[i] is the number of smaller elements to the right of nums[i].

    Example 1:
    Input: nums = [5,2,6,1]
    Output: [2,1,1,0]
    Explanation:
    To the right of 5 there are 2 smaller elements (2 and 1).
    To the right of 2 there is only 1 smaller element (1).
    To the right of 6 there is 1 smaller element (1).
    To the right of 1 there is 0 smaller element.

    Example 2:
    Input: nums = [-1]
    Output: [0]

    Example 3:
    Input: nums = [-1,-1]
    Output: [0,0]

    Constraints:
        1 <= nums.length <= 10^5
        -10^4 <= nums[i] <= 10^4
     */
    //O(N * LogN)
    public static List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //find the smallest value in nums, this will be the lower bound in the segment tree
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        //nums2 is an array of all values in nums - the min
        int[] nums2 = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            //subtract each value in nums by the min, +1 to avoid negatives
            nums2[i] = nums[i] - min + 1;

            /*
                we want the smallest values to the right of each index, so the max will be the largest value in the
                array - min, this is because
             */
            max = Math.max(nums2[i], max);
        }

        //Fenwick tree, of size max + 1 to account for the max value
        int[] tree = new int[max + 1];
        List<Integer> res = new LinkedList<>();

        //Search from the end of nums, for each value in nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            /*
                get the sum of values from 1 to nums2[i], i.e. the smallest value right of nums[i]; -1 to not include
                the value itself, otherwise nums2[i] could be returned
             */
            res.add(0, get(nums2[i] - 1, tree));

            //add 1 to the right of the index value of nums2[i]
            update(nums2[i], tree);
        }
        return res;
    }

    //returns the range sum [1, i], all values smaller than nums2[i]
    private static int get(int i, int[] tree) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }

    /*
        since we dont want the actual prefix sum from [1, i], we add 1 to all indexes to the right of i, this reflects all
        the values that would be less than i
     */
    private static void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i]++;
            i += i & (-i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {15, 2, 6, 10};
        countSmaller(nums);
    }
}
