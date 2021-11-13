import java.util.Stack;

public class DailyTemperatures {
    /*
    Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
    is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for
    which this is possible, keep answer[i] == 0 instead.

    Example 1:
    Input: temperatures = [73,74,75,71,69,72,76,73]
    Output: [1,1,4,2,1,1,0,0]

    Example 2:
    Input: temperatures = [30,40,50,60]
    Output: [1,1,1,0]

    Example 3:
    Input: temperatures = [30,60,90]
    Output: [1,1,0]

    Constraints:
        1 <= temperatures.length <= 10^5
        30 <= temperatures[i] <= 100
     */
    //TC/SC: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            /*
                While the stack has values and the current temperature is higher than the top value in the stack, the
                number of days we had to wait for a higher temperature is calculated by subtracting the day the temperature
                was first seen, i.e. index from the current day, i.e. index i.
             */
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }

            //add the index of the current day
            stack.push(i);
        }
        return result;
    }

    //optimized space
    public int[] dailyTemperaturesOS(int[] temperatures) {
        int[] output = new int[temperatures.length];
        int hottest = temperatures[temperatures.length - 1];

        /*
            start from the end of the temperatures array and at every step, if we find a temperature higher than the
            current hottest, save it and move on to the next temperature.

            Otherwise, we start with a value days set to 1 because the next warmer day must be at least one day in the future
            and search for the number of days it took to see a temperature higher than the current temperature by using
            previously seen temperatures and using their number of days only if their temperature is less than the current
            temperature.
         */
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (hottest <= temperatures[i]) {
                hottest = temperatures[i];
                continue;
            }
            int days = 1;

            // iterate through answers to find when the next hottest day was found
            while (temperatures[i] >= temperatures[i + days]) {
                days += output[i + days];

            }
            output[i] = days;
        }
        return output;
    }
}
