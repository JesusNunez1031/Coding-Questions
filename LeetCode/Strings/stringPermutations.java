import java.util.ArrayList;
import java.util.List;

public class stringPermutations {
    /*
    Given a string of all unique letters, return a list containing all the permutations of the string

    Example 1:
        s = "abc"
        output: ["abc", "acb", "bac", "bca", "cab", "cba"]
     */
    //TC: O(n!) using backtracking
    public static List<String> strPermutations(String s) {
        List<String> res = new ArrayList<>();
        if (s.equals("")) {
            return res;
        }
        StringBuilder sb = new StringBuilder();

        getPermutations(s, sb, res);

        return res;
    }

    public static void getPermutations(String s, StringBuilder sb, List<String> res) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }

        for (char c : s.toCharArray()) {
            //if the current stringbuilder doesnt contain the character c, add it the to the SB and call method again to add new strings
            if (!sb.toString().contains(String.valueOf(c))) {
                sb.append(c);
                getPermutations(s, sb, res);
                //remove last character from the stringBuilder once we have a permutation
                sb.setLength(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(strPermutations(str).toString());
    }
}
