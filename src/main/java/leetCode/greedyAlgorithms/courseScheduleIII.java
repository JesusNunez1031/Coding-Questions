package leetCode.greedyAlgorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class courseScheduleIII {
    /*
    There are n different online courses numbered from 1 to n. You are given an array courses where
    courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days and
    must be finished before or on lastDayi.

    You will start on the 1st day and you cannot take two or more courses simultaneously.

    Return the maximum number of courses that you can take.

    Example 1:
    Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
    Output: 3
    Explanation:
    There are totally 4 courses, but you can take 3 courses at most:
    First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
    Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day.
    Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
    The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.

    Example 2:
    Input: courses = [[1,2]]
    Output: 1

    Example 3:
    Input: courses = [[3,2],[4,3]]
    Output: 0

    Constraints:
        1 <= courses.length <= 10^4
        1 <= durationi, lastDayi <= 10^4
     */
    //TC: O(n log n) and O(n) space
    public int scheduleCourse(int[][] courses) {
        //sort the courses by their day of completion value, i.e. courses[1], if the values match, sort by duration value
        Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        /*
            PQ holds the max deadline day up to ith course, to add a new course, we need to check if duration + the
            current time to take the already visited courses does not exceed the current courses deadline. We do this in
            a greedy manner, if we cant add a new course, we check if we can remove a larger duration course to fit in
            the current course to give us more space to fit in more courses.
        */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        //holds the duration taking courses up to ith course
        int time = 0;

        for (int[] course : courses) {
            //check if we can consider the current course, i.e. its duration does not exceed the date of completion
            if (course[0] <= course[1]) {
                /*
                    we can take the current course if its duration + the duration of all previously taken courses does
                    not exceed the current courses date of completion
                 */
                if (course[0] + time <= course[1]) {
                    maxHeap.add(course[0]);
                    time += course[0];
                } else {
                    /*
                        if we cant take the current course, that means a previous course has a longer duration hence
                        if this is the case, to take more courses, we remove the current course with the largest duration
                        and replace it with the current course, this gives us more space to fit in more future courses
                    */
                    if (!maxHeap.isEmpty() && maxHeap.peek() > course[0]) {
                        //add to the time the difference in the current course duration - the current largest difference
                        time += course[0] - maxHeap.remove();
                        maxHeap.add(course[0]);
                        //time += course[0];
                    }
                }
            }
        }
        //the heap will contain all the courses we can take given the courses list
        return maxHeap.size();
    }
}
