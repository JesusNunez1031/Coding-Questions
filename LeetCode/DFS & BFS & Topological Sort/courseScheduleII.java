import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class courseScheduleII {
    /*
    There are a total of n courses you have to take labelled from 0 to n - 1.
    Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course
    bi before the course ai.

    Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses
    you should take to finish all courses.

    If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

    Example 1:
    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: [0,1]
    Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the
    correct course order is [0,1].

    Example 2:
    Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
    Output: [0,2,1,3]
    Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
    Both courses 1 and 2 should be taken after you finished course 0.
    So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

    Example 3:
    Input: numCourses = 1, prerequisites = []
    Output: [0]

    Constraints:
        1 <= numCourses <= 2000
        0 <= prerequisites.length <= numCourses * (numCourses - 1)
        prerequisites[i].length == 2
        0 <= ai, bi < numCourses
        ai != bi
        All the pairs [ai, bi] are distinct.
     */
    //TC/S: O(V + E)
    private int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int j = numCourses - 1;
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        //make a list for every course to hold prerequisites
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

         /*
                if the prerequisite is [0,1], then in order to take take course 0, you need to take 1 first, the first
                value is the course, and the second value is the prereq. so for every pair in the array of prereqs.,
                we add the prerequisites to each course. Increase the indegree of the prerequisite as well so we
                know prerequisite[0] depends on prerequisite[1]
            */
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
            degree[prerequisite[1]]++;
        }

        //add all the courses with a degree of 0 to the queue to be processed
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (queue.size() != 0) {
            int course = queue.poll();
            order[j--] = course;    //add the course to take to the order list
            /*
                visit all the prerequisites in the list of courses for "course" in the graph and reduce their degree by
                1, if the degree is 0, we add it to the queue and increase the number of courses processed
             */
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int) graph[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                    count++;
                }
            }
        }

        //if the number of courses processed is not equal to the numCourses available, there was a cycle somewhere so return the empty array
        if (count == numCourses) {
            return order;
        } else {
            return new int[0];
        }
    }
}
