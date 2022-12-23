package leetCode.strings;

public class excelSheetColumn {
    /*
        Given a positive integer, return its corresponding column title as appear in an Excel sheet.
        For example:

            1 -> A
            2 -> B
            3 -> C
            ...
            26 -> Z
            27 -> AA
            28 -> AB
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n /= 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        char[] alpha = new char[26];
        for (int i = 0; i < 26; i++) {
            alpha[i] = (char) (65 + i);
        }

        for (char c : alpha) {
            System.out.printf("%c ", c);
        }
    }
}
