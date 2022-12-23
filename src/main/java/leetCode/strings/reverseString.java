package leetCode.strings;

import java.util.Arrays;

public class reverseString {

    /*
        Write a short recursive Java method that takes a character string s and outputs its
        reverse. For example, the reverse of 'pots&pans' would be 'snap&stop'.
     */

    private static String reverseStr(String s) {
        if (s.length() == 0) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverseStr(s.substring(0, s.length() - 1));
    }

    //if the string to reverse is in a character array
    private static void reverseStringArr(char[] s) {
        if (s == null || s.length <= 1){
            return;
        }
        helper(s, 0, s.length - 1);
    }

    private static void helper(char[] s, int i, int j) {
        if (i > j) {
            return;
        }
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;

        helper(s, i + 1, j - 1);
    }


    private static String reverseStrIter(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    //Two pointer approach
    private static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;

        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

//    public static String s = "pots&pans";
//
//    @Test
//    public void test1(){
//        assertEquals("Wrong!", "snap&stop", leetCode.strings.reverseString.reverseStrIter(s));
//    }

    public static void main(String[] args) {
        String s = "pots&pans";
        char[] str = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseStringArr(str);
        System.out.println(Arrays.toString(str));
    }
}
