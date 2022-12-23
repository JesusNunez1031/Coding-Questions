package codingbat.functional_1;

import java.util.List;

public class addStar {
    /*
    Given a list of strings, return a list where each string has "*" added at its end.

    codingbat.functional_1.addStar(["a", "bb", "ccc"]) → ["a*", "bb*", "ccc*"]
    codingbat.functional_1.addStar(["hello", "there"]) → ["hello*", "there*"]
    codingbat.functional_1.addStar(["*"]) → ["**"]
     */
    public List<String> addStar(List<String> strings) {
        strings.replaceAll(n -> n + "*");
        return strings;
    }
}
