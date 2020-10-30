import org.junit.Test;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class mergedStringChecker {
    /*
    At a job interview, you are challenged to write an algorithm to check if a given string, s, can be formed from two other strings, part1 and part2.
    The restriction is that the characters in part1 and part2 should be in the same order as in s.
    The interviewer gives you the following example and tells you to figure out the rest from the given test cases.

    For example:
    'codewars' is a merge from 'cdw' and 'oears':

        s:  c o d e w a r s   = codewars
    part1:  c   d   w         = cdw
    part2:    o   e   a r s   = oears
     */

    //O(n^2) solution, for this problem is not bad
    public static boolean isMerge(String s, String part1, String part2) {
        if (s.equals("")) {
            return part1.equals("") && part2.equals("");
        } else {
            boolean isMerged1 = false, isMerged2 = false;
            if (part1.length() > 0 && s.charAt(0) == part1.charAt(0)) {
                isMerged1 = isMerge(s.substring(1), part1.substring(1), part2);
            }
            if (part2.length() > 0 && s.charAt(0) == part2.charAt(0)) {
                isMerged2 = isMerge(s.substring(1), part1, part2.substring(1));
            }
            return isMerged1 || isMerged2;
        }
    }

    @Test
    public void normalHappyFlow() {
        assertTrue("codewars can be created from code and wars", mergedStringChecker.isMerge("codewars", "code", "wars"));
        assertTrue("codewars can be created from cdwr and oeas", mergedStringChecker.isMerge("codewars", "cdwr", "oeas"));
        assertFalse("Codewars are not codwars", mergedStringChecker.isMerge("codewars", "cod", "wars"));
    }

    public static void main(String[] args) {
        System.out.println(isMerge("Bananas from Bahamas", "Bahas", "Bananas from am"));

    }
}
