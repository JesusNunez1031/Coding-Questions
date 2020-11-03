import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestSubarrayOfUniqueValues {

    /*
    Find the longest subarray with unique values and return its length
        input: nums = [2, 5, 6, 2, 4, 1, 5, 6]
        Output: 5
        Explanation: [5, 6, 2, 4, 1]
     */

    public static int longestSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();

       int max = 0;
        for (int num : nums) {
            if (!set.add(num)) {
                max = Math.max(max, set.size());
                set.clear();
                set.add(num);
            }
        }
        return Math.max(max, set.size());
    }

    public static void main(String[] args) {
        //int[] arr = {2, 5, 6, 2, 4, 1, 5, 6};
        //int[] arr = {1, 2, 2, 4, 6, 5, 10, 11, 2, 12, 20};
        int[] arr = {1, 2, 3, 4, 6, 5, 10, 11, 0, 12, 20};
        System.out.println(longestSubarray(arr));
    }
}