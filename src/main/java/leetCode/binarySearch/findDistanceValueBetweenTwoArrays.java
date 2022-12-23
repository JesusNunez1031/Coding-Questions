package leetCode.binarySearch;

import java.util.Arrays;

public class findDistanceValueBetweenTwoArrays {
    /*
    Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
    The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.

    Example 1:
    Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
    Output: 2
    Explanation:
    For arr1[0]=4 we have:
    |4-10|=6 > d=2
    |4-9|=5 > d=2
    |4-1|=3 > d=2
    |4-8|=4 > d=2
    For arr1[1]=5 we have:
    |5-10|=5 > d=2
    |5-9|=4 > d=2
    |5-1|=4 > d=2
    |5-8|=3 > d=2
    For arr1[2]=8 we have:
    |8-10|=2 <= d=2
    |8-9|=1 <= d=2
    |8-1|=7 > d=2
    |8-8|=0 <= d=2

    Example 2:
    Input: arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
    Output: 2

    Example 3:
    Input: arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
    Output: 1

    Constraints:
        1 <= arr1.length, arr2.length <= 500
        -10^3 <= arr1[i], arr2[j] <= 10^3
        0 <= d <= 100
     */
    //Native Approach, search all values in both arrays
    private static int findTheDistanceValueBrute(int[] arr1, int[] arr2, int d) {
        int count = arr1.length;
        for (int k : arr1) {
            for (int i : arr2) {
                if (Math.abs(k - i) <= d) {
                    count -= 1;
                    break;
                }
            }
        }
        return count;
    }

    //Optimized solution O(n long n) solution using binary search
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int count = arr1.length;

        for (int val : arr1) {
            int arr2_index = searchForClosest(arr2, val);
            System.out.println(arr2[arr2_index]);
            int difference;
            /*
                if the index returned is the first value in arr2, index 0, then this MUST be the smallest value that can
                be used to compute difference
             */
            if (arr2_index == 0) {
                difference = Math.abs(val - arr2[arr2_index]);
            } else {
                /*
                    for any other index, we check the returned index and the index - 1 in array2 to ensure we get
                    the smallest possible difference to satisfy the condition that "there is not any element arr2[j]
                    where |arr1[i] - arr2[j]| <= d"
                    Ex:
                        assume arr2 = [1, 4, 41, 70, 89] and the current value in arr1 is 55
                        "searchForClosest" will return index 3 which is 70 as the closest value to 55

                        |55 - 70| = 15

                        if the distance d = 14, and we only use 15 as the current "distance" then we will get the wrong
                        output since |55 - 41| = 14 since we need to ensure "there is not any element arr2[j] where
                        |arr1[i] - arr2[j]| <= d"

                        therefore, to ensure we always get the smallest possible difference for every value in arr1, we
                        do "difference = Math.min(Math.abs(val - arr2[arr2_index - 1]), Math.abs(val - arr2[arr2_index]));"
                 */
                difference = Math.min(Math.abs(val - arr2[arr2_index - 1]), Math.abs(val - arr2[arr2_index]));
            }
            //if the difference is in range of d, decrement count
            if (difference <= d) {
                count--;
            }
        }
        return count;
    }

    //method searches for the closest value to the target in nums or "arr2" and returns its index
    public static int searchForClosest(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] a1 = {4, 5, 6, 8};
        int[] a2 = {10, 9, 1, 8, 7};
        int d = 2;
        System.out.println(searchForClosest(new int[] {1, 4, 41, 70, 89}, 55));
        //System.out.println(findTheDistanceValue(a1, a2, d));
    }
}
