public class BinarySearch {

    //Recursive Time complexity -> O(logn) Space complexity -> O(logn)
    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
            //if the item is not found return -1
        } else if (start >= end) {
            return -1;
        } else {
            /*
            if the item in the middle is greater than the target value, we search the upper half of the array.
            Otherwise we search the lower half

             */
            if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, end, target);
            } else {
                return binarySearch(nums, start, mid, target);
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};

        System.out.println(search(arr, 2));
    }
}
