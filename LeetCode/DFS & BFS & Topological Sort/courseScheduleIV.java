import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseScheduleIV {
    /*
    There are a total of n courses you have to take, labeled from 0 to n-1.

    Some courses may have direct prerequisites, for example, to take course 0 you have first to take course 1, which is
    expressed as a pair: [1,0]

    Given the total number of courses n, a list of direct prerequisite pairs and a list of queries pairs.

    You should answer for each queries[i] whether the course queries[i][0] is a prerequisite of the course queries[i][1] or not.

    Return a list of boolean, the answers to the given queries.

    Please note that if course a is a prerequisite of course b and course b is a prerequisite of course c, then, course
    a is a prerequisite of course c.

    Example 1:
                [1]
                 ↓
                [0]

    Input: n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
    Output: [false,true]
    Explanation: course 0 is not a prerequisite of course 1 but the opposite is true.

    Example 2:
    Input: n = 2, prerequisites = [], queries = [[1,0],[0,1]]
    Output: [false,false]
    Explanation: There are no prerequisites and each course is independent.

    Example 3:
                [1] ⤵
                 ↓   ↓
                [2]→[0]
    Input: n = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
    Output: [true,true]

    Example 4:

    Input: n = 3, prerequisites = [[1,0],[2,0]], queries = [[0,1],[2,0]]
    Output: [false,true]

    Example 5:

    Input: n = 5, prerequisites = [[0,1],[1,2],[2,3],[3,4]], queries = [[0,4],[4,0],[1,3],[3,0]]
    Output: [true,false,true,false]


    Constraints:
        2 <= n <= 100
        0 <= prerequisite.length <= (n * (n - 1) / 2)
        0 <= prerequisite[i][0], prerequisite[i][1] < n
        prerequisite[i][0] != prerequisite[i][1]
        The prerequisites graph has no cycles.
        The prerequisites graph has no repeated edges.
        1 <= queries.length <= 10^4
        queries[i][0] != queries[i][1]
     */

    //TC: O(V + EV) ~ O(EV) using topological sort where V are vertices and E are edges
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        //matrix boolean array used to check if a course is a prerequisite
        boolean[][] isReachable = new boolean[n][n];

        //list of n courses
        List<Integer>[] courses = new List[n];
        int[] degree = new int[n];

        //make a list for each course n that will hold prerequisite courses
        for(int i = 0;i < n;i++) {
            courses[i] = new LinkedList<>();
        }

        for(int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];

            //add the prerequisite to "course" list of prerequisites
            courses[course].add(prerequisite);
            //increase degree of prerequisites
            degree[prerequisite]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        //add all the courses of degree 0 to queue
        for(int i = 0; i < degree.length;i++) {
            if(degree[i] == 0) {
                queue.add(i);
            }
        }

        //perform BFS
        while(!queue.isEmpty()) {
            int course = queue.remove();

            //for every prerequisite course in the list
            for(int prereq : courses[course]) {
                isReachable[prereq][course] = true;

                //for all n courses, look for the other course that are also a prereq to "course"
                for(int i = 0; i < n; i++){
                    /*
                        if the "course" is a prereq to i, then "prereq" is also a prerequisite to i since prereq is a
                        prerequisite to "course"
                    */
                    if(isReachable[course][i]) {
                        isReachable[prereq][i] = true;
                    }
                }
                degree[prereq]--;
                //add the course "prereq" if its degree is 0
                if(degree[prereq] == 0) {
                    queue.add(prereq);
                }
            }
        }

        List<Boolean> isPrereq = new LinkedList<>();
        //for every query, check if query[1] is a prerequisite to query[0]
        for(int[] query : queries) {
            isPrereq.add(isReachable[query[1]][query[0]]);
        }
        return isPrereq;
    }
}
