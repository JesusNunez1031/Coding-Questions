package leetCode.slidingWindow_twoPointer;

public class SortArrayByParityII {
    /*
    Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

    Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

    Return any answer array that satisfies this condition.

    Example 1:
    Input: nums = [4,2,5,7]
    Output: [4,5,2,7]
    Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

    Example 2:
    Input: nums = [2,3]
    Output: [2,3]

    Constraints:
        2 <= nums.length <= 2 * 10^4
        nums.length is even.
        Half of the integers in nums are even.
        0 <= nums[i] <= 1000

    Follow Up: Could you solve it in-place?
     */
    //TC: O(n)
    public int[] sortArrayByParityII(int[] nums) {
        // start the odd pointer on an even index and the even pointer on an odd index
        int oddNumAtEvenIndex = 0;
        int evenNumAtOddIndex = 1;
        int n = nums.length;

        while (oddNumAtEvenIndex < n && evenNumAtOddIndex < n) {
            // look for the next odd number located on an even index
            while (oddNumAtEvenIndex < n && nums[oddNumAtEvenIndex] % 2 == 0) {
                oddNumAtEvenIndex += 2;
            }

            // look for the next even number located on an odd index
            while (evenNumAtOddIndex < n && nums[evenNumAtOddIndex] % 2 != 0) {
                evenNumAtOddIndex += 2;
            }

            /*
                swap values so that the odd number found on an even index is switched to an odd index and the even number
                found on an odd index is switched to an even index
             */
            if (oddNumAtEvenIndex < n && evenNumAtOddIndex < n) {
                swap(nums, oddNumAtEvenIndex, evenNumAtOddIndex);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    //TC/SC: O(n) using extra space
    public int[] sortArrayByParityIIEz(int[] nums) {
        int evenIndex = 0;
        int oddIndex = 1;

        int[] paritySorted = new int[nums.length];

        for (int num : nums) {
            // place any even number on the next open even index
            if (num % 2 == 0) {
                paritySorted[evenIndex] = num;
                evenIndex += 2;
            } else {
                //place any odd number on the next open odd index
                paritySorted[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return paritySorted;
    }
}
