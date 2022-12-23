package codingbat.functional_2;

import java.util.List;

public class noNeg {
    /*
    Given a list of integers, return a list of the integers, omitting any that are less than 0.

    codingbat.functional_2.noNeg([1, -2]) → [1]
    codingbat.functional_2.noNeg([-3, -3, 3, 3]) → [3, 3]
    codingbat.functional_2.noNeg([-1, -1, -1]) → []
     */
    public List<Integer> noNeg(List<Integer> nums) {
        nums.removeIf(n -> n < 0);
        return nums;
    }
}
