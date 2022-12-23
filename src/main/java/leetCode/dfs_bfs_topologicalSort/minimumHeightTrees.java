package leetCode.dfs_bfs_topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class minimumHeightTrees {
    /*
    A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words,
    any connected graph without simple cycles is a tree.

    Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates
    that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree
    as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees,
    those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
    Return a list of all MHTs' root labels. You can return the answer in any order.

    The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

    Example 1:
    Input: n = 4, edges = [[1,0],[1,2],[1,3]]
    Output: [1]
    Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.

    Example 2:
    Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
    Output: [3,4]

    Example 3:
    Input: n = 1, edges = []
    Output: [0]

    Example 4:
    Input: n = 2, edges = [[0,1]]
    Output: [0,1]

    Constraints:
        1 <= n <= 2 * 104
        edges.length == n - 1
        0 <= ai, bi < n
        ai != bi
        All the pairs (ai, bi) are distinct.
        The given input is guaranteed to be a tree and there will be no repeated edges.
     */
    //TC:O(|V|) where v is the number of nodes in the graph
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> nodes = new ArrayList<>();    //list to hold MHT roots

        //return 0 if there are no nodes
        if (n <= 0) {
            return nodes;
        }

        //return 0 if there is only one node
        if (n == 1) {
            nodes.add(0);
            return nodes;
        }

        //array to hold the degree of each node [how children it has]
        int[] degree = new int[n];

        //List of all the nodes connected to specific node in range of 0 - n
        List<List<Integer>> adj = new ArrayList<>();

        //add n lists to adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        //iterate through the edges and add the degree of each node
        for (int[] e : edges) {
            degree[e[0]]++;     //inc the degree of the first node
            degree[e[1]]++;     //inc the degree of the second node
            adj.get(e[0]).add(e[1]);    //add the node that is connected to the node in degree[0] to the list of its connected nodes
            adj.get(e[1]).add(e[0]);     //add the node that is connected to the node in degree[1] to the list of its connected nodes
        }

        //Queue to preform a BFS on the tree
        Queue<Integer> q = new LinkedList<>();

        //all the nodes with the degree of one are added to the queue because we don't care for them since they are leaf nodes
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }

        //there can be at most 2 MHT nodes
        while (n > 2) {
            int size = q.size();
            n -= size;

            while (size-- > 0) {
                int value = q.remove();
                //iterate through all the adjacent nodes to value and reduce its degree by one
                //i is the node we want to decrease the degree of
                for (int i : adj.get(value)) {
                    degree[i]--;
                    //if the degree is one we add it to the queue
                    if (degree[i] == 1) {
                        q.add(i);
                    }
                }
            }
        }
        //after BFS, the queue will hold all the roots with degree of 1 so add them to the nodes list
        nodes.addAll(q);
        return nodes;
    }

    private List<Integer> findMinHeightTreesEz(int n, int[][] edges) {
        List<Integer> nodes = new ArrayList<>();
        if(n <= 0) {
            return nodes;
        }

        //if there is only one node
        if(n == 1) {
            nodes.add(0);
            return nodes;
        }
        ArrayList[] graph = new ArrayList[n];
        int[] degree = new int[n];

        //initialize the graph to hold n nodes
        for(int i = 0;i < n;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edges) {
            degree[e[0]]++;
            degree[e[1]]++;
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        //add all the nodes with degree of 1 to the queue
        for(int i = 0; i < degree.length;i++) {
            if(degree[i] == 1) {
                queue.add(i);
            }
        }

        while(n > 2) {
            int size = queue.size();
            n -= size;

            while(size-- > 0) {
                int value = queue.remove();
                for(int i = 0; i < graph[value].size();i++) {
                    int ptr = (int) graph[value].get(i);
                    degree[ptr]--;
                    if(degree[ptr] == 1) {
                        queue.add(ptr);
                    }
                }
            }
        }
        nodes.addAll(queue);

        return nodes;
    }

    public static void main(String[] args) {
//        int nodes = 4;
//        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};

        int nodes = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};

        System.out.println(findMinHeightTrees(nodes, edges).toString());
    }
}
