package codingbat.string_1;

public class endsLy {

    /*
    Given a string, return true if it ends in "ly".

    codingbat.string_1.endsLy("oddly") → true
    codingbat.string_1.endsLy("y") → false
    codingbat.string_1.endsLy("oddy") → false
     */

    public boolean endsLy(String str) {
        if (str.length() < 2) {
            return false;
        }
        return str.startsWith("ly", str.length() - 2);
    }
}
