public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        StringBuilder cleanStr = new StringBuilder();

        //Loop through the sting once and only add characters that are either numbers or characters
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c) || Character.isLetter(c)) {
                cleanStr.append(c);
            }
        }

        //Change all the characters in the string two lowercase
        String finalStr = cleanStr.toString().toLowerCase();
        //a ptr starts from the front and the second ptr is starts from the end
        int a_pointer = 0;
        int b_pointer = finalStr.length()-1;

        while(a_pointer <= b_pointer) {
            if(finalStr.charAt(a_pointer) != finalStr.charAt(b_pointer)) {
                return false;
            }
            a_pointer += 1;
            b_pointer += 1;
        }
        return true;
    }
}
