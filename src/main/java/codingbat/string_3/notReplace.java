package codingbat.string_3;

public class notReplace {
    /*
    Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not".
    The word "is" should not be immediately preceded or followed by a letter -- so for example the "is" in "this" does not count. (Note: Character.isLetter(char) tests if a char is a letter.)

    codingbat.string_3.notReplace("is test") → "is not test"
    codingbat.string_3.notReplace("is-is") → "is not-is not"
    codingbat.string_3.notReplace("This is right") → "This is not right"
     */

    public String notReplace(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i - 1 >= 0 && Character.isLetter(str.charAt(i - 1)) || i + 2 < len && Character.isLetter(str.charAt(i + 2))) {
                sb.append(str.charAt(i));
            } else if (i + 1 < len && str.startsWith("is", i)) {
                sb.append("is not");
                i++;
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
