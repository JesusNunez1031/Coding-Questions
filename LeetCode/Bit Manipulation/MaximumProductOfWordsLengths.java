public class MaximumProductOfWordsLengths {
    /*
    Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not
    share common letters. If no such two words exist, return 0.

    Example 1:
    Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
    Output: 16
    Explanation: The two words can be "abcw", "xtfn".

    Example 2:
    Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
    Output: 4
    Explanation: The two words can be "ab", "cd".

    Example 3:
    Input: words = ["a","aa","aaa","aaaa"]
    Output: 0
    Explanation: No such pair of words.

    Constraints:
        2 <= words.length <= 1000
        1 <= words[i].length <= 1000
        words[i] consists only of lowercase English letters.
     */
    //TC: O(n^2) and O(n) space where n is the length of words array
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] states = new int[n];

        //set an bitmask value for each word in the array
        for (int i = 0; i < n; i++) {
            states[i] = getState(words[i]);
        }

        int maxProduct = 0; //value of the largest product between two words

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                /*
                    when the two values and' together == 0, that means the two words compared had no matching bits, or
                    share not similar letters.
                    Ex: abcw = 4194311  |  foo = 16416
                        abc = 33554435  |

                       4194311 & 33554435 = 3 since a, b, and c overlap in both words hence the product of these two words
                       cant be considered.

                       on the other hand, 4194311 & 16416 = 0 since "abcw" and "foo" share no similar characters, therefore
                       their products can be considered.
                 */
                if ((states[i] & states[j]) == 0) {
                    //update the max product if the current product is larger than the max
                    if (words[i].length() * words[j].length() > maxProduct) {
                        maxProduct = words[i].length() * words[j].length();
                    }
                }
            }
        }
        return maxProduct;
    }

    /*
        Method takes in a string word and returns an integer value created from triggering all binary bits for
        characters in the word, e.g. if word == abcw, 32 bits in a binary value, and we activate all the bits for each
        if the 4 characters so we get a value, 00000000010000000000000000000111
     */
    private int getState(String word) {
        int state = 0;

        for (char c : word.toCharArray()) {
            int val = c - 'a'; //get the ascii value of c
            state |= 1 << val; //shift the 1 bit in 1 to the left by "val" times and add it to the "state" sum
        }
        return state;
    }
}
