import java.util.ArrayList;
import java.util.List;

public class letterCasePermutation {
    /*
    Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
    Return a list of all possible strings we could create. You can return the output in any order.

    Example 1:
    Input: S = "a1b2"
    Output: ["a1b2","a1B2","A1b2","A1B2"]

    Example 2:
    Input: S = "3z4"
    Output: ["3z4","3Z4"]

    Example 3:
    Input: S = "12345"
    Output: ["12345"]

    Example 4:
    Input: S = "0"
    Output: ["0"]

    Constraints:
        S will be a string with length between 1 and 12.
        S will consist only of letters or digits.
     */
    /*
        TC/S: O(2^n) is the number of possible permutations where n is the number of characters in the string and
        O((2^n) * n) space is used where n is the number of letters in the string since we store the string n times
     */
    private static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();

        generatePermutations(res, new StringBuilder(), S.toCharArray(), 0);

        return res;
    }

    private static void generatePermutations(List<String> result, StringBuilder sb, char[] s, int index) {
        //when the current generated string sb is of equal length of s, add it to the list
        if (sb.length() == s.length) {
            result.add(sb.toString());
            return;
        }

        //we iterate through the string using "index", every call to the method we move forward by one and process the character at index "index"
        char ch = s[index];

        /*
            Each character in the string not including digits can either be lowercase, or uppercase
            0 - convert to lowercase
            1 - convert to uppercase
        */
        for (int i = 0; i < 2; i++) {
            sb.append(convertLetterCase(ch, i));
            generatePermutations(result, sb, s, index + 1);
            sb.setLength(sb.length() - 1);

            /*
                when backtracking, if the current character is a digit, break out, since digits have no case, allowing the
                case to be changed
             */
            if (!Character.isLetter(ch)) {
                break;
            }
        }
    }

    //flag == 0, turn character to lowercase
    //flag == 1 turn character to uppercase
    private static char convertLetterCase(char c, int flag) {
        if (!Character.isLetter(c)) {
            return c;
        }
        if (flag == 1) {
            return Character.toUpperCase(c);
        } else {
            return Character.toLowerCase(c);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(letterCasePermutation(str).toString());
    }
}
