import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizeByCommonFactor {
    /*
    You are given an integer array of unique positive integers nums. Consider the following graph:
        - There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
        - There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
    Return the size of the largest connected component in the graph.

    Example 1:
    [4]----[6]----[15]----[35]
    Input: nums = [4,6,15,35]
    Output: 4

    Example 2:
    [20]---[50]     [9]----[63]
    Input: nums = [20,50,9,63]
    Output: 2

    Example 3:
    Input: nums = [2,3,6,7,4,12,21,39]
    Output: 8

    Constraints:
        1 <= nums.length <= 2 * 10^4
        1 <= nums[i] <= 10^5
        All the values of nums are unique.
     */
    class UnionFind {

        int[] array; // values in the union find ds
        int[] size; // size of each component

        public UnionFind(int len) {
            array = new int[len];
            size = new int[len];

            // link each component in the array to itself
            for (int i = 0; i < len; i++) {
                array[i] = i;
                size[i] = i;
            }
        }

        // finds which component p belongs to, i.e. the root of p
        public int find(int p) {
            // find the root of p
            int root = p;

            // search until the value at the root does not self loop, i.e. find the actual root node
            while (root != array[root]) {
                root = array[root];
            }

            /*
                compress the path leading back to the root so next time we do a lookup on p we directly have a reference
                to the main node.
                we break out once all nodes in a component are connected to the main root and p == root node
             */
            while (p != root) {
                int next = array[p];
                array[p] = root;
                p = next;
            }
            return root;
        }

        public void union(int x, int y) {
            int root1 = find(x);
            int root2 = find(y);

            // check if elements are in the same component
            if (root1 == root2) {
                return;
            }

            // Merge the smaller component/set into the larger
            if (size[root1] < size[root2]) {
                size[root2] += size[root1];
                array[root1] = array[root2];
            } else {
                size[root1] += size[root2];
                array[root2] = array[root1];
            }
        }
    }

    public int largestComponentSize(int[] nums) {
        int max = Integer.MIN_VALUE;

        // find largest value to determine size of union find structure
        for (int num : nums) {
            max = Math.max(max, num);
        }

        UnionFind uf = new UnionFind(max + 1);

        for (int num : nums) {
            /*
                loop through each of the factors of num and if i is a factor of num, add the relation between num and i
                to the union as well as the relation between num divided by its factor. This will create relationships
                for factors of num starting from i up to num
            */
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }

        int largestComponent = 1;
        Map<Integer, Integer> map = new HashMap<>();

        /*
            search for the largest component in the union find getting the parent of each value in nums and storing the
            result in a HashMap
         */
        for (int num : nums) {
            int parent = uf.find(num);
            map.put(parent, map.getOrDefault(parent, 0) + 1);
            largestComponent = Math.max(largestComponent, map.get(parent));
        }
        return largestComponent;
    }
}