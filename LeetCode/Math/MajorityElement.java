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
    public static int majorityElementNonNeg(int[] nums) {
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
    public int majorityElementMap(int[] nums) {
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
    public static int findMajority(int[] nums) {
        //Variables for the number of times a number shows up and the number that is the candidate
        int count = 0;
        Integer candidate = null;

        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            //Increment the count only if the current number i is the candidate, otherwise subtract 1
            count += (i == candidate) ? 1 : -1;
        }
        return candidate;
    }

    //Cheese solution is to sort array and return the center element
    public static int findMajorityCheese(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {

        //The fastest approach is Moore's Algorithm since we constantly do O(1) operations O(n) times
        int[] arr = {3, 2, 3};

        System.out.println(majorityElementNonNeg(arr));
    }


}
