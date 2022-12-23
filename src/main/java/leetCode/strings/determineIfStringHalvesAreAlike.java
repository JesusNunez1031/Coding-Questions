package leetCode.strings;

public class determineIfStringHalvesAreAlike {
    /*
    You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first
    half and b be the second half.

    Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
    Notice that s contains uppercase and lowercase letters.

    Return true if a and b are alike. Otherwise, return false.

    Example 1:
    Input: s = "book"
    Output: true
    Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.

    Example 2:
    Input: s = "textbook"
    Output: false
    Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
    Notice that the vowel o is counted twice.

    Example 3:
    Input: s = "MerryChristmas"
    Output: false

    Example 4:
    Input: s = "AbCdEfGh"
    Output: true

    Constraints:
        2 <= s.length <= 1000
        s.length is even.
        s consists of uppercase and lowercase letters.
     */
    //TC:(h) where h is half the length of the string s
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        //Take the first and second halves of s
        String first_half = s.substring(0, n / 2);
        String second_half = s.substring(n / 2, n);

        //vowel counter for first and second half
        int first_vowels = 0;
        int second_vowels = 0;

        //search through all characters in each half and then compare vowel counts
        for (int i = 0; i < n / 2; i++) {
            if (isVowel(first_half.charAt(i))) {
                first_vowels++;
            }
            if (isVowel(second_half.charAt(i))) {
                second_vowels++;
            }
        }
        return first_vowels == second_vowels;
    }

    //Returns true of the character "letter" is a vowel
    private boolean isVowel(char letter) {
        switch (letter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
        }
        return false;
    }
}
