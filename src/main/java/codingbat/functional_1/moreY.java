package codingbat.functional_1;

import java.util.List;

public class moreY {
    /*
    Given a list of strings, return a list where each string has "y" added at its start and end.

    codingbat.functional_1.moreY(["a", "b", "c"]) → ["yay", "yby", "ycy"]
    codingbat.functional_1.moreY(["hello", "there"]) → ["yhelloy", "ytherey"]
    codingbat.functional_1.moreY(["yay"]) → ["yyayy"]
     */
    public List<String> moreY(List<String> strings) {
        strings.replaceAll(n -> "y" + n + "y");
        return strings;
    }
}
