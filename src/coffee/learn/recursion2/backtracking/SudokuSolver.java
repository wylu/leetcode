package coffee.learn.recursion2.backtracking;

/**
 * @File    :   SudokuSolver.java
 * @Time    :   2020/05/12 22:51:22
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        fill(board, 0, 0);
    }

    private boolean fill(char[][] board, int x, int y) {
        for (int i = x; i < 9; i++, y = 0) {  // reset y
            for (int j = y; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (!check(board, ch, i, j)) continue;
                    board[i][j] = ch;
                    if (fill(board, i, j + 1)) return true;
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    private boolean check(char[][] board, char ch, int x, int y) {
        for (int i = 0, cx = (x / 3) * 3, cy = (y / 3) * 3; i < 9; i++) {
            if (board[x][i] == ch || board[i][y] == ch
                    || board[cx + i / 3][cy + i % 3] == ch) return false;
        }
        return true;
    }
}