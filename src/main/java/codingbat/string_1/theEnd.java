package codingbat.string_1;

public class theEnd {
    /*

Given a string, return a string length 1 from its front, unless front is false, in which case return a string length 1 from its back. The string will be non-empty.

    codingbat.string_1.theEnd("Hello", true) → "H"
    codingbat.string_1.theEnd("Hello", false) → "o"
    codingbat.string_1.theEnd("oh", true) → "o"
     */
    public char theEnd(String str, boolean front) {
        if(!front){
            return str.charAt(str.length()-1);
        }
        return str.charAt(0);
    }
}
