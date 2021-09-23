import java.util.*;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    /*
    Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

    Return the maximum possible length of s.

    Example 1:
    Input: arr = ["un","iq","ue"]
    Output: 4
    Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
    Maximum length is 4.

    Example 2:
    Input: arr = ["cha","r","act","ers"]
    Output: 6
    Explanation: Possible solutions are "chaers" and "acters".

    Example 3:
    Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
    Output: 26

    Constraints:
        1 <= arr.length <= 16
        1 <= arr[i].length <= 26
        arr[i] contains only lower case English letters.
     */
    private int maxLen = 0;

    //TC: O(m * 2^n) where m is the length of the longest string in arr and n is the length of arr
    public int maxLength(List<String> arr) {
        // holds the characters of the longest combination that can be made from strings in arr
        Set<Character> combinations = new HashSet<>();

        generateCombinations(combinations, arr, 0);

        return maxLen;
    }

    private void generateCombinations(Set<Character> combination, List<String> arr, int index) {
        // stop when all strings in the array have been processed
        if (index == arr.size()) {
            return;
        }

        // convert all the characters in the current string in arr into a char array
        char[] s = arr.get(index).toCharArray();

        boolean isUnique = true;
        Set<Character> chars = new HashSet<>(); // holds all the characters in arr[index], used to check for duplicates

        /*
            process all the strings in arr, when backtracking, we will start from the last string in arr and check if the
            string was full of unique characters we add its characters to combination, and then all strings after the
            current index in the stack will be considered for appending, otherwise we move back to the next unique string.

            these steps are repeated as we backtrack from the end
         */
        for (char c : s) {
            // move to the next string if a duplicate is found in either the string arr[index] or in the current generated combination
            if (chars.contains(c) || combination.contains(c)) {
                isUnique = false;
                break;
            }
            // add seen characters
            chars.add(c);
        }

        generateCombinations(combination, arr, index + 1);

        // if a string was full of unique characters, that means it can be appended to the current combination
        if (isUnique) {
            // the length of the combination is the length of current combination generated + the size of the string to be appended
            maxLen = Math.max(maxLen, combination.size() + s.length);

            combination.addAll(chars); // append the current string to the current combination
            generateCombinations(combination, arr, index + 1); // move to the next string
            combination.removeAll(chars); // when backtracking clear the entire combination made
        }
    }


    // No recursion
    //TC: O(m * 2^n)
    public int maxLengthEZ(List<String> arr) {
        int maxLen = 0;
        List<String> combinations = new ArrayList<>();

        // add the empty string as the first possible combination
        combinations.add("");

        /*
            iterate through each string in arr and check if we can create more combinations by appending the current string
            to previous combinations
         */
        for (String s : arr) {
            // skip strings that contain duplicate characters
            if (!isUnique(s)) {
                continue;
            }
            List<String> newCombinations = new ArrayList<>(); // list of new combinations generated using s
            for (String combination : combinations) {
                String newStr = s + combination;

                // if the combination is valid, add it to the list of new combinations and update the max length seen
                if (isUnique(newStr)) {
                    newCombinations.add(newStr);
                    maxLen = Math.max(maxLen, newStr.length());
                }
                // add all new combinations to the current list of combinations
                combinations.addAll(newCombinations);
            }
        }
        return maxLen;
    }

    //returns true if all characters in s are unique and false otherwise
    private boolean isUnique(String str) {
        // a string of length greater than 26 must have at least one duplicate character
        if (str.length() > 26) {
            return false;
        }

        boolean[] used = new boolean[26];
        for (char ch : str.toCharArray()) {
            if (used[ch - 'a']) {
                return false;
            } else {
                used[ch - 'a'] = true;
            }
        }
        return true;
    }
}
