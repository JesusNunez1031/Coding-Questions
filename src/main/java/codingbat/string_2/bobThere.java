package codingbat.string_2;

public class bobThere {
    /*
    Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.

    codingbat.string_2.bobThere("abcbob") → true
    codingbat.string_2.bobThere("b9b") → true
    codingbat.string_2.bobThere("bac") → false
     */
    public boolean bobThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b') {
                return true;
            }
        }
        return false;
    }
}
