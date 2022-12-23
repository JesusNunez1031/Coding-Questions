package codeWars.arrays;

public class equalSidesOfAnArray {
    /*
    You are going to be given an array of integers. Your job is to take that array and find an index N where the sum of
    the integers to the left of N is equal to the sum of the integers to the right of N. If there is no index that would
    make this happen, return -1.

    For example:
    Let's say you are given the array {1,2,3,4,3,2,1}: Your function will return the index 3, because at the 3rd position
    of the array, the sum of left side of the index ({1,2,3}) and the sum of the right side of the index ({3,2,1}) both
    equal 6.

    Let's look at another one.
    You are given the array {1,100,50,-51,1,1}: Your function will return the index 1, because at the 1st position of
    the array, the sum of left side of the index ({1}) and the sum of the right side of the index ({50,-51,1,1}) both
    equal 1.

    Last one:
    You are given the array {20,10,-80,10,10,15,35}
    At index 0 the left side is {}
    The right side is {10,-80,10,10,15,35}
    They both are equal to 0 when added. (Empty arrays are equal to 0 in this problem)
    Index 0 is the place where the left side and right side are equal.

    Note: Please remember that in most programming/scripting languages the index of an array starts at 0.

    Input:
    An integer array of length 0 < arr < 1000. The numbers in the array can be any integer positive or negative.

    Output:
    The lowest index N where the side to the left of N is equal to the side to the right of N. If you do not find an
    index that fits these rules, then you will return -1.

    Note:
    If you are given an array with multiple answers, return the lowest correct index.
     */
    static class Fenwick {
        int[] tree;

        public Fenwick(int length) {
            tree = new int[length];
        }

        public int sum(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i = i - (i & -i);
            }
            return sum;
        }

        public int sumRange(int start, int end) {
            return sum(end) - sum(start - 1);
        }

        public void update(int i, int k) {
            while (i < tree.length) {
                tree[i] += k;
                i = i + (i & -i);
            }
        }

        public void constructTree(int[] array) {
            for (int i = 1; i <= array.length; i++) {
                update(i, array[i - 1]);
            }
        }
    }
    //TC:O(n log n)
    public static class Kata {
        //Using a Fenwick Tree we can find prefix for every value in arr
        public static int findEvenIndex(int[] arr) {
            if (arr.length == 0) {
                return -1;
            }
            if (arr.length == 1) {
                return 0;
            }
            //+1 since tree is 1 indexed
            Fenwick tree = new Fenwick(arr.length + 1);
            //construct the tree using the values from the arr
            tree.constructTree(arr);

            for (int i = 0; i < arr.length; i++) {
                int left_sum = tree.sumRange(1, i);
                //i+2 to account for 1 indexed and current value
                int right_sum = tree.sumRange(i + 2, arr.length);
                if (left_sum == right_sum) {
                    return i;
                }
            }
            return -1;
        }

        //TC: O(n)
        public static int findEvenIndexEz(int[] arr) {
            if (arr.length == 0) {
                return 0;
            }
            int sum = 0;
            //sum up all values from the array
            for (int val : arr) {
                sum += val;
            }

            //sum of all values left of ith index
            int leftSum = 0;
            for (int i = 0; i < arr.length; i++) {
                //reduce the total sum by the current value
                sum -= arr[i];

                //if the left sum == sum return index
                if (leftSum == sum) {
                    return i;
                }

                //increase the leftSum by the current value so we have all values left of the next ith value
                leftSum += arr[i];
            }
            return -1;
        }

//        @Test
//        public void test() {
//            assertEquals(3, Kata.findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));
//            assertEquals(1, Kata.findEvenIndex(new int[]{1, 100, 50, -51, 1, 1}));
//            assertEquals(-1, Kata.findEvenIndex(new int[]{1, 2, 3, 4, 5, 6}));
//            assertEquals(3, Kata.findEvenIndex(new int[]{20, 10, 30, 10, 10, 15, 35}));
//            assertEquals(-1, Kata.findEvenIndex(new int[]{-8505, -5130, 1926, -9026}));
//            assertEquals(1, Kata.findEvenIndex(new int[]{2824, 1774, -1490, -9084, -9696, 23094}));
//            assertEquals(6, Kata.findEvenIndex(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
//            assertEquals(0, Kata.findEvenIndex(new int[]{20, 10, -80, 10, 10, 15, 35}));
//        }
    }
}
