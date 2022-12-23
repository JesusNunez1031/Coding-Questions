package codingbat.array_3;

public class canBalance {

    /*
    Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.

    codingbat.array_3.canBalance([1, 1, 1, 2, 1]) → true
    codingbat.array_3.canBalance([2, 1, 1, 2, 1]) → false
    codingbat.array_3.canBalance([10, 10]) → true

        O(n) solution using two pointers to find the sum of each side.
        If the sum of values up to our left pointer is less > than the sum of all the values up to the right pointer, then we add to right and
        decrement right, otherwise we add to left and inc the pointer, at the end if both left and right are equal we can return true
     */
    public static boolean canBalance(int[] nums) {
        int left = 0;
        int right = 0;
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            if (left < right) {
                left += nums[i++];
            } else {
                right += nums[j--];
            }
        }
        return left == right;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 1};

        System.out.println(canBalance(arr));
    }
}
