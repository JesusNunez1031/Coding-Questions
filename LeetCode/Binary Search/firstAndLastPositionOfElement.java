import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class firstAndLastPositionOfElement {
    /*
        Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
        If target is not found in the array, return [-1, -1].
        Follow up: Could you write an algorithm with O(log n) runtime complexity?

        Example 1:
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]
     */
    public static int[] searchRange1(int[] nums, int target) {
        int first = firstPos(nums, target);
        int last = firstPos(nums, target + 1) - 1;

        if (first <= last) {
            return new int[]{first, last};
        }
        return new int[]{-1, -1};
    }

    public static int firstPos(int[] a, int target) {
        int n = a.length;
        int first_pos = n;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] >= target) {
                first_pos = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return first_pos;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);

        return result;
    }

    private static int findEndingIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            //if the value is found or is less, we want to move right by one
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                //otherwise we move the pointer 1 to the right
                end = mid - 1;
            }
            //if the nums[mid] != target, we still hold the reference to the previous pointer
            if (nums[mid] == target) {
                target = mid;
            }
        }
        return index;
    }

    private static int findStartingIndex(int[] nums, int target) {
        //in case target does not exist, return -1
        int index = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            //if the value is found or is greater, we want to move left by one
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                //otherwise we move the pointer 1 to the right
                start = mid + 1;
            }
            if (nums[mid] == target) {
                target = mid;
            }
        }
        return index;
    }
static int count = 0;
    public static void main(String[] args) {
//        int[] arr = {5, 7, 7, 8, 8, 10};
//        System.out.println(Arrays.toString(searchRange1(arr, 8)));
       List<Integer> list = new ArrayList<>();



    }
}
