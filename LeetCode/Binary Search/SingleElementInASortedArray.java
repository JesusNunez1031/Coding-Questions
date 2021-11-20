public class SingleElementInASortedArray {
    /*
    You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
    element which appears exactly once.

    Return the single element that appears only once.

    Your solution must run in O(log n) time and O(1) space.

    Example 1:
    Input: nums = [1,1,2,3,3,4,4,8,8]
    Output: 2

    Example 2:
    Input: nums = [3,3,7,7,10,11,11]
    Output: 10

    Constraints:
        1 <= nums.length <= 10^5
        0 <= nums[i] <= 10^5
     */
    //TC: O(log n)
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // handle edge cases
        if (nums.length == 1) return nums[0];
        else if (nums[left] != nums[left + 1]) return nums[left];
        else if (nums[right] != nums[right - 1]) return nums[right];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            /*
                The single element is found when the number before and after it do not match since duplicates appear one
                after the other
             */
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            /*
                pairs always start on an even index so,
                if the index mid is even and the value to the right of its index is a duplicate then we want to check the
                right part of the array since we know the unique value will not be on the left otherwise mid would be odd

                if the index mid is odd and the value at the previous index is a duplicate, we also want to check the right
                part of the array since the pair starts on an even index thus if the unique value was to the left, mid
                would not be odd
             */
            else if ((nums[mid] == nums[mid + 1] && mid % 2 == 0) || (nums[mid] == nums[mid - 1] && mid % 2 != 0)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // no single elements found
    }

    // TC:O(n) using xor to cancel out all duplicates
    public int singleNonDuplicateXOR(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }
        /*
            Because there is one unique value guaranteed and all duplicates only appear twice, the resulting value will
            be the only value that appears once
         */
        return xor;
    }

    // XOR with Binary Search
    public int singleNonDuplicateXorBS(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int m = (left + right) / 2;

            /*
                if mid is even, the next element would be mid ^ 1
                if mid is odd, the previous element will be mid ^ 1
             */
            if (nums[m] == nums[m ^ 1]) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        // the single element will be on the left and right ptr since the previous and next values do not match
        return nums[right];
    }
}
