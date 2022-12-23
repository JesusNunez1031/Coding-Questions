package codingbat.functional_1;

import java.util.List;

public class doubling {
    /*
    Given a list of integers, return a list where each integer is multiplied by 2.

    codingbat.functional_1.doubling([1, 2, 3]) → [2, 4, 6]
    codingbat.functional_1.doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
    codingbat.functional_1.doubling([]) → []
     */
    public List<Integer> doubling(List<Integer> nums) {
        nums.replaceAll(n -> n * 2);
        return nums;
    }
}
