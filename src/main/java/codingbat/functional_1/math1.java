package codingbat.functional_1;

import java.util.List;

public class math1 {
    /*

    Given a list of integers, return a list where each integer is added to 1 and the result is multiplied by 10.

    codingbat.functional_1.math1([1, 2, 3]) → [20, 30, 40]
    codingbat.functional_1.math1([6, 8, 6, 8, 1]) → [70, 90, 70, 90, 20]
    codingbat.functional_1.math1([10]) → [110]
     */
    public List<Integer> math1(List<Integer> nums) {
        nums.replaceAll(n -> (n + 1) * 10);
        return nums;
    }
}
