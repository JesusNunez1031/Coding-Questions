import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findAllDuplicatesInArray {
    /*
    Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    Find all the elements that appear twice in this array.

    Could you do it without extra space and in O(n) runtime?

    Example:
    Input:
    [4,3,2,7,8,2,3,1]

    Output:
    [2,3]
     */
    //Slow method using a HashSet
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> dups = new ArrayList<>();

        for (int i : nums) {
            if (!set.add(i)) {
                dups.add(i);
            }
        }
        return dups;
    }

    //Faster method using a frequency array
    public List<Integer> findDuplicatesA(int[] nums) {
        int[] freq = new int[nums.length + 1];
        List<Integer> dups = new ArrayList<>();

        for (int num : nums) {
            freq[num]++;
            if (freq[num] > 1) {
                dups.add(num);
            }
        }
        return dups;
    }

    /*
        since we know that the numbers in the array are in the range of 1 to nums.length, we know the lowest possible
        value in the array is 1 therefore every time we come to a new value, we use it as an index and mark the value at the
        index of the number's value, so if we see a 7, we mark the value at index 7 - 1 as negative, therefore if we see another
        7, the value will already be negative so we'll know we've seen it before. We subtract 1 from the index to avoid
        index bounds issues since the size of the array is a value in the range but is not a valid index
    */
    public List<Integer> findDuplicatesM(int[] nums) {
        //the result list does not count as extra space
        List<Integer> dups = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;  //get the index of the value, use abs in case value is already negative

            //if the value is negative, we have seen it before so we add the index + 1 since that is the value
            if (nums[index] < 0) {
                dups.add(index + 1);
            }
            //turn the number at the index to a negative value
            nums[index] = -nums[index];
        }
        return dups;
    }
}
