package codingbat.functional_1;

import java.util.List;

public class copies3 {
    /*
    Given a list of strings, return a list where each string is replaced by 3 copies of the string concatenated together.

    codingbat.functional_1.copies3(["a", "bb", "ccc"]) → ["aaa", "bbbbbb", "ccccccccc"]
    codingbat.functional_1.copies3(["24", "a", ""]) → ["242424", "aaa", ""]
    codingbat.functional_1.copies3(["hello", "there"]) → ["hellohellohello", "theretherethere"]
     */
    public List<String> copies3(List<String> strings) {
        strings.replaceAll(n -> n + n + n);
        return strings;
    }
}
