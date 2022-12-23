package codingbat.functional_2;

import java.util.List;

public class noYY {
    /*
    Given a list of strings, return a list where each string has "y" added at its end, omitting any resulting strings that contain "yy" as a substring anywhere.

    codingbat.functional_2.noYY(["a", "b", "c"]) → ["ay", "by", "cy"]
    codingbat.functional_2.noYY(["a", "b", "cy"]) → ["ay", "by"]
    codingbat.functional_2.noYY(["xx", "ya", "zz"]) → ["xxy", "yay", "zzy"]
     */
    public List<String> noYY(List<String> strings) {
        strings.replaceAll(n -> n + "y");
        strings.removeIf(n -> n.contains("yy"));
        return strings;
    }
}
