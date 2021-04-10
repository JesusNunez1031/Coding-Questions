import java.util.HashMap;
import java.util.Map;

public class verifyAlienDictionary {
    /*
    In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
    The order of the alphabet is some permutation of lowercase letters.
    Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only
    if the given words are sorted lexicographicaly in this alien language.



    Example 1:
    Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
    Output: true
    Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

    Example 2:
    Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
    Output: false
    Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

    Example 3:
    Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
    Output: false
    Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to
    lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is
    less than any other character (More info).


    Constraints:
        1 <= words.length <= 100
        1 <= words[i].length <= 20
        order.length == 26
        All characters in words[i] and order are English lowercase letters.
     */

    //TC: O(C) where c is the number of words and constant space since we use a map only to store 26 letters
    public boolean isAlienSorted(String[] words, String order) {

        //map to hold the lexicographical order of the letters in "order"
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i + 1);
        }

        //System.out.println(map.toString());
        //if the length of words is 1, check the order of the letters in the only word
        if (words.length == 1) {
            return isValid(words[0], map);
        }

        int i = 0;
        while (i < words.length - 1) {
            String w1 = words[i];
            String w2 = words[i + 1];

            //compare the two words to each other
            int len = Math.min(w1.length(), w2.length());
            int k = 0;
            while (k < len) {
                if (w1.charAt(k) != w2.charAt(k)) {
                    //if the w1's character at k has a higher order than w2, return false
                    if (map.get(w1.charAt(k)) > map.get(w2.charAt(k))) {
                        return false;
                        //otherwise we set the len to -1 to break out of loop
                    } else {
                        len = -1;
                    }
                }
                k++;
            }

            /*
                if len == -1, then we know the words are sorted since they met the lexicographical condition so no need
                to further check for order, otherwise, if the fist word is longer than the second, lexicographically, the
                second should come first so we return false
                Ex: apple and app, we terminate the iteration of the word without len being -1, so the words can now be checked for
                length
            */
            if (len != -1 && w1.length() > w2.length()) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean isValid(String word, Map<Character, Integer> map) {
        if (word.length() == 1) {
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
            if (map.get(word.charAt(i - 1)) > map.get(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
