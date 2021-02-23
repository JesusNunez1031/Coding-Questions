import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class majorityElement {
    /*
    Given an array of size n, find the majority element. The majority element is the element that appears more than
    ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.

    Example 1:
    Input: [3,2,3]
    Output: 3
     */

    //Method Using a hashmap O(n) time and space
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
    /*
        Using Boyer-Moore Voting Algorithm, set a counter to 1 and the majority element to the first number in  the array.
        Iterate through the list once, and if we encounter the same "majority element" we increase the counter, otherwise
        decrease the counter. When the counter reaches 0, we set the "majority element" to the current element and reset
        the counter to 1.

        Next, we iterate the array again having known the "majority element", when we encounter the "majority"
        we increase a counter, at the end, if the counter is greater than ⌊ n/2 ⌋, where n is the length of the array,
        then this is indeed the majority element, otherwise, there is no such element.

        Note: here we don't do a second iteration since the majority element is guaranteed
    */

    //TC: O(2n) if the majority is not guaranteed so we need to check nums again, O(n) if the majority element is guaranteed and constant space
    private static int findMajority(int[] nums) {
        int counter = 1;
        int majority_element = nums[0];

        for (int val : nums) {
            //if we find another occurrence of majority_element, increase its count, otherwise decrease the count
            if (val == majority_element) {
                counter++;
            } else {
                counter--;
            }

            //if the counter reaches 0, reset count and pick new majority
            if (counter == 0) {
                counter = 1;
                majority_element = val;
            }
        }
        //"majority element" is guaranteed so we don't have to check if its occurrence is > ⌊ n/2 ⌋
        return majority_element;
    }

    //Cheese solution is to sort array and return the center element TC: O(n log n)
    private static int findMajorityCheese(int[] nums) {
        Arrays.sort(nums);

        /*
            sorting the array, the majority element is found at n/2 array is of odd length and n/2 + 1 if even
         */
        return nums[nums.length / 2];
    }
}
