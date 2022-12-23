package leetCode.bitManipulation;

import java.util.HashMap;

public class singleNumber {
    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

    Example 1:
    Input: nums = [2,2,1]
    Output: 1

    Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4

    Example 3:
    Input: nums = [1]
    Output: 1

    Constraints:
        1 <= nums.length <= 3 * 10^4
        -3 * 10^4 <= nums[i] <= 3 * 10^4
        Each element in the array appears twice except for one element which appears only once.
     */

    /*
        Method in O(n) time and space [Time Exceeds], we store all numbers into a map with the count of their appearance
        in the array, then we search through the keys and return the key with the count of 1
     */
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int val : nums) {
            if (!(map.containsKey(val))) {
                map.put(val, 1);
            } else {
                map.put(val, map.get(val) + 1);
            }

            for (int num : map.keySet()) {
                if (map.get(num) == 1) {
                    res = num;
                    break;
                }
            }
        }
        return res;
    }

    //Optimized solution is O(n) time and constant space
    /*
     Basic definition of XOR: "If there's a difference then give me the difference and if we're the same we're going to
     cancel out and result to 0"

        Ex: nums = [2,2,1]
        the first iteration 0^2 gives us 2, however, when we visit the next 2, this value cancels back out to 0. When we
        visit 1, we get a value of 1 which is the value we want, and since the problem states that we are ensured at
        least one unique value, we just have to do one pass and all duplicate values will cancel each other out resulting
        in the only non duplicate value
     */
    public static int singleNumberOp(int[] nums) {
        int single = 0;

        //we use the XOR expression, so all duplicates cancel out leaving only the unique value
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] ar = {2, 2, 1, 3, 4, 3, 4};

        System.out.println(singleNumberOp(ar));
    }
}

