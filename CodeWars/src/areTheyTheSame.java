import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

public class areTheyTheSame {
    /*
    Given two arrays a and b write a function comp(a, b) (compSame(a, b) in Clojure) that checks whether the two arrays have
    the "same" elements, with the same multiplicities. "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.

    Examples
    Valid arrays
    a = [121, 144, 19, 161, 19, 144, 19, 11]
    b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]

    comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121, 20736 the square of 144, 361
    the square of 19, 25921 the square of 161, and so on. It gets obvious if we write b's elements in terms of squares:

    a = [121, 144, 19, 161, 19, 144, 19, 11]
    b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]

    Invalid arrays
    If we change the first number to something else, comp may not return true anymore.
    a = [121, 144, 19, 161, 19, 144, 19, 11]
    b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]

    comp(a,b) returns false because in b 132 is not the square of any number of a.
    a = [121, 144, 19, 161, 19, 144, 19, 11]
    b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]
    comp(a,b) returns false because in b 36100 is not the square of any number of a.
     */
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        //Store the squares of a into a map
        for (int i : a) {
            int sqrA = i * i;
            map.put(sqrA, map.getOrDefault(sqrA, 0) + 1);
        }

        //Check if the map contains the value of b and if it occurs the same amount of times as in a
        for (int nums : b) {
            if (map.containsKey(nums) && map.get(nums) > 0) {
                map.put(nums, map.get(nums) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean compEz(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) return false;

        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < a.length; i++) {
            sumA += Math.abs(a[i]);
            sumB += Math.sqrt(b[i]);
        }
        return sumA == sumB;
    }

    @Test
    public void test1() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertTrue(areTheyTheSame.compEz(a, b));
    }

}
