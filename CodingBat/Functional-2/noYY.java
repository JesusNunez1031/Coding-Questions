import java.util.List;

public class noYY {
    /*
    Given a list of strings, return a list where each string has "y" added at its end, omitting any resulting strings that contain "yy" as a substring anywhere.

    noYY(["a", "b", "c"]) → ["ay", "by", "cy"]
    noYY(["a", "b", "cy"]) → ["ay", "by"]
    noYY(["xx", "ya", "zz"]) → ["xxy", "yay", "zzy"]
     */
    public List<String> noYY(List<String> strings) {
        strings.replaceAll(n -> n + "y");
        strings.removeIf(n -> n.contains("yy"));
        return strings;
    }
}
