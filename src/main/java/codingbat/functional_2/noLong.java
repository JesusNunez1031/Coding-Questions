package codingbat.functional_2;

import java.util.List;

public class noLong {
    /*
    Given a list of strings, return a list of the strings, omitting any string length 4 or more.

    codingbat.functional_2.noLong(["this", "not", "too", "long"]) → ["not", "too"]
    codingbat.functional_2.noLong(["a", "bbb", "cccc"]) → ["a", "bbb"]
    codingbat.functional_2.noLong(["cccc", "cccc", "cccc"]) → []
     */
    public List<String> noLong(List<String> strings) {
        strings.removeIf(n -> n.length() >= 4);
        return strings;
    }
}
