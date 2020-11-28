import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    /*
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.

    Example 1:

    Input: [3,2,3]
    Output: 3
     */

    //Method works iif the given values are 0 <= nums
    private static int majorityElementNonNeg(int[] nums) {
        int[] occurrences = new int[100];

        for (int j : nums) {
            occurrences[j]++;
        }

        int maxCount = Integer.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] > maxCount) {
                maxCount = occurrences[i];
                num = i;
            }
        }
        return num;
    }

    //Method Using a hashmap
    private int majorityElementMap(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            //If the map contains the value nums[i] and its appearance in the array is greater than nums.length / 2, we return it
            if (map.containsKey(i) && map.get(i) + 1 > nums.length / 2) {
                return i;
            } else {
                //Otherwise, we add it to the map, if it already exists, we just +1 its count, if not we default it to an initial value of 1
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return -1;
    }

    //Boyer-Moore Voting Algorithm
    private static int findMajority(int[] nums) {
        //Variables for the number of times a number shows up and the number that is the candidate
        int count = 0;
        int candidate = 0;

        for (int i : nums) {
            //when the count is at 0, we choose the current value in the array as the candidate
            if (count == 0) {
                candidate = i;
            }
            //Increment the count only if the current number i is the candidate, otherwise subtract 1
            count += (i == candidate) ? 1 : -1;
        }
        return candidate;
    }

    //Cheese solution is to sort array and return the center element TC: O(n log n)
    private static int findMajorityCheese(int[] nums) {
        Arrays.sort(nums);

        /*
            sorting the array, the majority element is found at n/2 array is of odd length and n/2 + 1 if even
         */
        return nums[nums.length / 2];
    }

    private static void main(String[] args) {

        //The fastest approach is Moore's Algorithm since we constantly do O(1) operations O(n) times
        int[] arr = {3, 2, 3};

        System.out.println(majorityElementNonNeg(arr));
    }


}
