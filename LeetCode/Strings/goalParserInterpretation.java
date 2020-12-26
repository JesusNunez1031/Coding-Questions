public class goalParserInterpretation {
    /*
    You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or
    "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the
    string "al". The interpreted strings are then concatenated in the original order.

    Given the string command, return the Goal Parser's interpretation of command.

    Example 1:
    Input: command = "G()(al)"
    Output: "Goal"
    Explanation: The Goal Parser interprets the command as follows:
    G -> G
    () -> o
    (al) -> al
    The final concatenated result is "Goal".

    Example 2:
    Input: command = "G()()()()(al)"
    Output: "Gooooal"

    Example 3:
    Input: command = "(al)G(al)()()G"
    Output: "alGalooG"

    Constraints:
        1 <= command.length <= 100
        command consists of "G", "()", and/or "(al)" in some order.
     */
    private String interpret(String command) {
        if (command.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                sb.append('o');
                i++;
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a') {
                sb.append("al");
                i += 3;
            }
        }
        return sb.toString();
    }
}
