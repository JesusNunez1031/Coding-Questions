package codingbat.recursion_1;

public class changePi {
    /*
    Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".

    codingbat.recursion_1.changePi("xpix") → "x3.14x"
    codingbat.recursion_1.changePi("pipi") → "3.143.14"
    codingbat.recursion_1.changePi("pip") → "3.14p"
     */
    public String changePi(String str) {
        if (str.length() <= 1)
            return str;

        if (str.startsWith("pi"))
            return "3.14" + changePi(str.substring(2));

        return str.charAt(0) + changePi(str.substring(1));
    }
}
