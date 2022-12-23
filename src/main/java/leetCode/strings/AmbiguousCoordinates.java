package leetCode.strings;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {
    /*
    We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points,
    and spaces, and ended up with the string s.  Return a list of strings representing all possibilities for what our
    original coordinates could have been.

    Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00",
    "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a
    number never occurs without at least one digit occurring before it, so we never started with numbers like ".1".

    The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly
    one space between them (occurring after the comma.)

    Example 1:
    Input: s = "(123)"
    Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]

    Example 2:
    Input: s = "(00011)"
    Output:  ["(0.001, 1)", "(0, 0.011)"]
    Explanation:
    0.0, 00, 0001 or 00.01 are not allowed.

    Example 3:
    Input: s = "(0123)"
    Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]

    Example 4:
    Input: s = "(100)"
    Output: [(10, 0)]
    Explanation:
    1.0 is not allowed.

    Note:
        4 <= s.length <= 12.
        s[0] = "(", s[s.length - 1] = ")", and the other elements in s are digits.
     */
    List<String> coordinates = new ArrayList<>();

    //TC: O(n^3)
    public List<String> ambiguousCoordinates(String s) {
        //remove parentheses from s
        s = s.substring(1, s.length() - 1);

        //break s in x and y form for each value in s e.g. (123) -> (0, 123) | (01, 23)
        for (int i = 1; i < s.length(); i++) {
            makePoint(s.substring(0, i), s.substring(i));
        }
        return coordinates;
    }

    public void makePoint(String x, String y) {
        //get a list of all possible decimal points that can be made using x and y
        List<String> decX = putDecimal(x);
        List<String> decY = putDecimal(y);

        //for every string value x check if its valid, if it is, find a valid y coordinate
        for (String dx : decX) {
            if (isValid(dx)) {
                for (String dy : decY) {
                    if (isValid(dy)) {
                        coordinates.add("(" + dx + ", " + dy + ")");
                    }
                }
            }
        }
    }

    /*
        Method takes in a string p and returns a list of values with decimal points added throughout the string value
        Ex: from 123 the following lists are made,
            p = 1 -> [1]
            p = 23 -> [23, 2.3]

            p = 12 -> [12, 1.2]
            p = 3 -> [3]
     */
    public List<String> putDecimal(String p) {
        List<String> decCoordinates = new ArrayList<>();
        decCoordinates.add(p);

        //add a decimal point in between every index in s and add the value to the list of decimal coordinates
        for (int i = 1; i < p.length(); i++) {
            decCoordinates.add(p.substring(0, i) + "." + p.substring(i));
        }
        return decCoordinates;
    }

    public boolean isValid(String s) {
        /*
            if we have a decimal in s, we split it to check if the decimal point value is valid, i.e. we don't want
            values like 0.0, 00.01, so we split the string at the "." point, if the first part has more than one digit
            and it starts with 0, e.g. 01, 04, return false. if the second part does not end with a 0, we return true,
            we don't want values like 1.0, 2.0, 2.00, etc.
         */
        if (s.contains(".")) {
            String[] part = s.split("\\.");
            if (!part[0].equals("0") && part[0].startsWith("0")) {
                return false;
            } else {
                return !part[1].endsWith("0");
            }
        } else {
            /*
                if the point has no decimal points, we can return true if the string is 0 or if it does not start with
                0 since 01, 04, 06, etc. are not valid
             */
            if (s.equals("0")) {
                return true;
            } else {
                return !s.startsWith("0");
            }
        }
    }
}
