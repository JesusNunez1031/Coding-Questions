package codingbat.functional_2;

import java.util.List;

public class no34 {
    /*
    Given a list of strings, return a list of the strings, omitting any string length 3 or 4.

    codingbat.functional_2.no34(["a", "bb", "ccc"]) → ["a", "bb"]
    codingbat.functional_2.no34(["a", "bb", "ccc", "dddd"]) → ["a", "bb"]
    codingbat.functional_2.no34(["ccc", "dddd", "apple"]) → ["apple"]
     */
    public List<String> no34(List<String> strings) {
        strings.removeIf(n -> n.length() == 3 || n.length() == 4);
        return strings;
    }
}
