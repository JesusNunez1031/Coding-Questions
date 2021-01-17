public class productOfArrayExceptSelf {
    /*
    Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
    of all the elements of nums except nums[i].

    Example:
    Input:  [1,2,3,4]
    Output: [24,12,8,6]
    Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

    Note: Please solve it without division and in O(n).

    Follow up:
        Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
     */

    /*
        Intuitive way by using division, calculate the total product in the array, if there are no zeros, then the at
        each index, the value will be the result of the total product / nums[index]
        TC: O(n) and constant space, however we use division
     */
    private int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        int zeros = 0;  //counter to check for zeros

        for (int i : nums) {
            if (i != 0) {
                product *= i;
            } else {
                zeros++;
            }
        }

        if (zeros > 0) {
            //if there are more than one zeros, every product will be a zero
            if (zeros > 1) {
                return res;
            }

            //if there is only one zero, only the value that is 0 will be the product, everything else is 0
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    res[i] = product;
                    break;
                }
            }
        } else {
            //there are no zeros in the array, so we can iterate through all the values and the value at each index is the total product divided by the value in the index
            for (int i = 0; i < res.length; i++) {
                res[i] = product / nums[i];
            }
        }
        return res;
    }

    /*
        method using extra space, we calculate the total product up to a specific value in nums and store it in one array, then we use
        another array and find the product the same way we did previous except now we start from the end, at the end we get the final products
        by cross multiplying all the values from one array with the other
            Ex: given array [1, 2, 3, 4]

            left_prod will hold the product of all values to the left of a specific index
            left_prod = [1, 1, 2, 6]

            right_prod will hold the product of all values to the right of a specific index
            right_prod = [24, 12, 4, 1]

            to get the final result, we cross multiply all values from left and right to get the final result
            result = [24 * 1, 12 * 1, 4 * 2, 1 * 6] -> [24, 12, 8, 6]
    */
    private int[] productExceptSelfExtraSpace(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int[] left_prod = new int[n];
        int[] right_prod = new int[n];

        //since there is nothing before the first value and after the last value, we set the first value and last value of specified array to 1
        left_prod[0] = 1;
        right_prod[n - 1] = 1;

        //find the left products of each value in nums
        for (int i = 1; i < n; i++) {
            left_prod[i] = left_prod[i - 1] * nums[i - 1];
        }

        //do the same as before but starting from the end
        for (int i = n - 2; i >= 0; i--) {
            right_prod[i] = right_prod[i + 1] * nums[i + 1];
        }

        //cross multiply values to get final result
        for (int i = 0; i < nums.length; i++) {
            res[i] = left_prod[i] * right_prod[i];
        }

        return res;
    }

    /*
        To implement this method using only constant space, we do the same as we did for the left right arrays, except we use the result array for the first pass,
        and then use a temp variable to hold the entire running product starting from the end. Note that the result array does not count as extra space
    */
    private int[] productExceptSelfNoSpace(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        //since there is nothing before the first value, we set the first value to 1
        res[0] = 1;

        //find the left products of each value in nums
        for (int i = 1; i < n; i++) {
            //product left to ith value is the product of all values before i * value before i in nums
            res[i] = res[i - 1] * nums[i - 1];
        }

        //there is nothing to the right of the last value in the array so we set the running_product value to 1;
        int running_product = 1;

        //start from the end and set the current value in the array to the running_product of all values right of the index
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= running_product;
            running_product *= nums[i];     //update the running_product with the current value at nums
        }
        return res;
    }
}
