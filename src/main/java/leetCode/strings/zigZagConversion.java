package leetCode.strings;

import java.util.LinkedList;
import java.util.List;

public class zigZagConversion {
    /*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
    display this pattern in a fixed font for better legibility)
    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"

    Write the code that will take a string and make this conversion given a number of rows:
        string convert(string s, int numRows);

    Example 1:
    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"

    Example 2:
    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:
    P     I    N
    A   L S  I G
    Y A   H R
    P     I

    Example 3:
    Input: s = "A", numRows = 1
    Output: "A"

    Constraints:
        1 <= s.length <= 1000
        s consists of English letters (lower-case and upper-case), ',' and '.'.
        1 <= numRows <= 1000
     */
    //TC/S: O(n)
    private String convert(String s, int numRows) {
        //if there is only one row, the whole string will be in it
        if (numRows == 1) {
            return s;
        }
        //List to hold the strings that will be made in each row
        List<StringBuilder> rows = new LinkedList<>();

        /*
            The number of rows added will be the smallest value between s length and numRows
            Ex:
                if numRows = 3 and s = "AB"
                the max rows we can use are 2, since AB dont have a 3rd letter to fill a 3rd row
        */
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }

        //curr_row holds the row we are at
        int curr_row = 0;

        //flag to switch from going down to up, and vise versa
        boolean goingUp = false;

        //add characters from s in the order of the rows
        for (char c : s.toCharArray()) {
            //add the c to the current row
            rows.get(curr_row).append(c);

            //if we are going up, we reduce rows, if not going up we increase rows
            curr_row += goingUp ? -1 : 1;

            //when the start or end of the rows needed is reached, switch directions
            if (curr_row == 0 || curr_row == numRows - 1) {
                goingUp = !goingUp;
            }

        }

        //append all the strings made for each row into one string "zigZag"
        StringBuilder zigZag = new StringBuilder();

        for (StringBuilder str : rows) {
            zigZag.append(str.toString());
        }
        return zigZag.toString();
    }
}
