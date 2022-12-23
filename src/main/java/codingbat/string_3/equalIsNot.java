package codingbat.string_3;

public class equalIsNot {
    /*
    Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of appearances of "not" anywhere in the string (case sensitive).

    codingbat.string_3.equalIsNot("This is not") → false
    codingbat.string_3.equalIsNot("This is notnot") → true
    codingbat.string_3.equalIsNot("noisxxnotyynotxisi") → true
     */

    public boolean equalIsNot(String str) {
        int isCount = 0;
        int notCount = 0;

        for (int i = 0; i < str.length(); i++) {

            if (i < str.length() - 1 && str.startsWith("is", i)) {
                isCount++;
            }
            if (i < str.length() - 2 && str.startsWith("not", i)) {
                notCount++;
            }
        }
        return isCount == notCount;
    }

}
