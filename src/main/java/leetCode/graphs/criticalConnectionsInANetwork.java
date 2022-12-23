package leetCode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class criticalConnectionsInANetwork {
    /*
    There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network
    where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server
    directly or indirectly through the network.

    A critical connection is a connection that, if removed, will make some server unable to reach some other server.

    Return all critical connections in the network in any order.

    Example 1:
                      [0]
                    /     \
                   [1] -- [2]
                    |
                   [3]
    Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
    Output: [[1,3]]
    Explanation: Connection to 3 can only be reached through 1, cutting off 1 would render server 3 useless hence the
    connection between 1 and 3 is critical. [[3,1]] is also accepted.

    Constraints:
        1 <= n <= 10^5
        n-1 <= connections.length <= 10^5
        connections[i][0] != connections[i][1]
        There are no repeated connections.

        TC/S: O(n) using a modified version of Tarjan's Strongly Connected Components algorithm, if we remove an edge
        and a new SCC is made, that edge is a critical connection.
     */
    List<List<Integer>> critical_connections;
    int time = 0; //simulates a timer while traversing the graph so each node gets a discovery time

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //create and initialize an adjacency list for all n nodes
        List<Integer>[] graph = createGraph(n);

        /*
            each edge has two nodes, the root node and the node that connects to it, for each node add all nodes connected
            to it to its respective adjacency list
        */
        //add the connections to the graph
        for (List<Integer> connection : connections) {
            //graph is undirected so given point u and v, we need a connection from [u to v] and [v to u]
            addEdge(graph, connection.get(0), connection.get(1));
            addEdge(graph, connection.get(1), connection.get(0));
        }

        //array used to check if we've visited a node
        boolean[] visited = new boolean[n];

        //array holds the discovery time of each nth node in graph
        int[] disc_time = new int[n];
        Arrays.fill(disc_time, -1); //mark all nodes as undiscovered
        /*
            array keeps track of the time_stamp, i.e. low-link values for each node in the the graph of servers. The
            low-link value of a node is the smallest(lowest) node reachable from that node
        */
        int[] time_stamp = new int[n];
        critical_connections = new ArrayList<>();

        //begin dfs search through graph from node 0 and a previous node of -1, invalid node
        dfs(graph, disc_time, visited, time_stamp, 0, -1);

        return critical_connections;
    }

    //Creates and initializes an adjacency list of n nodes
    private List<Integer>[] createGraph(int n) {
        ArrayList[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }

    //adds an edge to the graph taking source node "from" and destination node "to"
    private void addEdge(List<Integer>[] graph, int from, int to) {
        graph[from].add(to);
    }

    private void dfs(List<Integer>[] graph, int[] disc_time, boolean[] visited, int[] time_stamp, int at, int prev) {
        /*
            mark node we are at as visited, and set its discovery time and low-link value to the current time
         */
        visited[at] = true;
        disc_time[at] = time_stamp[at] = time++;

        //visit all nodes v connected to node we are "at"
        for (int v : graph[at]) {
            //if parent vertex, ignore
            if (v == prev) {
                continue;
            }

            //dfs search from v node if unvisited
            if (!visited[v]) {
                dfs(graph, disc_time, visited, time_stamp, v, at);
            }

            /*
                set the time_stamp or low-link of "at" node to the smallest value between at and v, this is so if we have
                nodes in a connection that allow access to "at" faster, we want to reflect that
                Ex:
                                  [0]
                                /     \
                               [1] -- [2]
                time at 0 is 1, time at 2 is 2, time at 1 is 3, however, all times change to 1 since we can directly go
                from 0 to 1 and 2 in 1 time, rather than get to 1 by going through 2 and 2 through 1
            */
            time_stamp[at] = Math.min(time_stamp[at], time_stamp[v]);

            /*
                when going back through the recursive stack, if we get to a point where the discovery time of the node we
                are at is less than a neighbor, this indicates that the neighbor node v cant be reached without first going
                through "at" node hence this is a critical connection
                Ex:
                                  [0]
                                /     \
                               [1] -- [2]
                                |
                               [3]

                as shown previous, the times of all nodes are 1, however when we visit 3, its time is set to 4, so when
                compared to its neighbor 1, 1 < 4 means that there is no connection to 3 other than 1 in the current
                graph of servers, hence we need 1 to get to 3 making [1, 3] or [3, 1] a critical connection
             */
            if (disc_time[at] < time_stamp[v]) {
                critical_connections.add(Arrays.asList(at, v));
            }
        }
    }
}
