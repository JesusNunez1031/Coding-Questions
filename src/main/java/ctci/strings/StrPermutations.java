package ctci.strings;

import java.util.Arrays;

public class StrPermutations {

    //Solution one is to sort the strings and check if they are equal to each other
    public static boolean isPermutation(String a, String b) {
        //check for the length of the strings, if they dont match then they cant be permutations
        if(a.length() != b.length()) {
            return false;
        }
        return sort(a).equals(sort(b));
    }

    //Helper method ot sort the strings
    public static String sort(String str) {
        char[] string = str.toCharArray();
        Arrays.sort(string);
        return new String(string);
    }

    //Second method is to count the number of unique letters found in the respective strings and then match them to each other
    public static boolean isPermutation2(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        //as the book states, assume that we are working with ASCII values, else this approach wont work
        int[] letters = new int[128];

        char[] a_array = a.toCharArray();
        for(char i : a_array) { //count the number of each char in s
            // increment the value of the letter found
            letters[i]++;
        }

        // Loop for the length of the second string
        for(int i = 0;i < b.length();i++) {
            // c is the integer value for the character at charAt(i) of b
            int c = (int) b.charAt(i);
            // decrement the value for the specific letter found
            letters[c]--;
            // if the value is negative for any letter that means it was not in the first string or it appears more times in the second
            // therefore we return false because the strings aren't permutations of each other
            if(letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        System.out.println(isPermutation2("absced", "descba"));
    }
}
