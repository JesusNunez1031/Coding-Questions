package codingbat.functional_2;

import java.util.List;

public class noZ {
    /*

    Given a list of strings, return a list of the strings, omitting any string that contains a "z". (Note: the str.contains(x) method returns a boolean)

    codingbat.functional_2.noZ(["aaa", "bbb", "aza"]) → ["aaa", "bbb"]
    codingbat.functional_2.noZ(["hziz", "hzello", "hi"]) → ["hi"]
    codingbat.functional_2.noZ(["hello", "howz", "are", "youz"]) → ["hello", "are"]
     */
    public List<String> noZ(List<String> strings) {
        strings.removeIf(n -> n.contains("z"));
        return strings;
    }
}
