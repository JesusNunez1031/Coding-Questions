import java.util.HashSet;
import java.util.Set;

public class validSudoku {
    /*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    Note:
    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.


    Example 1:
    Input: board =
    [["5","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
    Output: true

    Example 2:
    Input: board =
    [["8","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
    Output: false
    Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two
    8's in the top left 3x3 sub-box, it is invalid.


    Constraints:
        board.length == 9
        board[i].length == 9
        board[i][j] is a digit or '.'.
     */
    //TC: O(n^2)
    public static boolean isValidSudoku(char[][] board) {

        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //check if the character is not empty
                if (board[i][j] != '.') {
                    //add the row and column of the current integer, also add the block where its found to check for duplicate integers in blocks
                    if (!set.add(board[i][j] + " found in row " + i) ||
                            !set.add(board[i][j] + " found in column " + j) ||
                            !set.add(board[i][j] + " block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //More Efficient method, however more space used | TC: O(n^2) SC: O(n^2)
    public boolean isValidSudokuMap(char[][] board) {
        int n = 9;
        // A hashset for each row and column in the board, keep track of seen values
        HashSet<Character>[] row = new HashSet[n];
        HashSet<Character>[] col = new HashSet[n];

        /*
            A hashset for each row and column in a sub-box of a board, also used to keep track of seen values. Each cell
            represents a sub-box
         */
        HashSet<Character>[][] sub = new HashSet[3][3];

        // initialize hashsets
        for (int i = 0; i < n; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sub[i][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c != '.') {
                    // calculate the location of the current sub-box
                    int x = (i / 3), y = (j / 3);
                    //not being able to add to a row, column, or sub-box means we're at a duplicate value hence board is invalid
                    if (!row[i].add(c) || !col[j].add(c) || !sub[x][y].add(c)) {
                        return false;
                    }
                }
            }
        }
        // board was valid
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'.', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

//        char[][] board = {
//                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
//                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
//                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
//                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
//                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
//                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
//                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};

//        char[][] board = {
//                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        System.out.println(isValidSudoku(board));
    }
}
