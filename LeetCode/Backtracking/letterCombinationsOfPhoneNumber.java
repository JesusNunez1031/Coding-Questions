import java.util.ArrayList;
import java.util.List;

public class letterCombinationsOfPhoneNumber {
    /*
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

    ------- ------- -------
    |     | | ABC | | DEF |
    |  1  | |  2  | |  3  |
    ------- ------- -------
    ------- ------- -------
    | GHI | | JKL | | MNO |
    |  4  | |  5  | |  6  |
    ------- ------- -------
    ------- ------- -------
    |PQRS | | TUV | | WXYZ|
    |  7  | |  8  | |  9  |
    ------- ------- -------
    ------- ------- -------
    |     | |space| |     |
    |  *  | |  0  | |  #  |
    ------- ------- -------

    Example 1:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    Example 2:
    Input: digits = ""
    Output: []

    Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]

    Constraints:
        0 <= digits.length <= 4
        digits[i] is a digit in the range ['2', '9'].
     */

    private static final char[][] keypad = {
            {},                     //Digit 0
            {},                     //Digit 1
            {'a', 'b', 'c'},        //Digit 2
            {'d', 'e', 'f'},        //Digit 3
            {'g', 'h', 'i'},        //Digit 4
            {'j', 'k', 'l'},        //Digit 5
            {'m', 'n', 'o'},        //Digit 6
            {'p', 'q', 'r', 's'},   //Digit 7
            {'t', 'u', 'v'},        //Digit 8
            {'w', 'x', 'y', 'z'}};  //Digit 9

    //TC & space: O(3^n * 4^m) where n is all the rows with 3 letters and m is all the rows with 4 letters
    private static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        generateCombinations(digits, combinations, new StringBuilder());

        return combinations;
    }

    private static void generateCombinations(String digits, List<String> combinations, StringBuilder sb) {
        /*
            when we call the method, we always hit 0 once we've made one combination
            Ex: given "234"
                - we take the first letter in row "2" and call the method with digits "34" | string = "a"
                - then we take the first letter in row "3" and call the method with digits "4" | string = "ad"
                - then take the first letter in row "4" and call method with digits "" | string = "adg"

                digits is empty so we know a combination has been made, "adg", then backtrack back to "4" and take the
                second letter in row "4" and repeat until all letters in row "2" have been processed
         */
        if (digits.length() == 0) {
            combinations.add(sb.toString());
        } else {
            /*
                every row holds all the letters that can be made given a specific digit, so we extract the first digit from
                digits to get the specific row and then iterate through the list of letters to make the combinations

                Ex: given "23"
                    we take the digit "2" and its first letter, we append all the letters in row "3" to it
                    then we backtrack to the second letter in row "2", append all letters in "3", and repeat
             */
            int row = Integer.parseInt(digits.substring(0, 1));
            char[] letters = keypad[row];
            for (char letter : letters) {
                sb.append(letter);
                //System.out.println(sb.toString());      //see all combinations made
                generateCombinations(digits.substring(1), combinations, sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String digit = "234";
        System.out.println(letterCombinations(digit));
    }
}
