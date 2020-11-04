import java.util.*;

public class sortArrayByIncreasingFrequency {
    /*
    Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
    Return the sorted array.

    Example 1:
    Input: nums = [1,1,2,2,2,3]
    Output: [3,1,1,2,2,2]
    Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

    Example 2:
    Input: nums = [2,3,1,3,2]
    Output: [1,3,3,2,2]
    Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

    Example 3:
    Input: nums = [-1,1,-6,4,5,-6,1,4,1]
    Output: [5,-1,4,4,-6,-6,1,1,1]
     */
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        //list of map entries
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        //sort the list in descending order of frequency
        list.sort((a, b) -> {
            //if the value of a and b are equal, then sort them by their key value "frequency" in descending value
            return !a.getValue().equals(b.getValue()) ? a.getValue().compareTo(b.getValue()) : b.getKey().compareTo(a.getKey());
        });

        int[] result = new int[nums.length];
        int index = 0;

        for (Map.Entry<Integer, Integer> curr : list) {
            //every iteration, add the keyValue from index to index + frequency, then we move the index to the end of the frequency count
            Arrays.fill(result, index, index + curr.getValue(), curr.getKey());
            index += curr.getValue();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3};

        System.out.println(Arrays.toString(frequencySort(arr)));
    }
}
