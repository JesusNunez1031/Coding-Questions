package leetCode.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class summaryRanges {
    /*
    You are given a sorted unique integer array nums.

    Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of
    nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

    Each range [a,b] in the list should be output as:
        - "a->b" if a != b
        - "a" if a == b

    Example 1:
    Input: nums = [0,1,2,4,5,7]
    Output: ["0->2","4->5","7"]
    Explanation: The ranges are:
    [0,2] --> "0->2"
    [4,5] --> "4->5"
    [7,7] --> "7"

    Example 2:
    Input: nums = [0,2,3,4,6,8,9]
    Output: ["0","2->4","6","8->9"]
    Explanation: The ranges are:
    [0,0] --> "0"
    [2,4] --> "2->4"
    [6,6] --> "6"
    [8,9] --> "8->9"

    Example 3:
    Input: nums = []
    Output: []

    Example 4:
    Input: nums = [-1]
    Output: ["-1"]

    Example 5:
    Input: nums = [0]
    Output: ["0"]

    Constraints:
        0 <= nums.length <= 20
        -2^31 <= nums[i] <= 2^31 - 1
        All the values of nums are unique.
        nums is sorted in ascending order.
     */
    //TC: O(n)
    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i]; //initialize a new start of range
            //while values increment by 1
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            /*
                when we encounter an increment of more than 1, we've got our range, if the start != end range is from
                [start to nums[i]], else, its just [start]
             */
            StringBuilder sb = new StringBuilder();
            sb.append(start);
            if (start != nums[i]) {
                sb.append("->").append(nums[i]);
            }
            ranges.add(sb.toString());
        }
        return ranges;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 6, 7, 8, 10};
        System.out.println(summaryRanges(nums).toString());
    }
}
