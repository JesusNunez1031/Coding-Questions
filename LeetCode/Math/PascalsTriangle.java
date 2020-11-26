import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    /*
        Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
                                                                        default row -> 1
                                                                      also default -> 1 1
                             the two 1's from the prev row make the 2 in this row -> 1 2 1
         the 3 is made from the 1 + 2 from the start and end of the previous row -> 1 3 3 1

        Input: 5
        Output:
        [
             [1],
            [1,1],
           [1,2,1],
          [1,3,3,1],
         [1,4,6,4,1]
        ]
     */

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            //List to hold all the values in the current row
            List<Integer> currentRow = new ArrayList<>();

            //the counter j will hold the number of values in the current row
            int j = 0;

            //i is the upper bound of values in the row, so while j is less than it, we add values to the row
            while (j <= i) {
                //If we are at the first position or last, insert a 1 since all rows start and end at 1
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    //Otherwise we add the value from the previous list at position -1 and +1 from our current position in the list
                    /*
                    Example if we are at the 3rd row:
                        1
                       1 1
                      1 2 1  --> to get the 2 we added the 1 at j-1 and j position from the row i - 1 (previous row)
                     */
                    currentRow.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
                j++;
            }
            result.add(currentRow);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5).toString().replaceAll("],", "\n"));
    }
}
