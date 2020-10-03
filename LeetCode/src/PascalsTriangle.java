import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    /*
    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

     */

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        //Init a variable to hold the number of values in the current row
        int j = 0;

        for(int i = 0; i < numRows;i++) {
            //List to hold all the values in the current row
            List<Integer> currentRow = new ArrayList<>();

            //Loop until all values that belong in the row are added
            while (j <= i) {
                //If we are at the first position or last, insert a 1 since all rows start and end at 1
                if(j == 0 || j == i) {
                    currentRow.add(1);
                }
                else {
                    //Otherwise we add the value from the previous list at position -1 and +1 from our current position in the list
                    /*
                    Example if we are at the 3rd row:
                        1
                       1 1
                      1 2 1  --> to get the 2 we added the 1 at j-1 and j position
                     */
                    currentRow.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
                j++;
            }
            //Reset j and add new list to collection of rows
            j = 0;
            result.add(currentRow);
        }
        return result;
    }

    public static void main(String[] args) {
       System.out.println(generate(5).toString());

//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        result.add(l1);
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(1);
//        l2.add(1);
//        result.add(l2);
//        System.out.println(result.size());
//        System.out.println(result.get(1).get(0) + result.get(1).get(0));

    }
}
