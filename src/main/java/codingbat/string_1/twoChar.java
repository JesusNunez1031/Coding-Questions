package codingbat.string_1;

public class twoChar {

    /*

Given a string and an index, return a string length 2 starting at the given index. If the index is too big or too small to define a string length 2, use the first 2 chars. The string length will be at least 2.

    codingbat.string_1.twoChar("java", 0) → "ja"
    codingbat.string_1.twoChar("java", 2) → "va"
    codingbat.string_1.twoChar("java", 3) → "ja"
     */

    public String twoChar(String str, int index) {
        if(index >= str.length()-1 || index <= 0){
            return str.substring(0, 2);
        }
        return str.substring(index, index+2);
    }
}
