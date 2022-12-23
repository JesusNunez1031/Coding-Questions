package ctci.strings;

import java.util.HashMap;

public class PalindromePermutation {

    /*
    Given a string, write a function to check if it is a permutation of a palindrome.
    Solution 1: Using a hash table, we count how many times each character appears. Then we go through the hash table and ensure that no more than one character has an odd count
    At most, one character, (the middle character) can have and odd count
     */

    public static boolean isPermutationOfPalindrome(String str) {
        int[] table = buildCharFrequencyTable(str);
        return checkMaxOneOdd(table);
    }

    // Check that no more than one character has an odd count
    static boolean checkMaxOneOdd(int[] table ) {
        boolean foundOdd = false;
        // This sets count to each value in table, so if table is [10, 20, 30, etc], on first iteration, count will be 10, then 20, and so on...
        for(int count : table){
            if(count % 2 == 1) {
                if(foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    // Map each of the characters to a number: a -> 0, b -> 1, c -> 2, etc
    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    //Count how many times each character appears
    public static int[] buildCharFrequencyTable(String str) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : str.toCharArray()) {
            int x = getCharNumber(c);
            if ( x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    // Solution 2 is just one pass and check as we go
    public static boolean isPermutation(String str) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for(char c : str.toCharArray()) {
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
                if(table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    public static void main(String[] args) {
       // This algorithm is O(N) where n is the length of the string
        //System.out.print(isPermutationOfPalindrome("Tact Coa"));
        System.out.print(isPermutation("Tact Coa"));
    }
}
