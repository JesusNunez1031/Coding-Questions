package leetCode.graphs;

import java.util.*;

public class FindIfPathExistsInGraph {
    /*
    There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges
    in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional
    edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

    You want to determine if there is a valid path that exists from vertex source to vertex destination.

    Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.


    Example 1:
    Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
    Output: true
    Explanation: There are two paths from vertex 0 to vertex 2:
    - 0 → 1 → 2
    - 0 → 2

    Example 2:
    Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
    Output: false
    Explanation: There is no path from vertex 0 to vertex 5.

    Constraints:
        - 1 <= n <= 2 * 105
        - 0 <= edges.length <= 2 * 105
        - edges[i].length == 2
        - 0 <= ui, vi <= n - 1
        - ui != vi
        - 0 <= source, destination <= n - 1
        - There are no duplicate edges.
        - There are no self edges.
     */
    // Solution O(V + E) where v is vertices and e is edges
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        // build graph
        ArrayList<Integer>[] graph = buildGraph(n, edges);

        boolean[] visited = new boolean[n];

        return dfs(graph, visited, source, destination);
    }

    private ArrayList<Integer>[] buildGraph(int n, int[][] edges) {
        // initialize graph
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // create adjacency list
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }

    private boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, int start, int end) {
        if (start == end) {
            return true;
        }
        visited[start] = true;

        for (Integer neighbor : graph[start]) {
            if (!visited[neighbor] && dfs(graph, visited, neighbor, end)) {
                return true;
            }
        }
        return false;
    }

    public boolean validPathBFS(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        ArrayList<Integer>[] graph = buildGraph(n, edges);

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int current = queue.remove();

            // check if path so far leads to destinations
            if (current == destination) {
                return true;
            }

            // mark node as visited
            visited[current] = true;

            // add all other neighbors of current node to queue if not yet visited
            for (Integer neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                }
            }
        }
        // check if last path taken was to destination
        return visited[destination];
    }
}