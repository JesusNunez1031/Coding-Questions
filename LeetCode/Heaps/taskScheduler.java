import java.util.*;

public class taskScheduler {
    /*
    Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different
    task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could
    complete either one task or just be idle.

    However, there is a non-negative integer n that represents the cool-down period between two same tasks (the same
    letter in the array), that is that there must be at least n units of time between any two same tasks.

    Return the least number of units of times that the CPU will take to finish all the given tasks.

    Example 1:
    Input: tasks = ["A","A","A","B","B","B"], n = 2
    Output: 8
    Explanation:
    A -> B -> idle -> A -> B -> idle -> A -> B
    There is at least 2 units of time between any two same tasks.

    Example 2:
    Input: tasks = ["A","A","A","B","B","B"], n = 0
    Output: 6
    Explanation: On this case any permutation of size 6 would work since n = 0.
    ["A","A","A","B","B","B"]
    ["A","B","A","B","A","B"]
    ["B","B","B","A","A","A"]
    ...
    And so on.

    Example 3:
    Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
    Output: 16
    Explanation:
    One possible solution is
    A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A

    Constraints:
        1 <= task.length <= 104
        tasks[i] is upper-case English letter.
        The integer n is in the range [0, 100].
     */
    //TC: O(n log n) -> time to make the heap
    public int leastInterval(char[] tasks, int n) {
        //if there is no cool down between tasks, all tasks can be processed
        if (n == 0) {
            return tasks.length;
        }

        //add all the tasks to a hashmap with the number of times it has to be executed which is the frequency of the character in tasks
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        /*
            we want to process the tasks with most frequency first so we add them all to a priority queue sorted
            by the task value making it a maxheap
        */
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(map.values());  //add all the tasks to the heap

        int time = 0;   //the least number of time that it takes the cpu to finish all tasks

        /*
            process n tasks at a time by adding them to a list to simulate processing. After, we loop through
            the processed tasks and reduce the counter so if a task is completed its counter will be 0 hence
            we don't add it back to the heap
        */
        while (!heap.isEmpty()) {
            List<Integer> process = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                if (!heap.isEmpty()) {
                    process.add(heap.remove());
                }
            }

            //check for tasks that still need to be completed
            for (int task : process) {
                //of the current task - 1 is not 0, its still has to be processed so we add it back to the heap
                if (--task > 0) {
                    heap.add(task);
                }
            }
            //if the heap is empty, we add the number of tasks we processed, otherwise, that means we had to be idle for n + 1 time
            time += heap.isEmpty() ? process.size() : n + 1;
        }
        return time;
    }
}
