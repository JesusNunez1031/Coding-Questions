package codingbat.string_1;

public class withoutEnd {

    /*

Given a string, return a version without the first and last char, so "Hello" yields "ell". The string length will be at least 2.

    codingbat.string_1.withoutEnd("Hello") → "ell"
    codingbat.string_1.withoutEnd("java") → "av"
    codingbat.string_1.withoutEnd("coding") → "odin"
     */
    public String withoutEnd(String str) {
        return str.substring(1,str.length()-1);
    }
}
