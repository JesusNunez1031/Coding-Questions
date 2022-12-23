package leetCode.greedyAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class StampingTheSequence {
    /*
    You want to form a target string of lowercase letters.

    At the beginning, your sequence is target.length '?' marks.  You also have a stamp of lowercase letters.

    On each turn, you may place the stamp over the sequence, and replace every letter in the sequence with the
    corresponding letter from the stamp.  You can make up to 10 * target.length turns.

    For example, if the initial sequence is "?????", and your stamp is "abc",  then you may make "abc??", "?abc?",
    "??abc" in the first turn.  (Note that the stamp must be fully contained in the boundaries of the sequence in order to stamp.)

    If the sequence is possible to stamp, then return an array of the index of the left-most letter being stamped at
    each turn.  If the sequence is not possible to stamp, return an empty array.

    For example, if the sequence is "ababc", and the stamp is "abc", then we could return the answer [0, 2],
    corresponding to the moves "?????" -> "abc??" -> "ababc".

    Also, if the sequence is possible to stamp, it is guaranteed it is possible to stamp within 10 * target.length moves.
    Any answers specifying more than this number of moves will not be accepted.

    Example 1:
    Input: stamp = "abc", target = "ababc"
    Output: [0,2]
    ([1,0,2] would also be accepted as an answer, as well as some other answers.)

    Example 2:
    Input: stamp = "abca", target = "aabcaca"
    Output: [3,0,1]

    Note:
        1 <= stamp.length <= target.length <= 1000
        stamp and target only contain lowercase letters.
     */
    //TC:O(n * (n - m)) where n is the length of the target string and m the stamp
    public int[] movesToStamp(String stamp, String target) {
        //turn the strings into character arrays
        char[] tchar = target.toCharArray();
        char[] schar = stamp.toCharArray();

        //the number of '?' characters in target string
        int count = 0;

        //indexes where we can place a full stamp in target
        boolean[] visited = new boolean[tchar.length];

        //holds the indexes where a full stamp fits in target, left most index is stored
        List<Integer> res = new ArrayList<>();

        while (count != tchar.length) {
            //checks if we can stamp target, if false, the current target cant be stamped
            boolean stamped = false;

            //check all substrings in target to see if we can stamp it or not
            for (int i = 0; i <= tchar.length - schar.length; i++) {
                /*
                    if the current index has not been checked and we can stamp the target, i.e. we can place '?' of stamp
                    length into target, then we update the count mark the index as visited, mark stamped as true as we
                    could stamp and add the index to the list of stamped indexes
                */
                if (!visited[i] && canReplace(tchar, i, schar)) {
                    count = replace(tchar, i, schar.length, count);
                    visited[i] = true;
                    stamped = true;
                    res.add(i);

                    //when the count == target length, that means all stamps in target are complete
                    if (count == tchar.length) {
                        break;
                    }
                }
            }
            //if we could not stamp at an index, target cant be made by stamp string
            if (!stamped) {
                return new int[0];
            }
        }

        //add all the indexes to the resulting array, indexes are in reverse order
        int[] result = new int[res.size()];
        int k = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            result[k++] = res.get(i);
        }
        return result;
    }

    //returns true if we can stamp "stamp' string into target and if its hasn't been stamped before, i.e. no '?'
    boolean canReplace(char[] tchar, int pos, char[] schar) {
        for (int i = 0; i < schar.length; i++) {
            if (tchar[i + pos] != '?' && tchar[i + pos] != schar[i]) {
                return false;
            }
        }
        return true;
    }

    //returns the number of '?' characters present in target string
    int replace(char[] tchar, int pos, int len, int count) {
        for (int i = 0; i < len; i++) {
            if (tchar[i + pos] != '?') {
                tchar[i + pos] = '?';
                count++;
            }
        }
        return count;
    }
}
