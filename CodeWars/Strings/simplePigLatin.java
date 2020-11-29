import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class simplePigLatin {
    /*
        Given a string of words, take the fist letter of a word, add it to the end of the word with "ay" after the letter
            Ex:
                Pig latin is cool -> igPay atinlay siay oolcay
                This is my string -> hisTay siay ymay tringsay
     */
    public static String pigIt(String str) {
        if (str.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char pig = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == ' ') {
                sb.append(pig).append("ay ");
            } else if (str.charAt(i - 1) == ' ') {
                pig = c;
            } else {
                sb.append(c);
            }
        }
        //We'll have a left over char that need to be append, check if its not a special character
        if (Character.isLetter(pig)) {
            sb.append(pig).append("ay");
        } else {
            sb.append(pig);
        }

        return sb.toString();
    }

    @Test
    public void FixedTests() {
        assertEquals("igPay atinlay siay oolcay", simplePigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", simplePigLatin.pigIt("This is my string"));
    }
}
