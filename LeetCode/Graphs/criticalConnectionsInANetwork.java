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
     */
    List<List<Integer>> critical_connections;
    int time = 0; //simulates a timer while traversing the graph

    //TC/S: O(n) using a modified version of Tarjan's Strongly Connected Components algorithm
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //create an adjacency list for all the nodes in the graph
        ArrayList[] adj_list = new ArrayList[n];

        //initialize an empty list of neighbors for each nth node
        for (int i = 0; i < n; i++) {
            adj_list[i] = new ArrayList<>();
        }

        /*
            each edge has two nodes, the root node and the node that connects to it, for each node add all nodes connected
            to it to its respective adjacency list
        */
        for (List<Integer> edge : connections) {
            int a = edge.get(0);
            int b = edge.get(1);

            adj_list[a].add(b);
            adj_list[b].add(a);
        }

        //array used to check if we've visited a node
        boolean[] visited = new boolean[n];

        /*
            array keeps track of the time_stamp, i.e. low-link values for each node in the the graph of servers. The
            low-link value of a node is the smallest(lowest) node reachable from that node
        */
        int[] time_stamp = new int[n];
        critical_connections = new ArrayList<>();

        //begin dfs search through graph from node 0 and a previous node of -1, invalid node
        dfs(adj_list, visited, time_stamp, 0, -1);

        return critical_connections;
    }

    private void dfs(List<Integer>[] adj_list, boolean[] visited, int[] time_stamp, int curr_node, int prev) {
        //mark the current curr_node node as visited, set its time and save its time to be used to check if we are at a critical connection
        visited[curr_node] = true;
        time_stamp[curr_node] = time++;
        int currentTimeStamp = time_stamp[curr_node];

        //visit all nodes v connected to curr_node node
        for (int v : adj_list[curr_node]) {
            //if parent vertex, ignore
            if (v == prev) {
                continue;
            }

            //dfs search through unvisited nodes
            if (!visited[v]) {
                dfs(adj_list, visited, time_stamp, v, curr_node);
            }

            /*
                set the time_stamp of curr_node node to the smallest value between curr_node and v, this is so if we have
                nodes in a connection that allow access to "curr_node" faster, we want to reflect that
                Ex:
                      [0]
                    /     \
                   [1] -- [2]
                time at 0 is 1, time at 2 is 2, time at 1 is 3, however, all times change to 1 since we can directly go
                from 0 to 1 and 2 in 1 time, rather than get to 1 by going through 2 and 2 through 1
            */
            time_stamp[curr_node] = Math.min(time_stamp[curr_node], time_stamp[v]);

            /*
                if the current node has a time_stamp less than v's time_stamp, that means the node has no other
                connections hence making it a critical connection
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
            if (currentTimeStamp < time_stamp[v]) {
                critical_connections.add(Arrays.asList(curr_node, v));
            }
        }
    }
}
