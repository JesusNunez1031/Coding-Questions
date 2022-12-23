package leetCode.strings;

import java.util.Arrays;

public class shortestDistanceToACharacter {
    /*
    Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length
    and answer[i] is the shortest distance from s[i] to the character c in s.

    Example 1:
    Input: s = "loveleetcode", c = "e"
    Output: [3,2,1,0,1,0,0,1,2,2,1,0]

    Example 2:
    Input: s = "aaab", c = "b"
    Output: [3,2,1,0]

    Constraints:
        1 <= s.length <= 10^4
        s[i] and c are lowercase English letters.
        c occurs at least once in s.
     */
    //TC: O(n)
    public int[] shortestToChar(String s, char c) {
        if (s.length() == 0) {
            return new int[]{};
        }
        int[] answer = new int[s.length()];

        //reference to the last seen character c, /2 so we avoid overflow
        int prev = Integer.MIN_VALUE / 2;

        //first pass through the string s from the start
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                prev = i;
            } else {
                answer[i] = i - prev;
            }
        }

        prev = Integer.MAX_VALUE / 2;
        //second pass starting from the end
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            } else {
                answer[i] = Math.min(answer[i], prev - i);
            }
        }
        return answer;
    }

    //TC: O(n)
    public static int[] shortestToCharEz(String s, char c) {
        if (s.length() == 0) {
            return new int[]{};
        }

        int[] answer = new int[s.length()];

        int distance = s.length();

        /*
            traverse s from the start making answer[i] = distance, when c is encountered, traverse backwards changing the
            distance of answer[i] to i - pos, e.g. Math.min(answer[i], i - pos), once pos reaches 0, reset the distance to
            0 and continue adding on to the distance of every character after c.
         */
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                int pos = i - 1;
                while (pos >= 0 && i - pos < answer[pos]) {
                    answer[pos] = i - pos;
                    pos--;
                }
                distance = 0;
            }
            answer[i] = distance++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(shortestToCharEz(s, c)));
    }
}
