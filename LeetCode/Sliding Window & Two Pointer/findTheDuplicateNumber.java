public class findTheDuplicateNumber {
    /*
    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    There is only one duplicate number in nums, return this duplicate number.

    Follow-ups:
        How can we prove that at least one duplicate number must exist in nums?
        Can you solve the problem without modifying the array nums?
        Can you solve the problem using only constant, O(1) extra space?
        Can you solve the problem with runtime complexity less than O(n2)?


    Example 1:
    Input: nums = [1,3,4,2,2]
    Output: 2

    Example 2:
    Input: nums = [3,1,3,4,2]
    Output: 3

    Example 3:
    Input: nums = [1,1]
    Output: 1

    Example 4:
    Input: nums = [1,1,2]
    Output: 1


    Constraints:
        2 <= n <= 3 * 104
        nums.length == n + 1
        1 <= nums[i] <= n
        All the integers in nums appear only once except for precisely one integer which appears two or more times.
     */
    public static int findDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }

        //slow will traverse the array one index at a time, and fast will traverse array two times as fast as slow
        int slow = nums[0];
        int fast = nums[nums[0]];

        /*
            since the array values are from 1-n, we will only have one intersection if the array is visualized as a linked list
            or graph. This approach works only if we don't have a value 0 in the array since having a zero will give us two intersections.
            First we move slow and fast through the array and we break out of the loop once they meet. This is always guaranteed
            since there is exactly one value that appears more than once

            Ex:              0  1  2  3  4 - indexes
                given array [3, 4, 1, 4, 2] as a linked list: 3 -> 4 -> 2 -> 1 -> 4 -> points back to 2
                                                                        |_____________|
             when this loop ends, the slow and fast will be at the the value 1
         */
        while (slow != fast) {
            //move slow by one and fast by 2
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        /*
            once we find an intersection point, we reset either slow or fast to the front of the array, and then move them
            one step at at time now, when fast hits the value or "node" just before the intersection, slow will also be
            at the same value but at a different location, however, also just before the intersection node. Since slow and
            fast are equal, we break and return fast since it is at our duplicate value

            from the previous example, fast is at the value 1 and slow is reset to the initial value of 3. When they move one forward
            fast is at 4 and slow is also at 4, both pointers are just before the intersection, so we break out because
            they are equal values and return the value at either slow or fast
         */

        slow = 0;       //we can reset either slow or fast, it does not matter
        while (slow != fast) {
            //move one index at a time
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;    //both pointers are at the duplicate value, we can return either slow or fast
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 4};
        System.out.println(findDuplicate(arr));
    }
}
