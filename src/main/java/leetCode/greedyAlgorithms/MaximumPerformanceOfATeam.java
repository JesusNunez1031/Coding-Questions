package leetCode.greedyAlgorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam {
    /*
    You are given two integers n and k and two integer arrays speed and efficiency both of length n. There are n engineers
    numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.

    Choose at most k different engineers out of the n engineers to form a team with the maximum performance.

    The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.

    Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.



    Example 1:
    Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
    Output: 60
    Explanation:
    We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4) and engineer 5
    (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.

    Example 2:
    Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
    Output: 68
    Explanation:
    This is the same example as the first but k = 3. We can select engineer 1, engineer 2 and engineer 5 to get the
    maximum performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.

    Example 3:
    Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
    Output: 72

    Constraints:
    1 <= <= k <= n <= 10^5
    speed.length == n
    efficiency.length == n
    1 <= speed[i] <= 10^5
    1 <= efficiency[i] <= 10^8
     */
    /*
        TC: O(n * log n) where n is the number of engineers since we sort them and also log k to build heap where k is
        the team size, SC: O(n)
     */
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];

        //add each engineer to the array of engineers with their respective traits
        for (int i = 0; i < n; i++) {
            engineers[i] = new int[]{speed[i], efficiency[i]};
        }

        //sort the engineers by their efficiency
        Arrays.sort(engineers, (a, b) -> (b[1] - a[1]));

        //heap used to organize a team of k engineers by lowest speed at the top and highest at the bottom
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //maxPerf is the performance value of a team and totalSpeed is the speed of all engineers in a team
        long maxPerf = 0, totalSpeed = 0;

        for (int[] engineer : engineers) {
            int curSpeed = engineer[0]; //speed of the current engineer

            //if we've reached the capacity of the team, we remove the slowest engineer from the team
            if (minHeap.size() == k) {
                totalSpeed -= minHeap.remove();
            }

            //add the current engineer to the team by adding it to the heap and adding his speed to the total teams speed
            minHeap.add(curSpeed);
            totalSpeed += curSpeed;

            //update the max performance using the current engineers efficiency
            maxPerf = Math.max(maxPerf, totalSpeed * engineer[1]);
        }
        return (int) (maxPerf % 1000000007);
    }
}
