package leetCode.dfs_bfs_topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseSchedule {
    /*
    There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

    Example 1:
    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take.
                 To take course 1 you should have finished course 0. So it is possible.

    Example 2:
    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take.
                 To take course 1 you should have finished course 0, and to take course 0 you should
                 also have finished course 1. So it is impossible.

    Constraints:
        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
        You may assume that there are no duplicate edges in the input prerequisites.
        1 <= numCourses <= 10^5

        -This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological
         ordering exists and therefore it will be impossible to take all courses.
     */
    private boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;  //count of courses processed

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

        //if the number of courses processed is not equal to the numCourses available, there was a cycle somewhere
        return count == numCourses;
    }

    //TC:O(v*v) and O(v) space
    public boolean canFinishEZ(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courseList = new LinkedList<>();
        int[] degree = new int[numCourses];

        //initialize the list of courses
        for (int i = 0; i < numCourses; i++) {
            courseList.add(new LinkedList<>());
        }

        //add the indegree of each course from the prereq array
        for (int[] prerequisite : prerequisites) {
            /*
                if the prerequisite is [0,1], then in order to take take course 0, you need to take 1 first, the first
                value is the course, and the second value is the prereq. so for every pair in the array of prereqs.,
                we add the prerequisites to each course. From the courseList, we add the prereq. of the course
            */
            courseList.get(prerequisite[1]).add(prerequisite[0]);
            degree[prerequisite[0]]++;  //increase the indegree of the course
        }

        Queue<Integer> courseCanTake = new LinkedList<>();

        //add all the courses with an indegree of 0 to the queue
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                courseCanTake.add(i);
            }
        }

        while (!courseCanTake.isEmpty()) {
            int courseToTake = courseCanTake.remove();
            /*
                search through all prerequisites of the current course to take and reduce their degrees by one, if the
                degree is 0, we add it to the queue
             */
            for (int associatedCourse : courseList.get(courseToTake)) {
                degree[associatedCourse]--;
                if (degree[associatedCourse] == 0) {
                    courseCanTake.add(associatedCourse);
                }
            }
        }

        //check if there's a course that cant be taken
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
