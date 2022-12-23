package leetCode.design;

import java.util.ArrayList;
import java.util.List;

public class IteratorforCombination {
    /*
    Design the CombinationIterator class:
        - CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of
          sorted distinct lowercase English letters and a number combinationLength as arguments.
        - next() Returns the next combination of length combinationLength in lexicographical order.
        - hasNext() Returns true if and only if there exists a next combination.

    Example 1:
    Input
    ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
    [["abc", 2], [], [], [], [], [], []]
    Output
    [null, "ab", true, "ac", true, "bc", false]
    Explanation
    CombinationIterator itr = new CombinationIterator("abc", 2);
    itr.next();    // return "ab"
    itr.hasNext(); // return True
    itr.next();    // return "ac"
    itr.hasNext(); // return True
    itr.next();    // return "bc"
    itr.hasNext(); // return False

    Constraints:
        1 <= combinationLength <= characters.length <= 15
        All the characters of characters are unique.
        At most 10^4 calls will be made to next and hasNext.
        It's guaranteed that all calls of the function next are valid.
     */

    /**
     * Your CombinationIterator object will be instantiated and called as such:
     * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
     * String param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    class CombinationIterator {
        List<String> combinations;
        int index;

        public CombinationIterator(String characters, int combinationLength) {
            combinations = new ArrayList<>();
            index = 0;

            //generate all possible leetCode.backtracking.combinations of "combinationLength" using "characters"
            generateCombinations(characters, combinationLength, 0, new StringBuilder());

            // leetCode.backtracking.combinations were generated in lexicographical order so no need to sort
        }

        private void generateCombinations(String characters, int combLength, int iterIndex, StringBuilder curr) {
            // a combination was found
            if (curr.length() == combLength) {
                combinations.add(curr.toString());
                return;
            }

            // we have run out of characters to use
            if (iterIndex == characters.length()) {
                return;
            }

            for (int i = iterIndex; i < characters.length(); i++) {
                curr.append(characters.charAt(i));
                generateCombinations(characters, combLength, i + 1, curr);
                curr.setLength(curr.length() - 1);
            }
        }

        public String next() {
            if (index >= combinations.size()) {
                return null;
            }
            return combinations.get(index++);
        }

        public boolean hasNext() {
            return index <= combinations.size() - 1;
        }
    }
}
