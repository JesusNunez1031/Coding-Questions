public class RedundantConnection {
    /*
    In this problem, a tree is an undirected graph that is connected and has no cycles.

    You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The
    added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is
    represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai
    and bi in the graph.

    Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers,
    return the answer that occurs last in the input.

    Example 1:
    [1]--[2]
     |   /
     |  /
     [3]
    Input: edges = [[1,2],[1,3],[2,3]]
    Output: [2,3]

    Example 2:
    [2]--[3]--[5]
     |    |
    [1]--[4]
    Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
    Output: [1,4]

    Constraints:
        1. n == edges.length
        2. 3 <= n <= 1000
        3. edges[i].length == 2
        4. 1 <= ai < bi <= edges.length
        5. ai != bi
        6. There are no repeated edges.
        7. The given graph is connected.
     */

    // array of all n nodes that can be found in graph
    int[] nodes;

    //TC/S: O(n)
    public int[] findRedundantConnection(int[][] edges) {
        nodes = new int[edges.length + 1]; // n == edges.length
        /*
            to use union-find, self root each node, as new connections are found, the root of the connected nodes will
            be combined under one node, e.g. if [1,2] [2,3], the root of 2 and 3 will be 1
        */
        for (int i = 0; i <= edges.length; i++) {
            nodes[i] = i;
        }

        /*
            loop through all the edges in the graph, get the roots of the two nodes connected, if their roots match that
            means a cycle was found, i.e. the nodes connect through other nodes, so the cyclic edge is returned since there
            is only one cycle edge, otherwise merge the two nodes under one root, "from"
        */
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if (find(from) == find(to)) {
                return edge;
            } else {
                union(from, to);
            }
        }
        //no cycles detected
        return new int[]{-1, -1};
    }

    //returns the root of the given node p
    private int find(int p) {
        /*
            p is the node which we want to find the root for, so while the root of p != p, i.e. not self rooted, get the
            to the root of p by searching through all connected nodes
                e.g. if [0, 1] [1,2] and [2,3] edges have been seen so far then the array of
                nodes = [0, 1, 2, 3] and roots = [0, 0, 1, 1]

                to get the root the root of 3, we check of 3 == 1, since 3 is not self rooted, we move to its root 1,
                1 != 0, so we move to its root 0, 0 == 0 so the root has been found
         */
        while (nodes[p] != p) {
            p = nodes[p];
        }
        return p;
    }

    //unites p and q if they don't already belong in the same union set
    private void union(int p, int q) {
        //get the roots of both nodes p and q
        int rootP = find(p);
        int rootQ = find(q);

        //if the nodes are not part of the same tree, set the root of the subtree to the root Q
        if (rootP != rootQ) {
            nodes[rootP] = rootQ;
        }
    }
}
