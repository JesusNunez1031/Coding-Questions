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

    //Math solution
    public List<Integer> findDuplicatesM(int[] nums) {
        //since we know all values in the array are in the range of 1 to nums.length we can use their indexes to check for duplicates
        List<Integer> dups = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;  //get the index of the value, use abs in case value is negative

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
