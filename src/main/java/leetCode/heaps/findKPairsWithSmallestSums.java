package leetCode.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class findKPairsWithSmallestSums {
    /*
    You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
    Define a pair (u,v) which consists of one element from the first array and one element from the second array.
    Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

    Example 1:
    Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
    Output: [[1,2],[1,4],[1,6]]
    Explanation: The first 3 pairs are returned from the sequence:
                 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

    Example 2:
    Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
    Output: [1,1],[1,1]
    Explanation: The first 2 pairs are returned from the sequence:
                 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

    Example 3:
    Input: nums1 = [1,2], nums2 = [3], k = 3
    Output: [1,3],[2,3]
    Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
     */
    //object class to allow for better access to the index pairs from nums1 and nums2 and sum of both values
    static class SumObject {
        List<Integer> indexes;
        int sum;

        public SumObject(List<Integer> list, int sum) {
            this.indexes = list;
            this.sum = sum;
        }

        public int getSum() {
            return this.sum;
        }
    }

    //TC:O(n * m) where n is size of nums1 and m is the size of nums2, slow method but easy to understand
    public List<List<Integer>> kSmallestPairsS(int[] nums1, int[] nums2, int k) {
        PriorityQueue<SumObject> minHeap = new PriorityQueue<>((a, b) -> a.getSum() - b.getSum());
        List<List<Integer>> pairs = new ArrayList<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                SumObject pair = new SumObject(Arrays.asList(num1, num2), num1 + num2);
                minHeap.add(pair);
            }
        }
        while (!minHeap.isEmpty() && k-- > 0) {
            pairs.add(minHeap.remove().indexes);
        }
        return pairs;
    }

    /******************************************************************************************************************/

    //TC: since its take n log n time to make a heap, the time complexity here is O((n + m) log (n + m))
    private List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        int n1 = nums1.length, n2 = nums2.length;

        // No pairing possible when n1/n2/k == 0
        if (n1 == 0 || n2 == 0 || k == 0) {
            return pairs;
        }

        //we want to order the heap in a way where the smallest sums are at the very top, hence we sort heap by smallest sums
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[3]) - (b[3]));

        /*
            add all the values in nums1 with the first value in nums2 to the queue so as to make sure we add all the
            smallest pairs first, we only iterate to the smallest value k or the length of n1, if k is < than n1, we don't
            want to add unnecessary arrays to the queue since they would be ignored, hence ignoring extra work
         */
        for (int i = 0; i < Math.min(n1, k); i++) {
            /*
                we add the value of nums1, nums2, and the index used in nums2, this will help iterate through nums2 later
                we also make the third index the sum of num1 + nums2 so the heap inserts it in the proper place
            */
            minHeap.add(new int[]{nums1[i], nums2[0], 0, nums1[i] + nums2[0]});
        }

        /*
            we now go through each of the lists in the heap and add the smallest pairs while k > 0. for every new list
            taken from the heap, we also add one iff the index from nums2 can be incremented by 1 so as to make a new pair
            using a new value from nums2
         */
        while (!minHeap.isEmpty() && k-- > 0) {
            int[] list = minHeap.remove();  //remove the top array from the heap, i.e. the current smallest sum pair

            pairs.add(Arrays.asList(list[0], list[1])); //add the pair indexes to the resulting array

            //nums2_index is the index of nums2 used in the current list
            int nums2_index = list[2];

            /*
                we check if the nums2_index + 1 is still the in range of the length of nums2, if so we add the current
                value in the nums1 which is list[0], and the new nums2_index + 1 value from nums2 with the new index used
                as nums2_index + 1. This makes a new pair using a new index from nums2
            */
            if (nums2_index + 1 < n2) {
                minHeap.add(new int[]{list[0], nums2[nums2_index + 1], nums2_index + 1, list[0] + nums2[nums2_index + 1]});
            }
        }
        return pairs;
    }
}
