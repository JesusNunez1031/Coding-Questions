package codingbat.string_3;

public class MirrorEnds {

    /*
    Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string. In other words, zero or more characters at the very begining of the given string, and at the very end of the string in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".

    mirrorEnds("abXYZba") → "ab"
    mirrorEnds("abca") → "a"
    mirrorEnds("aba") → "aba"
     */

    public String mirrorEnds(String string) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = string.length() - 1;

        while (i < string.length() && j >= 0) {
            if (string.charAt(i) == string.charAt(j)) {
                sb.append(string.charAt(i));
                i++;
                j--;
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
