public class countSortedVowelStrings {
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    /*
        TC:O(5^n) since we check through all possible combinations of vowels and rejecting those combinations of unsorted
        lexicographical order and O(n) space due to recursive call stack
     */
    private int countVowelStrings(int n) {
        if (n == 1) {
            return 5;
        }
        int vowel_strings = 0;
        //for each vowel, we check how many other vowels can be append to it and only count those of length n and of sorted lexicographical order
        for (char vowel : vowels) {
            //pass n - 1 since we append "vowel" to the string and only require n - 1 more vowels
            vowel_strings += calculateVowels(n - 1, vowel);
        }
        return vowel_strings;
    }

    /*
        simulates adding vowels to the end of a string by checking if the current vowel "c" has a greater lexicographical
        order than last_character, and returns all valid combinations.
     */
    private int calculateVowels(int length, char last_character) {
        //when the length == 0, we found a valid string of length n
        if (length == 0) {
            return 1;
        }

        //variable to hold all the valid sorted combinations of sorted vowel strings
        int valid_combinations = 0;
        for (char c : vowels) {
            //we only "append" the vowel "c" if its lexicographical order is greater than the current last_character
            if (last_character >= c) {
                //pass on c as the new last_character and reduce length
                valid_combinations += calculateVowels(length - 1, c);
            }
        }

        //the number of valid strings that start with initial "last_character"
        return valid_combinations;
    }

    //TC: O(5n) and O(6n) space using dynamic programming
    private static int countVowelStringsDP(int n) {
        /*
            initialize a dp array of length n + 1, +1 to account for empty string and 6 columns, 1 column for each
            length of characters from 0 to 5
        */
        int[][] dp = new int[n + 1][6];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= 5; j++) {
                //fill in row[1] of dp[i][j] with the length of the value of the column
                dp[i][j] = dp[i][j - 1] + (i > 1 ? dp[i - 1][j] : 1);   //use 1 if i < 1 since only single vowels are used
                /*
                    after the initial setup, to find all the valid possible strings generated for the next cell, we take
                    the sum of all valid strings generated from the previous cell and the top cell
                    Ex:
                            u   o,u  i,o,u   e,i,o,u  a,e,i,o,u
                            1    2     3        4         5     -> # of vowels we can use
                 ↑     0    0    0     0        0         0
              lengths  0    1    2     3        4         5     -> if n == 1, 5 strings are possible
                 ↓     0    1    3     6       10        15     -> if n == 2, 15 strings are possible, strings of length 2 using u, len 2 using o,u, len 2 using i,o,u, etc
                       0    1    4    10       20        35     -> if n == 3, 35 strings are possible
                       0    1    5    15       35        70     -> if n == 4, 70 strings are possible
                 */
            }
        }
        //valid strings of length n using 5 vowels
        return dp[n][5];
    }

    /*
        TC/S: O(1) using combination formula with repetitions C = (n + k - 1) / (k! * (n - 1) where n is the length and
        k is the number of vowels.
        simplified formula becomes (n + 4)! / (n! * 4!) ==> (n + 4) * (n + 3) * (n + 2) * (n + 1) / 4!
     */
    private static int countVowelStringsEz(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(countVowelStringsDP(n));
    }
}
