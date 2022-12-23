package codingbat.warmup_2;

public class noTriples {
    /*

Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array. Return true if the array does not contain any triples.

    codingbat.warmup_2.noTriples([1, 1, 2, 2, 1]) → true
    codingbat.warmup_2.noTriples([1, 1, 2, 2, 2, 1]) → false
    codingbat.warmup_2.noTriples([1, 1, 1, 2, 2, 2, 1]) → false
     */
    public boolean noTriples(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1]) {
                if (nums[i + 1] == nums[i + 2]) {
                    return false;
                }
            }
        }
        return true;
    }
}
