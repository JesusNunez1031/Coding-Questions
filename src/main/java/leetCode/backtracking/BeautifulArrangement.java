package leetCode.backtracking;

public class BeautifulArrangement {
    /*
    Suppose you have n integers from 1 to n. We define a beautiful arrangement as an array that is constructed by these
    n numbers successfully if one of the following is true for the ith position (1 <= i <= n) in this array:
        The number at the ith position is divisible by i.
        i is divisible by the number at the ith position.

    Given an integer n, return the number of the beautiful arrangements that you can construct.

    Example 1:
    Input: n = 2
    Output: 2
    Explanation:
    The first beautiful arrangement is [1, 2]:
    Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
    Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
    The second beautiful arrangement is [2, 1]:
    Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
    Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

    Example 2:
    Input: n = 1
    Output: 1

    Constraints:
        1 <= n <= 15
     */
    public static int isBeautiful = 0; //number of ways
    //TC: O(n!) since we check all leetCode.backtracking.permutations of n arrangements
    private int countArrangement(int n) {
        //array to hold values from 1 to n that have been visited
        boolean[] visited = new boolean[n + 1];
        checkBeautiful(n, 1, visited);
        return isBeautiful;
    }

    private void checkBeautiful(int n, int pos, boolean[] visited) {
        //when we are at a position greater then n, we know the arrangement is beautiful
        if (pos > n) {
            isBeautiful++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            /*
                we only visit a position if its not visited, and if the the number at the ith position is divisible by i
                of i is divisible by the number at the ith position.
             */
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                checkBeautiful(n, pos + 1, visited);
                visited[i] = false;
            }
        }
    }

    /*------------------------------------------------------------------------------------------------------------------
        Method 2, we check the array of n values first and only backtrack if the conditions of a beautiful arrangement
        satisfy
        TC: O(k) where k is the number of arrangements and O(n) space used to hold values in range of n
     */
    private static int countArrangementEz(int n) {
        int[] nums = new int[n + 1];
        //populate the nums array with n values
        for(int i = 1; i <= n;i++) {
            nums[i] = i;
        }
        checkBeautiful(n, nums);

        return isBeautiful;
    }

    private static void checkBeautiful(int pos, int[] nums) {
        //if we make it from the end to the start, that means the arrangement is beautiful
        if(pos == 0) {
            isBeautiful++;
            return;
        }
        /*
            start at the end, swap the values at index i with the value at the current position check if the arrangement
            of nums satisfy the condition of beautiful and if it does, call on the function to make the next permutation,
            and move to the next position, otherwise, swap back the values to backtrack
         */
        for(int i = pos;i > 0;i--) {
            swap(nums, i, pos);
            if(nums[pos] % pos == 0 || pos % nums[pos] == 0) {
                checkBeautiful(pos - 1, nums);
            }
            swap(nums, i, pos);
        }
    }
    //method to swap values
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(countArrangementEz(n));
    }
}
