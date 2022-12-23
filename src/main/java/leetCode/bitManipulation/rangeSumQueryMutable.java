package leetCode.bitManipulation;

public class rangeSumQueryMutable {
    /*
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    The update(i, val) function modifies nums by updating the element at index i to val.

    Example:
    Given nums = [1, 3, 5]
    sumRange(0, 2) -> 9
    update(1, 2)
    sumRange(0, 2) -> 8


    Constraints:
        The array is only modifiable by the update function.
        You may assume the number of calls to update and sumRange function is distributed evenly.
        0 <= i <= j <= nums.length - 1
     */
    /*
        Time Complexities:
                    Method    |    Time Complexity
              constructTree() |      O(m log n)
                updateTree()  |      O(log n)
                  update()    |      O(log n)
                    sum()     |      O(log n)
                  sumRange()  |      O(log n)

          where m is the number of values in nums & n is the number of LSB's (rightmost bit) in index
     */
    static class NumArray {
        //Fenwick Tree array
        public int[] FT;
        public int[] nums;

        //initialize a Binary Indexed tree of size nums + 1
        public NumArray(int[] nums) {
            FT = new int[nums.length + 1];  //+1 since we want an 1 indexed array
            this.nums = nums;
            constructTree(nums);
        }

        //Constructs the Fenwick tree using values in nums
        private void constructTree(int[] nums) {
            for (int i = 1; i <= nums.length; i++) {
                updateTree(i, nums[i - 1]);
            }
        }

        //Updates index i in Tree by value
        public void updateTree(int i, int val) {
            /*
                when we update any index in the tree, we need to make sure its update propagates through the rest of the
                array meaning for every index i, val will be added to FT[i]
             */
            while (i < FT.length) {
                FT[i] += val;
                i = i + (i & -i);   //add LSB
            }
        }

        //updates index i in the tree to value
        public void update(int i, int val) {
            /*
                if we want to set value 3 to 2, 2 - 3 = -1, when we call updateTree, -1's value will propagate through the
                Tree so if the array is [1 3 5], after the update, [1, 2, 5]
             */
            int diff = val - nums[i];

            //index = i + 1 since we are 1 indexed
            int index = i + 1;
            updateTree(index, diff);

            //update index i in the nums array to val
            nums[i] = val;
        }

        //returns the sum from index 0 up to i, e.g. [0, i]
        public int sum(int i) {
            i++;    // 1 indexed so we increment i first
            int sum = 0;
            while (i > 0) {
                sum += FT[i];
                i = i - (i & -i);
            }
            return sum;
        }

        //Returns sum in the range i to j, e.g. [i,j]
        public int sumRange(int i, int j) {
        /*
            To get the sum in a specific range, we calculate the sum from [0, j] and
            [0, i - 1] and subtract their values
        */
            return sum(j) - sum(i - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,8};
        NumArray tree = new NumArray(arr);
        System.out.println(tree.sumRange(1, 0));
    }
}
