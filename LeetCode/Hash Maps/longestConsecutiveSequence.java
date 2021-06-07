import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestConsecutiveSequence {
    /*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

    Follow up: Could you implement the O(n) solution?

    Example 1:
    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    Example 2:
    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9

    Constraints:
        0 <= nums.length <= 10^4
        -10^9 <= nums[i] <= 10^9
     */
    public class UnionFind {
        //number of elements in the union find structure
        int size;

        //array tracks the size of each set
        int[] sz;

        /*
            id[i] points to the parent of i, if id[i] = i then i is a root node, p and q are connected if p[i] == q[i]
            Ex:
                i 0 1 2 3 4 5 6 7 8 9
            id[i] 0 1 9 9 9 6 6 7 8 9   5 and 6 are connected | 2 3 4 9 are connected
         */
        int[] id; //elements

        //Initialize a union find of size "size"
        public UnionFind(int size) {
            this.size = size;

            //initialize the size of arrays to hold "size" components
            id = new int[size];
            sz = new int[size];

            for (int i = 0; i < size; i++) {
                id[i] = i;  //link each component to itself (self root)
                sz[i] = 1;  //size of each component is 1 at start due to no links
            }
        }

        //Find which component/set 'p' belongs to
        public int find(int p) {
            //find the root of the set 'p'
            int root = p;

            //search until the value at root does not self loop
            while (root != id[root]) {
                root = id[root]; //move to next root
            }

            //path compression
            while (p != root) {
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }

        //Unify the sets containing 'p' and 'q', p is the destination and q is the source
        public void unify(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);

            //check if p and q are in the same set
            if (root1 == root2) {
                return;
            }

            //Merge the smaller set into the larger
            if (sz[root1] < sz[root2]) {
                sz[root2] += sz[root1];
                id[root1] = root2;
            } else {
                sz[root1] += sz[root2];
                id[root2] = root1;
            }
        }

        //returns the set with the most values
        public int getMax() {
            int max = Integer.MIN_VALUE;

            for (int set : sz) {
                if (set > max) {
                    max = set;
                }
            }
            return max;
        }

        //method to display components/set root and size
        public void display() {
            for(int component = 0; component < id.length;component++) {
                System.out.printf("Component %d -> root is: %d size: %d\n", component, id[component], sz[component]);
            }
        }
    }

    //TC/S: O(n)
    public int longestConsecutive(int[] nums) {
        //check for valid array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //holds all values in nums, used to check of ith + 1 & ith - 1 values exists
        Set<Integer> set = new HashSet<>();

        //add values to set
        for (int num : nums) {
            set.add(num);
        }

        //shortest longest possible sequence is 1 e.g. [1]
        int longest_seq = 1;

        //iterate through nums, if ith value + 1 exists in the set, we found a consecutive sequence
        for (int num : nums) {
            /*
                to avoid an O(n^2) solution, we avoid extra work by only looking for a sequence when "num" is the start
                of the sequence meaning num - 1 is not in the set avoiding the need to re-check previous sequences
             */
            if (!set.contains(num - 1)) {
                int sequence = 1;
                int next = num + 1;
                //increase the sequence while "num" + 1 is in the set
                while (set.contains(next++)) {
                    sequence++;
                }

                //update longest sequence
                longest_seq = Math.max(longest_seq, sequence);
            }
        }
        return longest_seq;
    }

    //TC: ~O(n) amortized complexity of O(n)
    private int longestConsecutiveUf(int[] nums) {
        //if nums is empty, there are not sequences, if there is only 1 value, thats the only sequence there is
        if (nums.length <= 1) {
            return nums.length;
        }

        //map to store the values in nums and the indexes at which the numbers are at
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //when a duplicate value is encountered, its overridden
            map.put(nums[i], i);
        }

        UnionFind uf = new UnionFind(nums.length);

        /*
            for each number in nums, get the index of the current number, then check if num + 1 and num - 1 exists in
            the map, add the value that exits to a set in the union find structure in the set of "index"
         */
        for (int num : nums) {
            int index = map.get(num);
            int next = map.getOrDefault(num + 1, -1);
            int prev = map.getOrDefault(num - 1, -1);

            if (next != -1) {
                //under the set of index, add "next" to it
                uf.unify(index, next);
            }

            if (prev != -1) {
                //under the set of index, add "prev" to it
                uf.unify(index, prev);
            }
        }
        return uf.getMax();
    }
}
