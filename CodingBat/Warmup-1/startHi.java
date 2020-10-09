public class startHi {
    /*
    Given a string, return true if the string starts with "hi" and false otherwise.

    startHi("hi there") → true
    startHi("hi") → true
    startHi("hello hi") → false
     */

    public boolean startHi(String str) {
        if (str.length() <= 1) {
            return false;
        }
        return (str.startsWith("hi"));

    }

}
