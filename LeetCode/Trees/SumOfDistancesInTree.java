import java.util.*;

public class SumOfDistancesInTree {
    /*
    There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

    You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between
    nodes ai and bi in the tree.

    Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and
    all other nodes.

    Example 1:
    Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
    Output: [8,12,6,10,10,10]
    Explanation: The tree is shown above.
    We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
    equals 1 + 1 + 2 + 2 + 2 = 8.
    Hence, answer[0] = 8, and so on.

    Example 2:
    Input: n = 1, edges = []
    Output: [0]

    Example 3:
    Input: n = 2, edges = [[1,0]]
    Output: [1,1]

    Constraints:
        1 <= n <= 3 * 10^4
        edges.length == n - 1
        edges[i].length == 2
        0 <= ai, bi < n
        ai != bi
        The given input represents a valid tree.
     */
    //TC: O(n)
    private static int[] distances; // array holding the distance of ith node to all other nodes
    private static int[] count;    // holds the number of nodes below the current ith node including the current ith node
    private static List<Set<Integer>> tree; // adjacency list

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<>();
        distances = new int[n];
        count = new int[n];

        // initialize tree
        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<Integer>());
        }

        // populate the tree with the edges to create adjacency list
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // populate the count array to record the number of nodes under each ith node subtree
        postOrder(0, -1); // -1 is the starting "parent" node
        // After postOrder, the root, 0, is the only node with the correct distance

        preOrder(0, -1);

        return distances;
    }

    private static void postOrder(int root, int parent) {
        // iterate through each connected edge in root
        for (int child : tree.get(root)) {
            // avoid a cycle
            if (child != parent) {
                postOrder(child, root);
                count[root] += count[child]; // increase the number of nodes of the root by the number of nodes under the child
                /*
                    update the distance of the root node to all other subtree nodes by taking the distance value of the
                    child node + the number of nodes under that same child node. The depth between the root node and all
                    its child nodes is another way to look at this update
                 */
                distances[root] += distances[child] + count[child];
            }
        }
        // increase the number of nodes of the root
        count[root]++;
    }

    private static void preOrder(int root, int parent) {
        for (int i : tree.get(root)) {
            if (i != parent) {
                /*
                c = the number of nodes in the subtree | d = the summed distance between the node to all other nodes
                             [0] c = 6 | d = 8
                            /   \
            c = 1 | d = 1 [1]    [2] c = 4 | d = 3
                                / | \
                             [3] [4] [5] ==> c = 1 | d = 0
                                          count of ith subtree nodes     count of nodes not in subtree of i
                 distance[1] = distance[0](8) - count[i](1) + (count.length(6) - count[i](1))
                 distance[1] = 8 - 1 + (5) = 12

                 to get the distance of the current node, we calculate the distance from the root node to the current
                 node and add that value to the number of remaining nodes in the tree not including the current node and
                 its subtree
                 */
                distances[i] = distances[root] - count[i] + count.length - count[i];
                preOrder(i, root);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};

        sumOfDistancesInTree(n, edges);
    }
}
