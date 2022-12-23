package codingbat.array_2;

public class only14 {
    /*
    Given an array of ints, return true if every element is a 1 or a 4.

    codingbat.array_2.only14([1, 4, 1, 4]) → true
    codingbat.array_2.only14([1, 4, 2, 4]) → false
    codingbat.array_2.only14([1, 1]) → true
     */
    public boolean only14(int[] nums) {
        int counter = 0;
        for (int num : nums) {
            if (num == 1 || num == 4) {
                counter++;
            }
        }
        return counter == nums.length;
    }

// //OR
// public boolean codingbat.array_2.only14(int[] nums) {
//     for(int i = 0; i < nums.length; i++) {
//         if(nums[i] != 1 && nums[i] != 4)
//             return false;
//     }
//     return true;
// }
}
