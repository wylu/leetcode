package learn.recursion2.backtracking;

/**
 * @File    :   NQueensII.java
 * @Time    :   2020/05/12 22:24:08
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class NQueensII {
    public int totalNQueens(int n) {
        return dfs(new boolean[n][n], n, 0);
    }

    private int dfs(boolean[][] cb, int n, int row) {
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (!check(cb, n, row, col)) continue;
            cb[row][col] = true;
            if (row == n - 1) count++;
            else count += dfs(cb, n, row + 1);
            cb[row][col] = false;
        }
        return count;
    }

    private boolean check(boolean[][] cb, int n, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (cb[i][col]) return false;
            int left = col - row + i, right = col + row - i;
            if (left >= 0 && cb[i][left]) return false;
            if (right < n && cb[i][right]) return false;
        }
        return true;
    }
}