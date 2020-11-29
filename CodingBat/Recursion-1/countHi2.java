public class countHi2 {
    /*
    Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count
    "hi" that have an 'x' immedately before them.

    countHi2("ahixhi") → 1
    countHi2("ahibhi") → 2
    countHi2("xhixhi") → 0
     */
    public int countHi2(String str) {
        if (str.length() <= 1) {
            return 0;
        }

        if (str.length() > 2 && str.startsWith("xhi")) {
            return countHi2(str.substring(3));

        } else if (str.startsWith("hi")) {
            return 1 + countHi2(str.substring(2));
        }
        return countHi2(str.substring(1));
    }
}
