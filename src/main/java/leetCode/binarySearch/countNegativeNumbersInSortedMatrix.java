package leetCode.binarySearch;

public class countNegativeNumbersInSortedMatrix {

    //Brute force method to search the entire grid TC: O(n * m)
    private int countNegatives(int[][] grid) {
        int negatives = 0;

        for (int[] row : grid) {
            for (int val : row) {
                if (val < 0) {
                    negatives++;
                }
            }
        }
        return negatives;
    }

    //Binary Search method TC: O(n * log n) since we perform a binary search for n rows
    private static int countNegativesBS(int[][] grid) {
        int negatives = 0;

        //pass on each row to a helper method that will perform BS on the row
        for (int[] row : grid) {
            /*
                search returns the index of the first negative value, since the array is sorted, all values after it
                will also be negative so subtracting the index from the length gives us the number of negative values
                in the array
                Ex:
                    if the row is length 4 and the first negative value is at index 2, there are 2 negative values
             */
            negatives += row.length - search(row);
        }
        return negatives;
    }

    private static int search(int[] nums) {
        int left = 0;
        int right = nums.length;

        //search for the index of the first negative value in the row and break
        while (left < right) {
            int mid = left + (right - left) / 2;

            /*
                if the nums[mid] is not negative move right, otherwise, we move the right pointer to mid since that could
                be the start of the first negative value
             */
            if (nums[mid] >= 0) {
                left = mid + 1;
            } else {
                right = mid;

            }
        }
        return right;   //return right in case the array has no negative numbers
    }

    public static void main(String[] args) {
        int[][] arr = {{-4, -3, -2, -1}, {-3, -2, -1, -1}, {-1, -1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(countNegativesBS(arr));
    }
}
