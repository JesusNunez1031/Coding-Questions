public class ValidPalindromeII {

    public static boolean validPalindrome(String s) {
        int a_ptr = 0;
        int b_ptr = s.length() - 1;

        while (a_ptr <= b_ptr) {
            if (s.charAt(a_ptr) != s.charAt(b_ptr)) {
                //Call helper method with a substring of one less character from a and b-1
                return deleteOne(s, a_ptr + 1, b_ptr) || deleteOne(s, a_ptr, b_ptr - 1);
            }
            a_ptr++;
            b_ptr--;
        }
        return true;
    }

    public static boolean deleteOne(String s, int i, int j) {
        int a_ptr = i;
        int b_ptr = j;

        while (a_ptr <= b_ptr) {
            if (s.charAt(a_ptr) != s.charAt(b_ptr)) {
                return false;
            }
            a_ptr++;
            b_ptr--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcceba";

        validPalindrome(str);
    }
}
