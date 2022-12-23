package leetCode.graphs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    /*
    Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node
    n - 1 and return them in any order.

    The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed
    edge from node i to node graph[i][j]).

    Example 1:
    [0] --> [1]
     |       |
     v       v
    [2] --> [3]
    Input: graph = [[1,2],[3],[3],[]]
    Output: [[0,1,3],[0,2,3]]
    Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

    Example 2:
    Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
    Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

    Example 3:
    Input: graph = [[1],[]]
    Output: [[0,1]]

    Example 4:
    Input: graph = [[1,2,3],[2],[3],[]]
    Output: [[0,1,2,3],[0,2,3],[0,3]]

    Example 5:
    Input: graph = [[1,3],[2],[3],[]]
    Output: [[0,1,2,3],[0,3]]

    Constraints:
        n == graph.length
        2 <= n <= 15
        0 <= graph[i][j] < n
        graph[i][j] != i (i.e., there will be no self-loops).
        All the elements of graph[i] are unique.
        The input graph is guaranteed to be a DAG.
     */
    //TC/SC: O(n * 2 ^ n) for each node in the graph there are 2 ^ n possible paths, O(n) to search neighbor nodes
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph.length == 0) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        path.add(0); // add the starting node 0 to the path as all paths start from 0

        dfs(graph, 0, path, result); // start from 0th node in graph

        return result;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        // add the current path when we've reached the last node in the graph since the path is complete
        if (node == graph.length - 1) {
            result.add(new ArrayList(path));
            return;
        }

        // traverse each neighbor to the current "node" index and add generate paths using these nodes
        for (int neighbor : graph[node]) {
            path.add(neighbor);
            dfs(graph, neighbor, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }
}
