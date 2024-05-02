/**
 * Leetcode 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/description/
 */
public class LC130 {
    /**
     * Graph, Depth-first Search solution
     * Let m be the number of rows in the board, n be the number of columns in the board
     * Time: O(m * n); Space: O(m * n)
     * @param board input regions
     */
    public void solve(char[][] board) {
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        // label the O's at 4 edges
        int row = board.length;
        int col = board[0].length;
        // lable left and right boarder
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O')
                dfs(true, board, directions, i, 0, row, col);
            if (board[i][col - 1] == 'O')
                dfs(true, board, directions, i, col - 1, row, col);
        }
        // label up and down boarder
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O')
                dfs(true, board, directions, 0, j, row, col);
            if (board[row - 1][j] == 'O')
                dfs(true, board, directions, row - 1, j, row, col);
        }

        // label other O's on board
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (board[i][j] == 'O')
                    dfs(false, board, directions, i, j, row, col);
            }
        }

        // flip the labeled O's (now is 'A') back to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    /**
     * Helper depth first search function called by solve
     * @param atBoarder if we are labeling cells at 4 edges (not directly surrounded); if true, label the cell as 'A', otherwise as 'X
     * @param board input regions
     * @param directions  4 directions: up, down, left, right
     * @param x the current row index we are visiting
     * @param y the current col index we are visiting
     * @param row number of rows on board
     * @param col number of columns on board
     */
    private void dfs(boolean atBoarder, char[][] board, int[][] directions, int x, int y, int row, int col) {
        // base cases
        // cell coordinate out of range
        if (x < 0 || x >= row || y < 0 || y >= col)
            return;
        // cell is not 'X' or has been visited
        if (board[x][y] == 'X' || board[x][y] == 'A')
            return;

        // recursive cases
        if (atBoarder) {
            board[x][y] = 'A';
        } else {
            board[x][y] = 'X';
        }
        // search along up, down, left, and right 4 directions
        for (int[] direction : directions) {
            int newx = x + direction[0];
            int newy = y + direction[1];
            dfs(atBoarder, board, directions, newx, newy, row, col);
        }
    }

}
