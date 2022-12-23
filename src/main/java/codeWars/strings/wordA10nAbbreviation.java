package codeWars.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wordA10nAbbreviation {
    /*
        The word i18n is a common abbreviation of internationalization in the developer community, used instead of typing
        the whole word and trying to spell it correctly. Similarly, a11y is an abbreviation of accessibility.
        Write a function that takes a string and turns any and all "words" (see below) within that string of length 4 or
        greater into an abbreviation, following these rules:

        A "word" is a sequence of alphabetical characters. By this definition, any other character like a space or hyphen
        (eg. "elephant-ride") will split up a series of letters into two words (eg. "elephant" and "ride").
        The abbreviated version of the word should have the first letter, then the number of removed characters, then the
        last letter (eg. "elephant ride" => "e6t r2e").
     */
    //O(n) solution
    public static String abbreviate(String string) {
        if (string == null) {
            return null;
        }
        if (string.length() < 4) {
            return string;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < string.length()) {
            //if we are at a space, add it to final string and move to the start of the next word
            if (string.charAt(i) == ' ') {
                sb.append(string.charAt(i));
                i++;
            }
            //add the first character of a new word, make a new SB to hold the characters inside a word, set j the the next letter after the first, and reset counter
            sb.append(string.charAt(i));
            StringBuilder word = new StringBuilder();
            int j = i + 1, count = 0;

            while (j < string.length() && Character.isLetter(string.charAt(j))) {
                word.append(string.charAt(j));
                count++;
                j++;
            }
            //reduce count since we stop after the last character of a word
            count--;
            //if the count + first character and last character is 4 or greater in length, we reduce it, otherwise we add the whole word to the final string
            if ((count) + 2 >= 4) {
                sb.append(count);
                //add the last character of a word to the final string
                if (j >= string.length()) {
                    sb.append(string.charAt(j - 1));
                } else {
                    sb.append(string.charAt(j - 1)).append(string.charAt(j));
                }
            } else {
                sb.append(word);
                if (j < string.length()) {
                    sb.append(string.charAt(j));
                }
            }
            //move i pointer to the start of the next word
            i = j + 1;
        }

        return sb.toString();
    }


    public static String abbreviateEz(String string) {
        String res = string;
        //Regex for a string of any letter and length 4 Ex: {4, 10} -> range 4 to 10
        Pattern p = Pattern.compile("([a-zA-Z]{4,})");
        Matcher m = p.matcher(string);

        //look through the string for words
        while (m.find()) {
            String part = m.group();
            String repl = "" + part.charAt(0) + (part.length() - 2) + part.charAt(part.length() - 1);
            res = res.replaceFirst(part, repl);
        }
        return res;
    }

    public static long timeStart, timeEnd, totalTime;


    public static void main(String[] args) {
        //String word = "internationalization";
        //String word = "elephant-rides are really fun!";
        //String word = "elephant ride";
        String word = "You need, need not want, to complete this code-wars mission this is the longest time of the day-today, " +
                "its the longest sentence of the program to check for the time complexity of the this program using regex vs non-regex, Using regex makes the program look simple but it can be costly";

        timeStart = System.currentTimeMillis();
        System.out.println(abbreviate(word));
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        System.out.printf("The total time to execute without regex is: %d millisecs\n\n", totalTime);

        timeStart = System.currentTimeMillis();
        System.out.println(abbreviateEz(word));
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        System.out.printf("The total time to execute with regex is: %d millisecs\n", totalTime);
    }
}
