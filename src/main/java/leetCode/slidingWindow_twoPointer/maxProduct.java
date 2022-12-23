package leetCode.slidingWindow_twoPointer;

public class maxProduct {
    /*
        Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).

        Example 1:
        Input: nums = [3,4,5,2]
        Output: 12
        Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.

        Example 2:
        Input: nums = [1,5,4,5]
        Output: 16
        Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.

        Example 3:
        Input: nums = [3,7]
        Output: 12

*/
    public int maxProduct(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        int i = 0, j = 0;

        for (int z = 0; z < nums.length; z++) {
            if (nums[z] > nums[i]) {
                i = z;
            }
        }
        int max2 = Integer.MIN_VALUE;

        for (int z = 0; z < nums.length; z++) {
            if (nums[z] >= max2 && z != i) {
                max2 = nums[z];
                j = z;
            }
        }
        return (nums[i] - 1) * (nums[j] - 1);
    }

//     public int leetCode.slidingWindow_twoPointer.maxProduct(int[] nums) {
//         if(nums.length < 2) {
//             return nums[0];
//         }

//         Arrays.sort(nums);

//         return (nums[nums.length-2]-1) * (nums[nums.length-1]-1);
//     }
}
