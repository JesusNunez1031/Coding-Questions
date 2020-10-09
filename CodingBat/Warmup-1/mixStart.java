public class mixStart {

    /*
    Return true if the given string begins with "mix", except the 'm' can be anything, so "pix", "9ix" .. all count.

    mixStart("mix snacks") → true
    mixStart("pix snacks") → true
    mixStart("piz snacks") → false
     */

    public boolean mixStart(String str) {
        if (str.length() <= 2) {
            return false;
        }
        if (str.startsWith("ix", 1)) {
            return true;
        }
        return false;
    }
}
