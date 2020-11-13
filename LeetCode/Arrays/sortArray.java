import java.util.Arrays;

public class sortArray {
    /*
    Given an array of integers nums, sort the array in ascending order.
    Example 1:
    Input: nums = [5,2,3,1]
    Output: [1,2,3,5]

    Example 2:
    Input: nums = [5,1,1,2,0,0]
    Output: [0,0,1,1,2,5]
     */

    //QuickSort TC: O(n log n) worst time: O(n^2) given a bad index
    public static int[] sortArrayQS(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }

        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quicksort(int[] arr, int left, int right) {

        if (left < right) {
            int finalPivotIndex = partition(arr, left, right);

            quicksort(arr, left, finalPivotIndex - 1);
            quicksort(arr, finalPivotIndex + 1, right);
        }
    }

    /*
        The partition function that chooses a pivot, partitions the array around the pivot, places the pivot value
        where it belongs, and then returns the index of where the pivot belongs if it where sorted
    */

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];

        /*
        keep track of the tail of the section of items less than the pivot so we can add the pivot in between the section
        less than it and section greater than it
        */

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);    //swap the last value with i + 1 value since all values before i + 1 are now less than it

        return i + 1; //return the pivot's sorted index
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 21, 32, 1, 53, 3, 10, 4, 6};

        System.out.println(Arrays.toString(sortArrayQS(arr)));
    }
}

