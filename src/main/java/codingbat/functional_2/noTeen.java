package codingbat.functional_2;

import java.util.List;

public class noTeen {
    /*
    Given a list of integers, return a list of those numbers, omitting any that are between 13 and 19 inclusive.

    codingbat.functional_2.noTeen([12, 13, 19, 20]) → [12, 20]
    codingbat.functional_2.noTeen([1, 14, 1]) → [1, 1]
    codingbat.functional_2.noTeen([15]) → []
     */
    public List<Integer> noTeen(List<Integer> nums) {
        nums.removeIf(n -> n >= 13 && n <= 19);
        return nums;
    }
}
