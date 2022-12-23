package codingbat.functional_1;

import java.util.List;

public class rightDigit {
    /*
    Given a list of non-negative integers, return an integer list of the rightmost digits. (Note: use %)

    codingbat.functional_1.rightDigit([1, 22, 93]) → [1, 2, 3]
    codingbat.functional_1.rightDigit([16, 8, 886, 8, 1]) → [6, 8, 6, 8, 1]
    codingbat.functional_1.rightDigit([10, 0]) → [0, 0]
     */
    public List<Integer> rightDigit(List<Integer> nums) {
        nums.replaceAll(n -> n % 10);
        return nums;
    }
}
