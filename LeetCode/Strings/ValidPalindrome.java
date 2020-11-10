public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        StringBuilder cleanStr = new StringBuilder();

        //Loop through the sting once and only add characters that are either numbers or characters
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                cleanStr.append(c);
            }
        }

        //Change all the characters in the string two lowercase
        String finalStr = cleanStr.toString().toLowerCase();
        //a ptr starts from the front and the second ptr is starts from the end
        int a_pointer = 0;
        int b_pointer = finalStr.length() - 1;

        while (a_pointer <= b_pointer) {
            if (finalStr.charAt(a_pointer) != finalStr.charAt(b_pointer)) {
                return false;
            }
            a_pointer += 1;
            b_pointer += 1;
        }
        return true;
    }

    public static boolean isPalindromeEz(String s) {
        if (s.equals("")) {
            return true;
        }

        //turn the string to lowercase, remove all special characters and all spaces
        //s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]+|\\s", "");  //one liner but not very efficient
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }

        s = sb.toString().toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
