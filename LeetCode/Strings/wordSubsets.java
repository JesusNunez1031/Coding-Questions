import java.util.ArrayList;
import java.util.List;

public class wordSubsets {
    /*
    We are given two arrays A and B of words.  Each word is a string of lowercase letters.

    Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example,
    "wrr" is a subset of "warrior", but is not a subset of "world".

    Now say a word a from A is universal if for every b in B, b is a subset of a.

    Return a list of all universal words in A.  You can return the words in any order.

    Example 1:
    Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
    Output: ["facebook","google","leetcode"]

    Example 2:
    Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
    Output: ["apple","google","leetcode"]

    Example 3:
    Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
    Output: ["facebook","google"]

    Example 4:
    Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
    Output: ["google","leetcode"]

    Example 5:
    Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
    Output: ["facebook","leetcode"]

    Note:
        1 <= A.length, B.length <= 10000
        1 <= A[i].length, B[i].length <= 10
        A[i] and B[i] consist only of lowercase letters.
        All words in A[i] are unique: there isn't i != j with A[i] == A[j].
     */
    //TC: O(A + B) and constant space sine we only store 26 letters
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> universal = new ArrayList<>();

        /*
            find the count of each letter in B that can be present in a word a of A.
            Ex: b = ["e", "co", "eeo"]
                for a word in A to be universal, it can have up to 2 "e", 1 "c", and 1 "o" all the unique letters in B are
                combined into one "string", i.e. a frequency array, producing: "eeco", where c[e] = 2, c[c] = 1, etc

                if a word b has a higher letter count for a specific letter, we keep the higher count since it allows for
                a word in A to also have the same frequency of that letter, e.g. "eeo", initially, c[e] = 1, now its 2
        */
        int[] count = new int[26];  //array holding the max count of each letter that must be in A, all characters are lowercase

        //search all words in B to make the valid count array
        for (String b : B) {
            int[] temp_count = new int[26]; //temp count array for the word b
            for (char c : b.toCharArray()) {
                temp_count[c - 'a']++; //increase the count of letter c

                /*
                    we want to have the max letter count so if a letter in the current word allows the use of more of the
                    same letter we update the count array
                */
                count[c - 'a'] = Math.max(count[c - 'a'], temp_count[c - 'a']);
            }
        }

        /*
            for each word a in A, make the count array and compare the count of each letter in A to the count
            B, if at any point the frequency of a letter in A is more than count, a is not a universal word
        */
        for (String a : A) {
            int[] a_count = new int[26];

            for (char c : a.toCharArray()) {
                a_count[c - 'a']++;
            }
            if (isSubset(a_count, count)) {
                universal.add(a);
            }
        }
        return universal;
    }

    private boolean isSubset(int[] a, int[] count) {
        for (int i = 0; i < 26; i++) {
            /*
                word "a" must have a count of equal or greater frequency for each letter in "count" for it to be universal
                if its less, that means "a" is missing a letter(s) or not enough letters of the same type are missing
             */
            if (a[i] < count[i]) {
                return false;
            }
        }
        return true;
    }
}
