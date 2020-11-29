import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class multiTapKeypadTextEntryOnOldPhone {
    /*
    Prior to having fancy iPhones, teenagers would wear out their thumbs sending SMS messages on candybar-shaped feature
     phones with 3x4 numeric keypads.
    ------- ------- -------
    |     | | ABC | | DEF |
    |  1  | |  2  | |  3  |
    ------- ------- -------
    ------- ------- -------
    | GHI | | JKL | | MNO |
    |  4  | |  5  | |  6  |
    ------- ------- -------
    ------- ------- -------
    |PQRS | | TUV | | WXYZ|
    |  7  | |  8  | |  9  |
    ------- ------- -------
    ------- ------- -------
    |     | |space| |     |
    |  *  | |  0  | |  #  |
    ------- ------- -------
    Prior to the development of T9 (predictive text entry) systems, the method to type words was called "multi-tap" and
    involved pressing a button repeatedly to cycle through the possible values.

    For example, to type a letter "R" you would press the 7 key three times (as the screen display for the current character
    cycles through P->Q->R->S->7). A character is "locked in" once the user presses a different key or pauses for a short
    period of time (thus, no extra button presses are required beyond what is needed for each letter individually). The
    zero key handles spaces, with one press of the key producing a space and two presses producing a zero.

    In order to send the message "WHERE DO U WANT 2 MEET L8R" a teen would have to actually do 47 button presses. No wonder they abbreviated.

    For this assignment, write a module that can calculate the amount of button presses required for any phrase. Punctuation
    can be ignored for this exercise. Likewise, you can assume the phone doesn't distinguish between upper/lowercase characters
    (but you should allow your module to accept input in either for convenience).

    Hint: While it wouldn't take too long to hard code the amount of keypresses for all 26 letters by hand, try to avoid
    doing so! (Imagine you work at a phone manufacturer who might be testing out different keyboard layouts, and you want
    to be able to test new ones rapidly.)
     */
    private static int presses(String phrase) {
        if (phrase == null || phrase.length() == 0) {
            return 0;
        }

        //26 letters in the alphabet
        int[] letterStrokes = getStrokesLetters();
        int[] numStrokes = {2, 1, 4, 4, 4, 4, 4, 5, 4, 5};  //number of key presses for each number

        int keyStrokes = 0;
        for (char c : phrase.toCharArray()) {
            if (Character.isLetter(c)) {
                keyStrokes += letterStrokes[Character.toLowerCase(c) - 'a'];
            } else if (c == ' ' || c == '*' || c == '#') {
                keyStrokes += 1;
            } else if (Character.isDigit(c)) {
                keyStrokes += numStrokes[(int) c - '0'];
            }
        }
        return keyStrokes;
    }

    private static int[] getStrokesLetters() {
        int[] array = new int[26];
        int count = 1;
        int sCount = 1;
        for (int i = 0; i < 26; i++) {
            if (i >= 15 && i <= 18 || i >= 22) {
                if (sCount > 4) {
                    sCount = 1;
                }
                array[i] = sCount++;
            } else {
                if (count > 3) {
                    count = 1;
                }
                array[i] = count++;
            }
        }
        return array;
    }

    @Test
    public void simpleTest() {
        assertEquals(9, multiTapKeypadTextEntryOnOldPhone.presses("LOL"));
        assertEquals(13, multiTapKeypadTextEntryOnOldPhone.presses("HOW R U"));
        assertEquals(47, multiTapKeypadTextEntryOnOldPhone.presses("WHERE DO U WANT 2 MEET L8R"));
    }
}
