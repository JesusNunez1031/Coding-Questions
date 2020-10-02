public class ClimbingStairs {

    public int climbStairs(int n) {
        //Array to store previous solutions to sub-problems
        int[] mem = new int[n + 1];
        //The solutions to the first and second sub-problem will allow us to solve the rest of n problems
        mem[0] = 1;
        mem[1] = 1;

        int i = 2;
        while(i <= n) {
            //The number of solution to the next n value is the sum of the previous two solutions
            mem[i] = mem[i - 1] + mem[i -2];
            i++;
        }
        return mem[n];
    }
}
