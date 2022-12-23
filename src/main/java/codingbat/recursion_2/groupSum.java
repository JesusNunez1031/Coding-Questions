package codingbat.recursion_2;

public class groupSum {
    /*
    Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given
    target? This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in
    this problem, you can use the same pattern for many problems to search a space of choices. Rather than looking at
    the whole array, our convention is to consider the part of the array starting at index start and continuing to the
    end of the array. The caller can specify the whole array simply by passing start as 0. No loops are needed -- the
    recursive calls progress down the array.

    codingbat.recursion_2.groupSum(0, [2, 4, 8], 10) → true
    codingbat.recursion_2.groupSum(0, [2, 4, 8], 14) → true
    codingbat.recursion_2.groupSum(0, [2, 4, 8], 9) → false
     */
    public static boolean groupSum(int start, int[] nums, int target) {
        //Base case if there are no numbers left, then there is a solution only if target is 0
        if (start >= nums.length) {
            return target == 0;
        }

        //Key idea: nums[start] is chosen or it is not
        //Deal with nums[start], letting recursion deal with all the rest of the array

        //Recursive call trying the case that nums[start] is chosen
        //subtract it from target in the call
        if (groupSum(start + 1, nums, target - nums[start])) {
            return true;
        }

        //Recursive call trying the case that nums[start] is not chosen
        return groupSum(start + 1, nums, target);   //if neither of the above worked, it is not possible
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 8};

        System.out.println(groupSum(0, arr, 10));
    }
}
