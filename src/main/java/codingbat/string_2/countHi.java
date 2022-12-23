package codingbat.string_2;

public class countHi {
    /*
    Return the number of times that the string "hi" appears anywhere in the given string.

    codingbat.string_2.countHi("abc hi ho") → 1
    codingbat.string_2.countHi("ABChi hi") → 2
    codingbat.string_2.countHi("hihi") → 2
     */
    public int countHi(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
                count++;
            }
        }
        return count;
    }
}
