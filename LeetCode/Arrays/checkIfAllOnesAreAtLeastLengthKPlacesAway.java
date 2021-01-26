public class checkIfAllOnesAreAtLeastLengthKPlacesAway {
    /*
    Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other,
    otherwise return False.

    Example 1:
    Input: nums = [1,0,0,0,1,0,0,1], k = 2
    Output: true
    Explanation: Each of the 1s are at least 2 places away from each other.

    Example 2:
    Input: nums = [1,0,0,1,0,1], k = 2
    Output: false
    Explanation: The second 1 and third 1 are only one apart from each other.

    Example 3:
    Input: nums = [1,1,1,1,1], k = 0
    Output: true

    Example 4:
    Input: nums = [0,1,0,1], k = 1
    Output: true

    Constraints:
        1 <= nums.length <= 10^5
        0 <= k <= nums.length
        nums[i] is 0 or 1
     */

    //TC: O(n)
    public boolean kLengthApart(int[] nums, int k) {
        int distance = 0;
        boolean seen_one = false; //triggers after the first one is encountered in nums

        for (int num : nums) {
            /*
                if we see a one, check if the distance is at least k, otherwise, reset the distance to 0 and flag to true
                since distance between 1's is > than k.
             */
            if (num == 1) {
                if (distance < k && seen_one) {
                    return false;
                } else {
                    distance = 0;
                    seen_one = true;
                }
            }
            distance++;
        }
        return true;
    }
}
