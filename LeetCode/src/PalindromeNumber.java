public class PalindromeNumber {
    // Given a number, return true if the number is a palindrome

    //Method using Strings
    public static boolean isPalindromeStrings(int x) {
        String num = Integer.toString(x);

        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) != num.charAt((num.length() - 1) - i)) {
                return false;
            }
        }
        return true;
    }

    //Method using actual numbers by reversing the number and comparing to the original value
    public static boolean isPalindromeInts(int x) {
        if (x < 0) {
            return false;
        }

        int rev = 0;
        int temp = x;

        while (temp != 0) {
            rev = (rev * 10) + (temp % 10);
            temp /= 10;
        }
        return rev == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeInts(121));
    }
}
