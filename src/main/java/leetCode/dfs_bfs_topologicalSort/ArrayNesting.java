package leetCode.dfs_bfs_topologicalSort;

public class ArrayNesting {
    /*
    You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].

    You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:
        - The first element in s[k] starts with the selection of the element nums[k] of index = k.
        - The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
        - We stop adding right before a duplicate element occurs in s[k].
    Return the longest length of a set s[k].

    Example 1:
    Input: nums = [5,4,0,3,1,6,2]
    Output: 4
    Explanation:
    nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
    One of the longest sets s[k]:
    s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}

    Example 2:
    Input: nums = [0,1,2]
    Output: 1

    Constraints:
        1 <= nums.length <= 10^5
        0 <= nums[i] < nums.length
        All the values of nums are unique.
     */
    //TC: O(n) SC: O(n) due to recursion
    public int arrayNesting(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            //if the current index has not been visited, dfs search for a new sequence
            if (!(nums[i] < 0)) {
                max = Math.max(max, dfs(nums, i));
            }
        }
        return max;
    }

    private int dfs(int[] nums, int start) {
        // check bounds and if we haven't visited the current index
        if (start < 0 || start >= nums.length || nums[start] < 0) {
            return 0;
        }

        // save the next value to be visited before marking it as visited
        int next = nums[start];

        // mark the current index as visited by setting it to Integer.MIN
        nums[start] = Integer.MIN_VALUE;

        // increase the length of the current sequence and visit the next index
        return 1 + dfs(nums, next);

        /*
            we don't bother marking indexes as unvisited since we don't want to do duplicate work i.e. repeating a
            sequence starting from a later value
         */
    }
}