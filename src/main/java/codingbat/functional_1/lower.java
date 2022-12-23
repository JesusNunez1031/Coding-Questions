package codingbat.functional_1;

import java.util.List;

public class lower {
    /*

    Given a list of strings, return a list where each string is converted to codingbat.functional_1.lower case (Note: String toLowerCase() method).

    codingbat.functional_1.lower(["Hello", "Hi"]) → ["hello", "hi"]
    codingbat.functional_1.lower(["AAA", "BBB", "ccc"]) → ["aaa", "bbb", "ccc"]
    codingbat.functional_1.lower(["KitteN", "ChocolaTE"]) → ["kitten", "chocolate"]
     */
    public List<String> lower(List<String> strings) {
        strings.replaceAll(String::toLowerCase);
        return strings;
    }
}
