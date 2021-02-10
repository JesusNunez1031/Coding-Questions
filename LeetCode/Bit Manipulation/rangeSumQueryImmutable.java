public class rangeSumQueryImmutable {
    /*
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e.,
    sum(nums[i], nums[i + 1], ... , nums[j]))

    Example 1:
    Input
    ["NumArray", "sumRange", "sumRange", "sumRange"]
    [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
    Output
    [null, 1, -1, -3]

    Explanation
    NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
    numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
    numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
    numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))


    Constraints:
        0 <= nums.length <= 10^4
        -10^5 <= nums[i] <= 10^5
        0 <= i <= j < nums.length
        At most 104 calls will be made to sumRange.
     */
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    //TC: O(n log n), time to construct the fenwick tree using the nums array
    class Fenwick {
        int[] tree;

        public Fenwick(int[] nums) {
            this.tree = new int[nums.length + 1];
            constructTree(nums);
        }

        public void update(int i, int k) {
            while(i < tree.length) {
                tree[i] += k;
                i = i + (i & -i);
            }
        }

        private void constructTree(int[] nums) {
            for(int i = 1;i <= nums.length;i++) {
                update(i, nums[i - 1]);
            }
        }

        public int rangeSum(int start, int end) {
            return sum(end) - sum(start - 1);
        }

        public int sum(int i) {
            int sum = 0;
            while(i > 0) {
                sum += tree[i];
                i = i - (i & -i);
            }
            return sum;
        }
    }
    class NumArray {
        Fenwick fenwick;

        public NumArray(int[] nums) {
            //initialize a fenwick tree using the nums array
            fenwick = new Fenwick(nums);
        }

        public int sumRange(int i, int j) {
            //use the range sum from the fenwick tree, also add 1 to i and j since tree is 1 indexed
            return fenwick.rangeSum(++i, ++j);
        }
    }
}
