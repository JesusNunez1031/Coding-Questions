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
            int difference;
            //if the index returned is the first, the difference is the current value arr1[i] - the value in arr2[arr2_index]
            if (arr2_index == 0) {
                difference = Math.abs(val - arr2[arr2_index]);
                //otherwise we check which value in arr2 yields the lower difference, the value at index arr2_index or the value at index arr2_index - 1
            } else {
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
        int[] a1 = {-803, 715, -224, 909, 121, -296, 872, 807, 715, 407, 94, -8, 572, 90, -520, -867, 485, -918, -827, -728, -653, -659, 865, 102, -564, -452, 554, -320, 229, 36, 722, -478, -247, -307, -304, -767, -404, -519, 776, 933, 236, 596, 954, 464};
        int[] a2 = {817, 1, -723, 187, 128, 577, -787, -344, -920, -168, -851, -222, 773, 614, -699, 696, -744, -302, -766, 259, 203, 601, 896, -226, -844, 168, 126, -542, 159, -833, 950, -454, -253, 824, -395, 155, 94, 894, -766, -63, 836, -433, -780, 611, -907, 695, -395, -975, 256, 373, -971, -813, -154, -765, 691, 812, 617, -919, -616, -510, 608, 201, -138, -669, -764, -77, -658, 394, -506, -675, 523, 730, -790, -109, 865, 975, -226, 651, 987, 111, 862, 675, -398, 126, -482, 457, -24, -356, -795, -575, 335, -350, -919, -945, -979, 611};
        int d = 37;
        System.out.println(findTheDistanceValue(a1, a2, d));
    }
}
