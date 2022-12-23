package codingbat.string_1;

public class withoutX2 {
    /*

Given a string, if one or both of the first 2 chars is 'x', return the string without those 'x' chars, and otherwise
return the string unchanged. This is a little harder than it looks.

    codingbat.string_1.withoutX2("xHi") → "Hi"
    codingbat.string_1.withoutX2("Hxi") → "Hi"
    codingbat.string_1.withoutX2("Hi") → "Hi"
     */

    public String withoutX2(String str) {
        if(str.isEmpty() || (str.length() < 2 && str.charAt(0) == 'x')){
            return "";
        }
        if(str.length() >= 1 && (str.charAt(0) == 'x' && str.charAt(1) == 'x')){
            return str.substring(2);
        }
        if(str.length() >= 2 && (str.charAt(0) == 'x')){
            return str.substring(1);
        }
        if(str.length() >= 2 && (str.charAt(1) == 'x')){
            return str.charAt(0) + str.substring(2);
        }
        return str;
    }
}
