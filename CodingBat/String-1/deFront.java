public class deFront {
    /*
    Given a string, return a version without the first 2 chars. Except keep the first char if it is 'a' and keep the second char if it is 'b'. The string may be any length. Harder than it looks.

    deFront("Hello") → "llo"
    deFront("java") → "va"
    deFront("away") → "aay"
     */
    public String deFront(String str) {
        if (str.charAt(0) == 'a' && str.charAt(1) == 'b') {
            return "ab" + str.substring(2);
        }
        if (str.charAt(0) == 'a') {
            return "a" + str.substring(2);
        }
        if (str.charAt(1) == 'b') {
            return "b" + str.substring(2);
        }
        return str.substring(2);
    }
}
