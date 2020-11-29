public class wordSearch {
    /*
    Given an m x n board and a word, find if the word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or
    vertically neighboring. The same letter cell may not be used more than once.

    Example 1:
    Input: board = [["A","B","C","E"],
                    ["S","F","C","S"],
                    ["A","D","E","E"]], word = "ABCCED"
    Output: true

    Example 2:
    Input: board = [["A","B","C","E"],
                    ["S","F","C","S"],
                    ["A","D","E","E"]], word = "SEE"
    Output: true

    Example 3:
    Input: board = [["A","B","C","E"],
                    ["S","F","C","S"],
                    ["A","D","E","E"]], word = "ABCB"
    Output: false

    Constraints:
        m == board.length
        n = board[i].length
        1 <= m, n <= 200
        1 <= word.length <= 10^3
        board and word consists only of lowercase and uppercase English letters.
     */
    public boolean exist(char[][] board, String word) {
        /*
            iterate through the board and once we encounter the first letter in the word, we do a DFS search to
            check if there is a path from from i,j that gets us the word
        */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int letterCount) {
        //first we check if we have found all the letters in the target word
        if (letterCount == word.length()) {
            return true;
        }
        //check if we are out of bounds in the grid
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != word.charAt(letterCount)) {
            return false;
        }

        /*
            since we don't want to double count a character in the board, we need to mark it as visited, so we save the
            character in a temp variable, mark the cell as ' ' and later return the cell to its original value
        */
        char temp = board[i][j];
        board[i][j] = ' ';

        //We search in all directions to check if there is a path that leads to the creation of the word "word"
        boolean found = dfs(board, i + 1, j, word, letterCount + 1)       //search down
                || dfs(board, i - 1, j, word, letterCount + 1)            //search up
                || dfs(board, i, j - 1, word, letterCount + 1)            //search left
                || dfs(board, i, j + 1, word, letterCount + 1);           //search right

        //switch the board value back to its original value
        board[i][j] = temp;

        return found;
    }
}
