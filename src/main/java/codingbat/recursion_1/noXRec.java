package codingbat.recursion_1;

public class noXRec {
    /*
    Given a string, compute recursively a new string where all the 'x' chars have been removed.

    codingbat.functional_1.noX("xaxb") → "ab"
    codingbat.functional_1.noX("abc") → "abc"
    codingbat.functional_1.noX("xx") → ""
     */
    public String noX(String str) {
        if(str.length() == 0) {
            return str;
        }

        if(str.charAt(0) == 'x')
            return noX(str.substring(1));

        return str.charAt(0) + noX(str.substring(1));
    }
}
