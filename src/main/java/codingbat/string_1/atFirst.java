package codingbat.string_1;

public class atFirst {

    /*
    Given a string, return a string length 2 made of its first 2 chars. If the string length is less than 2, use '@' for the missing chars.

    codingbat.string_1.atFirst("hello") → "he"
    codingbat.string_1.atFirst("hi") → "hi"
    codingbat.string_1.atFirst("h") → "h@"
     */
    public String atFirst(String str) {
        if(str.length() < 2){
            return str.length() == 1 ? (str + '@') : "@@";
        }
        return str.substring(0,2);
    }
}
