package leetCode.strings;

public class ExcelSheetColumnNumber {
    /*
    Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding
    column number.

    For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

    Example 1:
    Input: columnTitle = "A"
    Output: 1

    Example 2:
    Input: columnTitle = "AB"
    Output: 28

    Example 3:
    Input: columnTitle = "ZY"
    Output: 701

    Constraints:
        1 <= columnTitle.length <= 7
        columnTitle consists only of uppercase English letters.
        columnTitle is in the range ["A", "FXSHRXW"].
     */
    public int titleToNumber(String s) {
        if (s == null) return -1;
        int sum = 0;

        /*
            keep track of column number by adding on to the total the value of the current letter in s. Each new letter
            adds the value 26 so we multiply the current sum by this value for every new letter and then add the value
            of the letter to the sum
         */
        for (char c : s.toUpperCase().toCharArray()) {
            sum *= 26;
            sum += c - 'A' + 1;
        }
        return sum;
    }
}
