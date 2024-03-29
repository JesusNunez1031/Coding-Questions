package codingbat.logic_2;

public class evenlySpaced {
    /*
    Given three ints, a b c, one of them is small, one is medium and one is large. Return true if the three values are evenly
    spaced, so the difference between small and medium is the same as the difference between medium and large.

    codingbat.logic_2.evenlySpaced(2, 4, 6) → true
    codingbat.logic_2.evenlySpaced(4, 6, 2) → true
    codingbat.logic_2.evenlySpaced(4, 6, 3) → false
     */
    public boolean evenlySpaced(int a, int b, int c) {
        if (a == b && b == c) return true;
        if (a == b || a == c || b == c) return false;
        return ((Math.abs(a - b) == Math.abs(b - c)) || (Math.abs(a - c) == Math.abs(a - b)) || (Math.abs(c - a) == Math.abs(b - c)));
    }
}
