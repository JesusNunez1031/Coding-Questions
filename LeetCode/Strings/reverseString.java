import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class reverseString {

    /*
        Write a short recursive Java method that takes a character string s and outputs its
        reverse. For example, the reverse of 'pots&pans' would be 'snap&stop'.
     */

    public static String reverseStr(String s){
        if(s.length() == 0){
            return s;
        }
        return s.charAt(s.length()-1) + reverseStr(s.substring(0, s.length()-1));
    }

    public static String reverseStrIter(String s){
        if(s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = s.length()-1;i >= 0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    //Two pointer approach
    public static void reverseString(char[] s) {
        int i = 0, j = s.length-1;

        while(i <= j) {
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
//        assertEquals("Wrong!", "snap&stop", reverseString.reverseStrIter(s));
//    }

    public static void main(String[] args) {
        String s = "pots&pans";

        System.out.println(reverseStr(s));
    }
}
