import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]

    Constraints:
        2 <= nums.length <= 10^3
        -10^9 <= nums[i] <= 10^9
        -10^9 <= target <= 10^9
        Only one valid answer exists.
     */

    //TC: O(n) time and space -> Solution using a hashmap, find the complement of every value to the target and check if the result is in the map
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        //add All the values in nums array into the map with the index as the value
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        /*
            iterate through all the values in nums and take the compliment of the value to the target amd check if the map has the value
            if the map has it, return the index of the current value of and the index of the compliment
        */

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];

            //if the map has the compliment and the index of the compliment isn't the current index, return the indexes
            if (map.containsKey(comp) && map.get(comp) != i) {
                return new int[]{i, map.get(comp)};
            }
        }
        //there are no two numbers in nums that sum up to target
        return new int[]{-1, -1};
    }

    //TC/S: O(n)
    public int[] twoSumEzz(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //map stores each of the values in nums with its index as the value

        for (int i = 0; i < nums.length; i++) {
            //if the map contains the difference, a pair was found and return the index of nums[i] and the difference
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            }

            //add the current number and index to the map
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /*
        TC: O(n) time and constant space using two pointers. At every step, we check if nums[i] + nums[j] > or < than target, if the
        result is greater, then we decrement j, if its less, we increase i. if i == j, then there is no solution
        Note: This solution is only valid if nums has no duplicates and is sorted
    */
    public int[] twoSumEz(int[] nums, int target) {
        //int[] clone = nums.clone();
        int i = 0, j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }

            if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        //no solution was found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}
