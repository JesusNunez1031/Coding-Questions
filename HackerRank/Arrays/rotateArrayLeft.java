import java.util.List;

public class rotateArrayLeft {

    /*
        A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.
        Given an integer, d, rotate the array that many steps left and return the result.
     */
    /*Trick is the reverse the whole array, since we are moving values to the left, we then reverse the last d values in array,
    if we were moving values right we would reverse the first d values.After that we reverse the first d-1 values in array
     */
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        d = d % arr.size();
        reverse(arr, 0, arr.size() - 1);
        reverse(arr, arr.size() - d, arr.size() - 1);
        reverse(arr, 0, (arr.size() - d) - 1);

        return arr;
    }

    public static void reverse(List<Integer> nums, int start, int end) {

        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}
