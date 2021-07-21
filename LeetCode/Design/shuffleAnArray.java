import java.util.Random;

public class shuffleAnArray {
    /*
    Given an integer array nums, design an algorithm to randomly shuffle the array.
    Implement the Solution class:

    Solution(int[] nums) Initializes the object with the integer array nums.
    int[] reset() Resets the array to its original configuration and returns it.
    int[] shuffle() Returns a random shuffling of the array.


    Example 1:
    Input
    ["Solution", "shuffle", "reset", "shuffle"]
    [[[1, 2, 3]], [], [], []]
    Output
    [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

    Explanation
    Solution solution = new Solution([1, 2, 3]);
    solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
    solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
    solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]

    Constraints:
        1 <= nums.length <= 200
        -106 <= nums[i] <= 106
        All the elements of nums are unique.
        At most 5 * 104 calls will be made to reset and shuffle.
     */
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */

    //TC: O(n) and space since we clone the original array multiple times
    private final int[] original;
    private int[] nums;

    public shuffleAnArray(int[] nums) {
        //save a copy of nums onto original so we can reference it on resets
        this.original = nums.clone();
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        //copy the original array to the nums and return nums
        this.nums = original.clone();

        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    /*
        shuffle the array using Fisher-Yates Algorithm, where we generate a random index
        between the current index and the last index. In this case we start from the last value
        in the array, picking a new index is like taking a number from a hat every time where after
        we take one, there are n - 1 more choices left.
        Ex:
            at first we can choose an index from 0 - 6, assuming an array of length 6
            next, we can choose a new index from 0 - 5
            next, we can choose a new index from 0 - 4
                                                   .
                                                   .
                                                   .
                                                 0 - 1 - final options
     */
    public int[] shuffle() {
        Random rand = new Random();

        for (int i = nums.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);

            //swap values nums[index] with nums[i]
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
