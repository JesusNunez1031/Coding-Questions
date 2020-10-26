public class endOther {
    /*
    Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower
    case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase
    version of a string.

    endOther("Hiabc", "abc") → true
    endOther("AbC", "HiaBc") → true
    endOther("abc", "abXabc") → true
     */
    public boolean endOther(String a, String b) {
        String newA = a.toLowerCase();
        String newB = b.toLowerCase();
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.substring(i).toLowerCase().equals(newB)) {
                return true;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.substring(i).toLowerCase().equals(newA)) {
                return true;
            }
        }
        return false;
    }
}
