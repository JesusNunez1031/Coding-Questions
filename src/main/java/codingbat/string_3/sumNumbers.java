package codingbat.string_3;

public class sumNumbers {

    /*

    Given a string, return the sum of the numbers appearing in the string, ignoring all other characters.
    A number is a series of 1 or more digit chars in a row.
    (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)

    codingbat.string_3.sumNumbers("abc123xyz") → 123
    codingbat.string_3.sumNumbers("aa11b33") → 44
    codingbat.string_3.sumNumbers("7 11") → 18
     */

    public int sumNumbers(String str) {
        int sum = 0;
        //Num variable will hold continuous number values in he string
        String num = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                //If the next value from i is also a digit, append it to num
                if (i < str.length() - 1 && Character.isDigit(str.charAt(i + 1))) {
                    num += str.charAt(i);
                } else {
                    //Otherwise, we add only the current value i to num, add all values in num to sum, and reset num
                    num += str.charAt(i);
                    sum += Integer.parseInt(num);
                    num = "";
                }
            }
        }
        return sum;
    }

}
