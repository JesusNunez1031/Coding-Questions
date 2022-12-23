package codingbat.array_2;

public class countEvens {
    /*
    Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.

    codingbat.array_2.countEvens([2, 1, 2, 3, 4]) → 3
    codingbat.array_2.countEvens([2, 2, 0]) → 3
    codingbat.array_2.countEvens([1, 3, 5]) → 0
     */
    public int countEvens(int[] nums) {
        int counter = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }
}
