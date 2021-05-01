import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class powerfulIntegers {
    /*
    Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.
    An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.
    You may return the answer in any order. In your answer, each value should occur at most once.

    Example 1:
    Input: x = 2, y = 3, bound = 10
    Output: [2,3,4,5,7,9,10]
    Explanation:
    2 = 20 + 30
    3 = 21 + 30
    4 = 20 + 31
    5 = 21 + 31
    7 = 22 + 31
    9 = 23 + 30
    10 = 20 + 32

    Example 2:
    Input: x = 3, y = 5, bound = 15
    Output: [2,4,6,8,10,14]

    Constraints:
        1 <= x, y <= 100
        0 <= bound <= 10^6
     */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        //lists to hold all the powers of x and y respectively
        List<Integer> x_powers = new ArrayList<>();
        List<Integer> y_powers = new ArrayList<>();

        //variables used to track the next power of x and y
        int x_pow = x, y_pow = y;

        //the power of any value raised to 0 is 1, hence we add 1 to the list of powers
        x_powers.add(1);
        y_powers.add(1);

        //1 has no other unique values other than 1 hence if x or y are 1, we don't bother adding powers
        if (x != 1) {
            //add powers of x to the list of powers if the value is less than the bound
            while (x_pow < bound) {
                x_powers.add(x_pow);
                //get the next power of x
                x_pow *= x;
            }
        }

        if (y != 1) {
            //add powers of y to the list of powers if the value is less than the bound
            while (y_pow < bound) {
                y_powers.add(y_pow);
                //get the next power of y
                y_pow *= y;
            }
        }

        Set<Integer> powerful_ints = new HashSet<>(); //use set to avoid duplicates

        //add values that summed up are <= to the given bound
        for (int i : x_powers) {
            for (int j : y_powers) {
                if ((i + j) <= bound) {
                    powerful_ints.add(i + j);
                }
            }
        }
        return new ArrayList<>(powerful_ints);
    }
}
