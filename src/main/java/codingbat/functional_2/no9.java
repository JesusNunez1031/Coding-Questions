package codingbat.functional_2;

import java.util.List;

public class no9 {
    /*
    Given a list of non-negative integers, return a list of those numbers except omitting any that end with 9. (Note: % by 10)

    codingbat.functional_2.no9([1, 2, 19]) → [1, 2]
    codingbat.functional_2.no9([9, 19, 29, 3]) → [3]
    codingbat.functional_2.no9([1, 2, 3]) → [1, 2, 3]
     */
    public List<Integer> no9(List<Integer> nums) {
        nums.removeIf(n -> n % 10 == 9);
        return nums;
    }
}
