public class IsUnique {
    /*
        Check if all the characters in a string are unique
        This is done by creating a boolean array the size of all possible ascii character values, every
        time we encounter a new character we set its ascii value to true. The next time we encounter a character
        and the value in the array is already set to true, we return false since the characters are not unique

     */
    public static boolean isUnique(String value) {
        /* Cant have more than 128 ascii characters since
        128 symbols in the character set. These symbols consist of letters (both uppercase and lowercase), numbers, punctuation marks, special characters and control characters.
        Each symbol in the character set can be represented by a Decimal value ranging from 0 to 127, as well as equivalent Hexadecimal and Octal values.
         */
        if (value.length() > 128) {
            return false;
        }
        boolean[] alpha = new boolean[128];

        for (int i = 0; i < value.length(); i++) {
            int ascii = value.charAt(i);
            if (alpha[ascii]) {
                return false;
            }
            alpha[ascii] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(isUnique("hecpaitl"));
    }
}
