package codingbat.string_1;

public class lastTwo {

    /*

Given a string of any length, return a new string where the last 2 chars, if present, are swapped, so "coding" yields "codign".

    codingbat.string_1.lastTwo("coding") → "codign"
    codingbat.string_1.lastTwo("cat") → "cta"
    codingbat.string_1.lastTwo("ab") → "ba"
     */

    public String lastTwo(String str) {
        if(str.length() < 2){
            return str;
        }
        char first = str.charAt(str.length()-2);
        char last = str.charAt(str.length()-1);

        return str.substring(0, str.length()-2) + last + first;
    }
}
