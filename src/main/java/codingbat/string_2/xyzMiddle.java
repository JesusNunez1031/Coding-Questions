package codingbat.string_2;

public class xyzMiddle {
    /*
    Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars
    to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.

    codingbat.string_2.xyzMiddle("AAxyzBB") → true
    codingbat.string_2.xyzMiddle("AxyzBB") → true
    codingbat.string_2.xyzMiddle("AxyzBBB") → false
     */
    public boolean xyzMiddle(String str) {
        if (str.length() < 3) {
            return false;
        }

        int start1 = str.length() / 2 - 2;
        int start2 = str.length() / 2 - 1;

        if (str.length() % 2 == 0) {
            return str.startsWith("xyz", start1) ||
                    str.startsWith("xyz", start2);
        }
        return str.startsWith("xyz", start2);
    }
}
