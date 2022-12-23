package leetCode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class isGraphBipartite {
    /*
    There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array
    graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there
    is an undirected edge between node u and node v. The graph has the following properties:
        - There are no self-edges (graph[u] does not contain u).
        - There are no parallel edges (graph[u] does not contain duplicate values).
        - If v is in graph[u], then u is in graph[v] (the graph is undirected).
        - The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.

    A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the
    graph connects a node in set A and a node in set B.

    Return true if and only if it is bipartite.


    Example 1:
    [0] ------- [1]
     |  \        |
     |     \     |
     |        \  |
    [3] ------- [2]
    Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
    Output: false
    Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in
    one and a node in the other.

    Example 2:
    [0] -------- [1]
     |            |
     |            |
     |            |
    [3] -------- [2]
    Input: graph = [[1,3],[0,2],[1,3],[0,2]]
    Output: true
    Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.


    Constraints:
        graph.length == n
        1 <= n <= 100
        0 <= graph[u].length < n
        0 <= graph[u][i] <= n - 1
        graph[u] does not contain u.
        All the values of graph[u] are unique.
        If graph[u] contains v, then graph[v] contains u.
     */
    //TC: O(E + V) and O(V) space used where E are all the edges in the graph and V are the vertices [BFS]
    public boolean isBipartite(int[][] graph) {
        /*
            0 -> not colored
            1 -> blue
           -1 -> red
        */
        int[] color = new int[graph.length]; //array holds the colors of each node in graph

        //for each node in the graph, color it if its not colored, then visit all adjacent nodes and color them the opposite color, this is done using a BFS search of the nodes
        for (int i = 0; i < graph.length; i++) {
            //only color a node if its not colored yet
            if (color[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;

                while (!queue.isEmpty()) {
                    int node = queue.remove(); //take a node from the queue

                    //color all the adjacent nodes of the "node" to the opposite color only if they arent colored
                    for (int n : graph[node]) {
                        //if an adjacent node has the same color as the parent node, graph is not bipartite
                        if (color[n] == color[node]) {
                            return false;
                        } else if (color[n] == 0) {
                            queue.add(n);
                            color[n] = -color[node];
                        }
                    }
                }
            }
        }
        return true;
    }

    //TC: O(V + E) and O(V) space used where E are all the edges in the graph and V are the vertices
    public boolean isBipartiteDFS(int[][] graph) {
         /*
            0 -> not colored
            1 -> blue
           -1 -> red
        */
        int[] colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            /*
                if the node i is not colored and after doing a dfs on its adjacent nodes, there is a conflict of assigned
                colors, return false since the graph is not bipartite
             */
            if (colors[i] == 0 && !validColor(i, 1, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    /*
        Method performs a DFS search of all adjacent nodes to "node" and colors nodes to the opposite color of "color",
        returns true if the all colors are assigned correctly and false if a child node is given the color of the parent
        node
     */
    private boolean validColor(int node, int color, int[] colors, int[][] graph) {
        /*
            if the node is colored, return whether or not its color matches the color being assigned to it, if  false,
            the graph is not bipartite since somewhere in the graph nodes cant connect to each other evenly
         */
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        //color the node to "color"
        colors[node] = color;
        /*
            for every adjacent node to "node", color the node of the opposite color, when a child is assigned the same
            color as the parent, return false
         */
        for (int n : graph[node]) {
            if (!validColor(n, -color, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    int[] parent; //array holds the parent nodes for each node in graph

    //TC: O(E log V) and O(v) space using a union find data structure
    public boolean isBipartiteUnion(int[][] graph) {
        parent = new int[graph.length];

        //self root each node in the graph
        for (int i = 0; i < graph.length; i++) {
            parent[i] = i;
        }

        //for each node in the graph, go through its adjacent nodes and
        for (int i = 0; i < graph.length; i++) {
            int[] nodes = graph[i];

            for (int n : nodes) {
                //if the adjacent node of i has the same parent as node n, graph is not bipartite
                if (find(i) == find(n)) {
                    return false;
                }
                //add the node n to the union set of node[0]
                union(n, nodes[0]);
            }
        }
        return true;
    }

    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        //only add nodes to the union set x of parents of x and y arent the same
        if (parentX != parentY) {
            parent[parentX] = parentY;
        }
    }

    //returns the parent of the given node
    private int find(int node) {
        //if the parent of the node is itself, return node
        if (parent[node] == node) {
            return node;
        }
        //otherwise, recursively find the parent of the node
        parent[node] = find(parent[node]);
        return parent[node];
    }
}
