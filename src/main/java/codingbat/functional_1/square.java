package codingbat.functional_1;

import java.util.List;

public class square {
    /*
    Given a list of integers, return a list where each integer is multiplied with itself.

    codingbat.functional_1.square([1, 2, 3]) → [1, 4, 9]
    codingbat.functional_1.square([6, 8, -6, -8, 1]) → [36, 64, 36, 64, 1]
    codingbat.functional_1.square([]) → []
     */
    public List<Integer> square(List<Integer> nums) {
        nums.replaceAll(n -> n * n);
        return nums;
    }
}
