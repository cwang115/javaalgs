package section11;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    /**
     * ??????//TODO
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grid = new boolean[9][9];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '1';
                int x = 3 * (i / 3) + num / 3;
                int y = 3 * (j / 3) + num % 3;
                if (rows[i][num] || cols[num][j] || grid[x][y]) {
                    return false;
                }

                rows[i][num] = true;
                cols[num][j] = true;
                grid[x][y] = true;
            }
        }

        return true;
    }


}
